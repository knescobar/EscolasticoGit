package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.TipoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.TipoMatriculaEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MatriculaNrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MatriculaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaPK;
import ec.edu.espe.arquitectura.escolastico.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CrearException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final MatriculaNrcRepository matriculaNrcRepository;
    private final PersonaRepository personaRepository;

    public Matricula obtenerPorCodigo(MatriculaPK pk) {
        Optional<Matricula> matriculaOpt = this.matriculaRepository.findById(pk);
        if (matriculaOpt.isPresent()) {
            return matriculaOpt.get();
        } else {
            return null;
        }
    }

    public List<Matricula> listarMatriculasPersonaPeriodo(String periodo, String estudianteNombre) {
        return this.matriculaRepository.findByPeriodoNombreLikeAndPersonaNombreCompletoLikeOrderByFecha(periodo,
                estudianteNombre);
    }

    public void crear(Matricula matricula) {
        Persona persona = this.personaRepository.findById(matricula.getPersona().getCodPersona())
                .orElseThrow(() -> new CrearException("Error, no existe el estudiante"));

        boolean esEstudiante = persona.getTipoPersona().getCodTipoPersona()
                .equals(TipoPersonaEnum.ESTUDIANTE.getValor());
        if (!esEstudiante) {
            throw new CrearException("Error, el usuario seleccionado no es estudiante");
        }

        if (matricula.getCarrera() == null) {
            throw new CrearException(
                    "Error al crear la matricula, la matricula es requerida");
        }

        if (matricula.getMatriculaNrc() == null ||
                matricula.getMatriculaNrc().isEmpty()) {
            throw new CrearException(
                    "Error al crear la matrícula, los NRCs son requeridos");
        }

        verificarTipoMatricula(matricula);
        matricula.setFecha(new Date());
        this.matriculaRepository.save(matricula);
        this.matriculaNrcRepository.saveAll(matricula.getMatriculaNrc());
    }

    public void modificar(Matricula matricula) {
        Matricula matriculaDB = this.obtenerPorCodigo(matricula.getPk());
        matriculaDB.setMatriculaNrc(matricula.getMatriculaNrc());
        verificarTipoMatricula(matricula);
        this.matriculaRepository.save(matriculaDB);
    }

    private void verificarTipoMatricula(Matricula matricula) {
        if (!matricula.getTipo().equals(TipoMatriculaEnum.PRIMERA.getValor())) {
            matricula.setCosto(calcularCostoTotalMatricula(matricula));
        } else {
            matricula.setCosto(new BigDecimal(0));
        }

        if (matricula.getTipo().equals(TipoMatriculaEnum.TERCERA.getValor())
                && matricula.getMatriculaNrc().size() != 1) {
            throw new CrearException(
                    "Error por tercera matrícula, solo se permite un NRC");
        }
    }

    private BigDecimal calcularCostoTotalMatricula(Matricula matricula) {
        BigDecimal creditosTotales = new BigDecimal(0);
        for (MatriculaNrc nrc : matricula.getMatriculaNrc()) {
            creditosTotales = creditosTotales.add(nrc.getNrc().getMateria().getCreditos());
            nrc.setCosto(matricula.getCarrera().getPrecioCredito().multiply(
                    nrc.getNrc().getMateria().getCreditos()));
        }
        creditosTotales.multiply(matricula.getCarrera().getPrecioCredito());
        return creditosTotales;
    }
}