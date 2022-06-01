package ec.edu.espe.arquitectura.escolastico.organizacionFisica.dao;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Aula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaRepository extends JpaRepository<Aula, Integer> {

    List<Aula> findByEdificioCodEdificioAndBloqueCodEdificioBloque(String edificio, String bloque);
    
    List<Aula> findByTipoAulaDescripcionLikeOrderByTipoAulaDescripcion(String tipo);

}
