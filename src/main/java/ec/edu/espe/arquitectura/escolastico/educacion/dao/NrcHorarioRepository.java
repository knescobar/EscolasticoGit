package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorarioPK;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NrcHorarioRepository extends JpaRepository<NrcHorario, NrcHorarioPK> {

    NrcHorario findByNrcHorarioPkCodPeriodoAndNrcHorarioPkCodAulaAndNrcHorarioPkDiaSemanaAndHoraInicioAndHoraFin(
            Integer periodo, Integer aula, String dia, Date horaI, Date horaF);

}
