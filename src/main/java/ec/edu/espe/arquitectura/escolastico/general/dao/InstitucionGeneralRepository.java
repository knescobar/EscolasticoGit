package ec.edu.espe.arquitectura.escolastico.general.dao;

import ec.edu.espe.arquitectura.escolastico.general.model.InstitucionGeneral;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitucionGeneralRepository extends JpaRepository<InstitucionGeneral, String> {

    InstitucionGeneralRepository findByRuc(String ruc);

    List<InstitucionGeneralRepository> findByNombreComercialLikeOrderByNombreComercial(String nombrePattern);

}
