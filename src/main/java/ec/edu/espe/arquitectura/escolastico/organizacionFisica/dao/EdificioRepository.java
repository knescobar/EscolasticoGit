package ec.edu.espe.arquitectura.escolastico.organizacionFisica.dao;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Edificio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, String> {
    
    List<Edificio> findByNombreLike(String nombrePattern);
 
    List<Edificio> findByPoseeAulas(String poseeAulas);
    
}
