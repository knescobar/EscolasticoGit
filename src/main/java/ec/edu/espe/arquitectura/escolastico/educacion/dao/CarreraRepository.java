package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    List<Carrera> findByNombreLikeOrderByNombre(String nombrePattern);

    List<Carrera> findByNivelOrderByNombre(String nivel);

    List<Carrera> findByModalidadOrderByNombre(String modalidad);

}
