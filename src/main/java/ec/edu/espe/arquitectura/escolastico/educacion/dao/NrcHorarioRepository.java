package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorarioPK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NrcHorarioRepository extends JpaRepository<NrcHorario, NrcHorarioPK> {
        List<NrcHorario> findByNrcPersonaCodPersonaAndNrcPeriodoCodPeriodo(
                        Integer codPersona, Integer codPeriodo);

        List<NrcHorario> findByNrcHorarioPkCodAulaAndNrcPeriodoCodPeriodo(
                        Integer codAula, Integer codPeriodo);
}
