package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    List<Persona> findByNombreCompletoLikeOrderByNombreCompleto(String nombreCompletoPattern);

    Persona findByIdentificacion(String identificacion);

    Persona findByEmailOrEmailAlterno(String email, String emailAlterno);

    List<Persona> findByGenero(String genero);

    List<Persona> findByEstado(String estado);

}
