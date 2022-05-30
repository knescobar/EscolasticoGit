package ec.edu.espe.arquitectura.escolastico.general.dao;

import ec.edu.espe.arquitectura.escolastico.general.model.PaisEstructura;
import ec.edu.espe.arquitectura.escolastico.general.model.PaisEstructuraPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisEstructuraRepository extends JpaRepository<PaisEstructura, PaisEstructuraPK> {

    List<PaisEstructura> findByNombreLike(String nombrePattern);

}
