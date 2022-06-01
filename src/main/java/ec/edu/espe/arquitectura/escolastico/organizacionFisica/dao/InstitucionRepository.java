package ec.edu.espe.arquitectura.escolastico.organizacionFisica.dao;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Institucion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitucionRepository extends JpaRepository<Institucion, Integer> {

    Institucion findByRuc(String ruc);

    List<Institucion> findByNombreComercialLike(String nombrePattern);

}
