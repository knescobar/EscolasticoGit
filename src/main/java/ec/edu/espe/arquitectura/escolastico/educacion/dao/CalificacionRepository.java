package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.escolastico.educacion.model.CalificacionPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepository extends JpaRepository<Calificacion, CalificacionPK> {

    List<Calificacion> findByPkCodPersonaOrderByMatriculaNrcNrcNombre(Integer codPersona);

    List<Calificacion> findByPkCodPersonaAndPkCodNrcOrderByMatriculaNrcNrcNombre(Integer codPersona, Integer codNrc);

    List<Calificacion> findByPkCodNrc(Integer nrc);

}
