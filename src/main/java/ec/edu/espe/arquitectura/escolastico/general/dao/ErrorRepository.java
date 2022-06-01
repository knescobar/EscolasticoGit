package ec.edu.espe.arquitectura.escolastico.general.dao;

import ec.edu.espe.arquitectura.escolastico.general.model.Error;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository extends JpaRepository<Error, String> {

    List<Error> findByTituloLikeOrderByDescripcion(String tituloPattern);

}
