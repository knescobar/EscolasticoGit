package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.TipoPersona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPersonaRepository extends JpaRepository<TipoPersona, String> {

    List<TipoPersona> findByNombreLike(String nombrePattern);

    List<TipoPersona> findByEstado(String estado);

    List<TipoPersona> findByNombreLikeAndEstado(String nombrePattern, String estado);
}
