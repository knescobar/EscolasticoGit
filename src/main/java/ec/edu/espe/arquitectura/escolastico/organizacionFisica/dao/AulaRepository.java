package ec.edu.espe.arquitectura.escolastico.organizacionFisica.dao;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Aula;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Edificio;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.EdificioBloque;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaRepository extends JpaRepository<Aula, Integer>{
    
    List<Aula> findByEdificioAndEdificioBloque(Edificio edificio, EdificioBloque bloque);
    
}
