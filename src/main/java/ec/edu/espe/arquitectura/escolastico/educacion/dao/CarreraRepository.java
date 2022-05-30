package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    List<Carrera> findByNombreLike(String nombrePattern);

    List<Carrera> findByNivel(String nivel);

    List<Carrera> findByModalidad(String modalidad);

}
