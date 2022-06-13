package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.EstadoMatriculaEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.TipoMatriculaEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.TipoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MatriculaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.PeriodoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.*;
import ec.edu.espe.arquitectura.escolastico.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CrearException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final MateriaRepository materiaRepository;
    private final NrcRepository nrcRepository;
    private final PersonaRepository personaRepository;
    private final PeriodoRepository periodoRepository;
    private final NrcService nrcService;

    public Matricula obtenerPorCodigo(MatriculaPK pk) {
        Optional<Matricula> matriculaOpt = this.matriculaRepository.findById(pk);
        return matriculaOpt.orElse(null);
    }

    public List<Matricula> listarMatriculasPersonaPeriodo(String periodo, String estudianteNombre) {
        return this.matriculaRepository.findByPeriodoNombreLikeAndPersonaNombreCompletoLikeOrderByFecha(periodo,
                estudianteNombre);
    }

    public List<Matricula> listarMatriculasPersona(String estudianteNombre) {
        return this.matriculaRepository
                .findByPersonaNombreCompletoLikeOrderByFecha(estudianteNombre);
    }

    public void crear(Matricula matricula) {
        Persona persona = this.personaRepository.findById(matricula.getPk().getCodPersona())
                .orElseThrow(() -> new CrearException("Error, no existe el estudiante"));
        Periodo periodo = this.periodoRepository.findById(matricula.getPeriodo().getCodPeriodo())
                .orElseThrow(() -> new CrearException("Error, no existe el período indicado"));

        boolean esEstudiante = persona.getTipoPersona().getCodTipoPersona()
                .equals(TipoPersonaEnum.ESTUDIANTE.getValor());
        if (!esEstudiante) {
            throw new CrearException("Error, el usuario seleccionado no es estudiante");
        }

        if (matricula.getCarrera() == null) {
            throw new CrearException(
                    "Error al crear la matricula, la carrera es requerida");
        }

        if (matricula.getMatriculaNrc() == null || matricula.getMatriculaNrc().isEmpty()) {
            throw new CrearException(
                    "Error al crear la matrícula, los NRCs son requeridos");
        }

        verificarNumeroNrcsEnTerceraMatricula(matricula.getTipo(), matricula.getMatriculaNrc().size());

        String codMatricula = obtenerCodigoMatricula();
        boolean esPrimeraMatricula = matricula.getTipo().equals(TipoMatriculaEnum.PRIMERA.getValor());

        List<Materia> materiasInscritas = obtenerMateriasPorPKs(matricula.getMatriculaNrc());
        List<Nrc> nrcsInscritos = obtenerNrcsPorPKs(matricula.getMatriculaNrc());
        List<MatriculaNrc> matriculaNrcs = new ArrayList<>();

        this.nrcService.verificarDisponibilidadCuposNRCs(nrcsInscritos);

        for (int i = 0; i < materiasInscritas.size(); i++) {
            nrcsInscritos.set(i, this.nrcService.tomarUnCupoEnNRC(nrcsInscritos.get(i)));

            MatriculaNrcPK matriculaNrcPK = matricula.getMatriculaNrc().get(i).getPk();
            matriculaNrcPK.setCodMatricula(codMatricula);

            BigDecimal precioCreditoCarrera = matricula.getCarrera().getPrecioCredito();
            BigDecimal numeroCreditosMateria = materiasInscritas.get(i).getCreditos();
            BigDecimal costoMatriculaNrc = esPrimeraMatricula
                    ? BigDecimal.ZERO
                    : precioCreditoCarrera.multiply(numeroCreditosMateria);

            MatriculaNrc matriculaNrc = new MatriculaNrc(matriculaNrcPK);
            matriculaNrc.setEstado(EstadoMatriculaEnum.INSCRITO.getValor());
            matriculaNrc.setNumero(0);
            matriculaNrc.setCosto(costoMatriculaNrc);

            matriculaNrcs.add(matriculaNrc);
        }

        BigDecimal costoTotalMatricula = esPrimeraMatricula
                ? BigDecimal.ZERO
                : calcularCostoTotalMatricula(materiasInscritas, matricula.getCarrera().getPrecioCredito());

        matricula.getPk().setCodMatricula(codMatricula);
        matricula.setMatriculaNrc(matriculaNrcs);
        matricula.setPeriodo(periodo);
        matricula.setCosto(costoTotalMatricula);
        matricula.setFecha(new Date());

        this.nrcRepository.saveAll(nrcsInscritos);
        this.matriculaRepository.save(matricula);
    }

    private String obtenerCodigoMatricula() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    private List<Nrc> obtenerNrcsPorPKs(List<MatriculaNrc> matriculaNrcs) {
        List<NrcPK> nrcPKs = matriculaNrcs.stream()
                .map(MatriculaNrc::getPk)
                .map(mNPk -> new NrcPK(
                       mNPk.getCodNrc(),
                       mNPk.getCodPeriodo(),
                       mNPk.getCodDepartamento(),
                       mNPk.getCodMateria()
                ))
                .collect(Collectors.toList());
        return this.nrcRepository.findAllById(nrcPKs);
    }

    public void modificar(Matricula matricula) {
        Matricula matriculaDB = this.obtenerPorCodigo(matricula.getPk());
        matriculaDB.setMatriculaNrc(matricula.getMatriculaNrc());

        verificarNumeroNrcsEnTerceraMatricula(matricula.getTipo(), matricula.getMatriculaNrc().size());

        List<Materia> materiasInscritas = obtenerMateriasPorPKs(matricula.getMatriculaNrc());
        BigDecimal costoNrc = matricula.getTipo().equals(TipoMatriculaEnum.PRIMERA.getValor())
                ? BigDecimal.ZERO
                : calcularCostoTotalMatricula(materiasInscritas, matricula.getCarrera().getPrecioCredito());

        // TODO: Asignar los costos

        this.matriculaRepository.save(matriculaDB);
    }

    private void verificarNumeroNrcsEnTerceraMatricula(String tipoMatricula, Integer nrcsSeleccionados) {
        if (tipoMatricula.equals(TipoMatriculaEnum.TERCERA.getValor()) && nrcsSeleccionados != 1) {
            throw new CrearException(
                    "Error por tercera matrícula, solo se permite un NRC");
        }
    }

    private List<Materia> obtenerMateriasPorPKs(List<MatriculaNrc> matriculaNrcs) {
        List<MateriaPK> materiaPKs = matriculaNrcs.stream()
                .map(matriculaNrc -> {
                    Integer codMateria = matriculaNrc.getPk().getCodMateria();
                    Integer codDepartamento = matriculaNrc.getPk().getCodDepartamento();
                    return new MateriaPK(codMateria, codDepartamento);
                })
                .collect(Collectors.toList());

        return this.materiaRepository.findAllById(materiaPKs);
    }

    private BigDecimal calcularCostoTotalMatricula(List<Materia> materias, BigDecimal precioCreditoCarrera) {
        BigDecimal creditosTotales = materias.stream()
                .map(Materia::getCreditos)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return creditosTotales.multiply(precioCreditoCarrera);
    }

}
