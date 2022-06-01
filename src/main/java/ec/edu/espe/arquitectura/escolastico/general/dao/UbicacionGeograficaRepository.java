package ec.edu.espe.arquitectura.escolastico.general.dao;

import ec.edu.espe.arquitectura.escolastico.general.model.UbicacionGeografica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionGeograficaRepository extends JpaRepository<UbicacionGeografica, Integer> {

    List<UbicacionGeografica> findByNombreLike(String nombrePattern);

    List<UbicacionGeografica> findByPaisEstructuraAndUbicacionGeoPadre(Integer nivel, Integer ubicacionGeografica);

}
