package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrcPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaNrcRepository extends JpaRepository<MatriculaNrc, MatriculaNrcPK> {

    List<MatriculaNrc> findByMatriculaPeriodoNombreLikeAndMatriculaPersonaNombreCompletoLikeAndEstadoOrderByNrcNombre(
            String periodo, String estudianteNombre, String estado);

    MatriculaNrc findByPkCodMatriculaAndPkCodNrcAndPkCodPersona(String codMatricula, Integer codNrc,
            Integer codPersona);

    List<MatriculaNrc> findByMatriculaPeriodoNombreLikeAndPkCodPersonaAndEstado(String periodo,
            Integer nombre, String estado);
}
