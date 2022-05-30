package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.TipoDiscapacidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDiscapacidadRepository extends JpaRepository<TipoDiscapacidad, String> {

    List<TipoDiscapacidad> findByNombreLike(String nombrePattern);

}
