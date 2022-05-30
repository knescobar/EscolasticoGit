package ec.edu.espe.arquitectura.escolastico.organizacionFisica.dao;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Sede;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SedeRepository  extends JpaRepository<Sede, String>{
    
    List<Sede> findByNombreLike(String nombrePattern);
    
    List<Sede> findByEsPrincipal(String esPrincipal);
    
}
