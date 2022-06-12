package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.CalificacionRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.escolastico.educacion.model.CalificacionPK;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CrearException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalificacionService {
    private final CalificacionRepository calificacionRepository;

    public Calificacion obtenerPorCodigo(CalificacionPK pk) {
        Optional<Calificacion> calificacionOpt = this.calificacionRepository.findById(pk);
        if (calificacionOpt.isPresent()) {
            return calificacionOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Calificacion calificacion) {
        BigDecimal promedio = new BigDecimal(0);

        if (calificacion.getPk() == null) {
            throw new CrearException(
                    "Error al crear la calificacion, la información de la matrícula y estudiante es requerida");
        }

        if (calificacion.getMatriculaNrc() == null) {
            throw new CrearException(
                    "Error al crear la calificacion, la materia es requerida");
        }

        this.calificacionRepository.save(calificacion);
    }

    public void modificar(Calificacion calificacion) {
        Calificacion calificacionDB = this.obtenerPorCodigo(calificacion.getPk());
        this.calificacionRepository.save(calificacionDB);
    }

    public List<Calificacion> listarCalificacionesEstudianteNrc(Integer codPersona, Integer codNrc) {
        return this.calificacionRepository.findByPkCodPersonaAndPkCodNrcOrderByMatriculaNrcNrcNombre(codPersona,
                codNrc);
    }

    public List<Calificacion> listarCalifiacionesNrc(Integer codNrc) {
        return this.calificacionRepository.findByPkCodNrc(codNrc);
    }
}