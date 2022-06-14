package ec.edu.espe.arquitectura.escolastico.educacion.service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.*;
import ec.edu.espe.arquitectura.escolastico.educacion.dto.MatriculaDto;
import ec.edu.espe.arquitectura.escolastico.educacion.enums.EstadoMatriculaEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.enums.TipoMatriculaEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.enums.TipoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.model.*;
import ec.edu.espe.arquitectura.escolastico.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.ActualizarException;
import ec.edu.espe.arquitectura.escolastico.shared.exception.CrearException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatriculaService {
    private static final BigDecimal VALOR_PRIMERA_MATRICULA = BigDecimal.ZERO;
    private final CarreraRepository carreraRepository;
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

    public void crear(MatriculaDto matriculaDto) {
        Persona persona = this.personaRepository.findById(matriculaDto.getCodPersona())
                .orElseThrow(() -> new CrearException("Error, no existe el estudiante"));
        Periodo periodo = this.periodoRepository.findById(matriculaDto.getCodPeriodo())
                .orElseThrow(() -> new CrearException("Error, no existe el período indicado"));
        Carrera carrera = this.carreraRepository.findById(matriculaDto.getCodCarrera())
                .orElseThrow(() -> new CrearException("Error, no existe la carrera indicada"));

        boolean esEstudiante = persona.getTipoPersona().getCodTipoPersona()
                .equals(TipoPersonaEnum.ESTUDIANTE.getValor());
        if (!esEstudiante) {
            throw new CrearException("Error, el usuario seleccionado no es estudiante");
        }

        verificarNumeroNrcsEnTerceraMatricula(matriculaDto.getTipo(), matriculaDto.getMatriculaNrcPKs().size());

        String codMatricula = obtenerCodigoMatricula();
        boolean esPrimeraMatricula = matriculaDto.getTipo().equals(TipoMatriculaEnum.PRIMERA.getValor());

        List<Materia> materiasInscritas = obtenerMateriasPorPKs(matriculaDto.getMatriculaNrcPKs());
        List<Nrc> nrcsInscritos = obtenerNrcsPorPKs(matriculaDto.getMatriculaNrcPKs());
        List<MatriculaNrc> matriculaNrcs = new ArrayList<>();

        this.nrcService.verificarDisponibilidadCuposNRCsInscritos(nrcsInscritos);

        for (int i = 0; i < materiasInscritas.size(); i++) {
            nrcsInscritos.set(i, this.nrcService.tomarUnCupoEnNRC(nrcsInscritos.get(i)));

            MatriculaNrcPK matriculaNrcPK = matriculaDto.getMatriculaNrcPKs().get(i);
            matriculaNrcPK.setCodMatricula(codMatricula);

            BigDecimal precioCreditoCarrera = carrera.getPrecioCredito();
            BigDecimal numeroCreditosMateria = materiasInscritas.get(i).getCreditos();
            BigDecimal costoMatriculaNrc = esPrimeraMatricula
                    ? VALOR_PRIMERA_MATRICULA
                    : precioCreditoCarrera.multiply(numeroCreditosMateria);

            MatriculaNrc matriculaNrc = new MatriculaNrc(matriculaNrcPK);
            matriculaNrc.setEstado(EstadoMatriculaEnum.INSCRITO.getValor());
            matriculaNrc.setNumero(0);
            matriculaNrc.setCosto(costoMatriculaNrc);

            matriculaNrcs.add(matriculaNrc);
        }

        BigDecimal costoTotalMatricula = esPrimeraMatricula
                ? VALOR_PRIMERA_MATRICULA
                : calcularCostoTotalMatricula(materiasInscritas, carrera.getPrecioCredito());

        Matricula nuevaMatricula = new Matricula(
                new MatriculaPK(codMatricula, matriculaDto.getCodPersona()));
        nuevaMatricula.setMatriculaNrc(matriculaNrcs);
        nuevaMatricula.setTipo(matriculaDto.getTipo());
        nuevaMatricula.setCarrera(carrera);
        nuevaMatricula.setPeriodo(periodo);
        nuevaMatricula.setCosto(costoTotalMatricula);
        nuevaMatricula.setFecha(new Date());

        this.nrcRepository.saveAll(nrcsInscritos);
        this.matriculaRepository.save(nuevaMatricula);
    }

    private String obtenerCodigoMatricula() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    private List<Nrc> obtenerNrcsPorPKs(List<MatriculaNrcPK> matriculaNrcPKS) {
        List<NrcPK> nrcPKs = matriculaNrcPKS.stream()
                .map(mNPk -> new NrcPK(
                        mNPk.getCodNrc(),
                        mNPk.getCodPeriodo(),
                        mNPk.getCodDepartamento(),
                        mNPk.getCodMateria()
                ))
                .collect(Collectors.toList());
        return this.nrcRepository.findAllById(nrcPKs);
    }

    public void modificar(MatriculaDto matriculaDto) {
        Matricula matriculaDB = this.matriculaRepository.findById(
                        new MatriculaPK(matriculaDto.getCodMatricula(), matriculaDto.getCodPersona()))
                .orElseThrow(() -> new ActualizarException("Matrícula no encontrada"));

        verificarNumeroNrcsEnTerceraMatricula(matriculaDB.getTipo(), matriculaDto.getMatriculaNrcPKs().size());

        boolean esPrimeraMatricula = matriculaDto.getTipo().equals(TipoMatriculaEnum.PRIMERA.getValor());

        List<Nrc> antiguosNrcInscritos = nrcService.listarNrcsPorPKs(matriculaDB.getMatriculaNrc()
                .stream()
                .map(MatriculaNrc::getNrc)
                .map(Nrc::getPk)
                .collect(Collectors.toList()));

        antiguosNrcInscritos.replaceAll(nrcService::retornarUnCupoEnNRC);
        this.nrcRepository.saveAll(antiguosNrcInscritos);

        List<Materia> nuevasMateriasInscritas = obtenerMateriasPorPKs(matriculaDto.getMatriculaNrcPKs());
        List<Nrc> nrcsInscritos = obtenerNrcsPorPKs(matriculaDto.getMatriculaNrcPKs());
        List<MatriculaNrc> matriculaNrcs = new ArrayList<>();

        this.nrcService.verificarDisponibilidadCuposNRCsInscritos(nrcsInscritos);

        for (int i = 0; i < nuevasMateriasInscritas.size(); i++) {
            nrcsInscritos.set(i, this.nrcService.tomarUnCupoEnNRC(nrcsInscritos.get(i)));

            MatriculaNrcPK matriculaNrcPK = matriculaDto.getMatriculaNrcPKs().get(i);
            matriculaNrcPK.setCodMatricula(matriculaDB.getPk().getCodMatricula());

            BigDecimal precioCreditoCarrera = matriculaDB.getCarrera().getPrecioCredito();
            BigDecimal numeroCreditosMateria = nuevasMateriasInscritas.get(i).getCreditos();
            BigDecimal costoMatriculaNrc = esPrimeraMatricula
                    ? VALOR_PRIMERA_MATRICULA
                    : precioCreditoCarrera.multiply(numeroCreditosMateria);

            MatriculaNrc matriculaNrc = new MatriculaNrc(matriculaNrcPK);
            matriculaNrc.setEstado(EstadoMatriculaEnum.INSCRITO.getValor());
            matriculaNrc.setNumero(0);
            matriculaNrc.setCosto(costoMatriculaNrc);

            matriculaNrcs.add(matriculaNrc);
        }

        BigDecimal costoTotalMatricula = esPrimeraMatricula
                ? VALOR_PRIMERA_MATRICULA
                : calcularCostoTotalMatricula(nuevasMateriasInscritas, matriculaDB.getCarrera().getPrecioCredito());

        matriculaDB.setMatriculaNrc(matriculaNrcs);
        matriculaDB.setCosto(costoTotalMatricula);

        this.matriculaRepository.save(matriculaDB);
    }

    private BigDecimal calcularCostoTotalMatricula(List<Materia> materias, BigDecimal precioCreditoCarrera) {
        BigDecimal creditosTotales = materias.stream()
                .map(Materia::getCreditos)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return creditosTotales.multiply(precioCreditoCarrera);
    }

    private void verificarNumeroNrcsEnTerceraMatricula(String tipoMatricula, Integer nrcsSeleccionados) {
        if (tipoMatricula.equals(TipoMatriculaEnum.TERCERA.getValor()) && nrcsSeleccionados != 1) {
            throw new CrearException(
                    "Error por tercera matrícula, solo se permite un NRC");
        }
    }

    private List<Materia> obtenerMateriasPorPKs(List<MatriculaNrcPK> matriculaNrcs) {
        List<MateriaPK> materiaPKs = matriculaNrcs.stream()
                .map(matriculaNrcPK -> {
                    Integer codMateria = matriculaNrcPK.getCodMateria();
                    Integer codDepartamento = matriculaNrcPK.getCodDepartamento();
                    return new MateriaPK(codMateria, codDepartamento);
                })
                .collect(Collectors.toList());

        return this.materiaRepository.findAllById(materiaPKs);
    }


}
