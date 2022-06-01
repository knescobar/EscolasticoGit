package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NrcRepository extends JpaRepository<Nrc, NrcPK> {

    List<Nrc> findByPeriodoNombreAndNombreLikeOrderByNombre(String periodo, String materia);
    
    List<Nrc> findByPeriodoNombre(String periodo);
    
    List<Nrc> findByPeriodoNombreAndPersonaNombreCompletoLikeOrderByNombre(String periodo,String docente);

}
