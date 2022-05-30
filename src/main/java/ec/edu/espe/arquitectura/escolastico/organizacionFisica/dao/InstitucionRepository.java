package ec.edu.espe.arquitectura.escolastico.organizacionFisica.dao;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Institucion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitucionRepository extends JpaRepository<Institucion, Short> {

    Institucion findByRuc(String ruc);

    List<Institucion> findByNombreComercialLike(String nombrePattern);

}
