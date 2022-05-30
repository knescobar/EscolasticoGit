package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.TipoDocumento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, String>{
    
    List<TipoDocumento> findByNombreLike(String nombrePattern);
    
}
