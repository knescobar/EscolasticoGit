package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Funcionalidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionalidadRepository extends JpaRepository<Funcionalidad, Integer> {

    List<Funcionalidad> findByEstado(String estado);

    List<Funcionalidad> findByModuloAndEstado(String codModulo, String estado);

}
