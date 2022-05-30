package ec.edu.espe.arquitectura.escolastico.organizacionFisica.dao;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.EdificioBloque;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioBloqueRepository extends JpaRepository<EdificioBloque, String>{
    
     List<EdificioBloque> findByNombreBloqueLike(String nombrePattern);
     
}
