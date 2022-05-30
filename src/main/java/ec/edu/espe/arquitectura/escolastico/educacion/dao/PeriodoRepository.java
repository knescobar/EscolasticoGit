package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {

    List<Periodo> findByNombreLike(String nombrePattern);

    List<Periodo> findByNivel(String nivel);

}
