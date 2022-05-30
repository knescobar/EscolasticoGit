package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository  extends JpaRepository<Matricula, MatriculaPK>{
    
}
