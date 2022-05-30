package ec.edu.espe.arquitectura.escolastico.general.dao;

import ec.edu.espe.arquitectura.escolastico.general.model.Reglas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReglasRepository extends JpaRepository<Reglas, String> {

    List<Reglas> findByClasificacionLike(String clasificacionPattern);

}
