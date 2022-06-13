package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.stream.Collectors;

import ec.edu.espe.arquitectura.escolastico.educacion.exception.CuposInsuficientesException;
import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.TipoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcHorarioRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.escolastico.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CrearException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NrcService {
    private final NrcRepository nrcRepository;
    private final PersonaRepository personaRepository;
    private final NrcHorarioRepository nrcHorarioRepository;
    private final MateriaRepository materiaRepository;

    public List<Nrc> listarNrc() {
        return this.nrcRepository.findAll();
    }

    public void crear(Nrc nrc) {
        Persona persona = this.personaRepository.findById(nrc.getPersona().getCodPersona())
                .orElseThrow(() -> new CrearException("Error, no existe el docente"));

        boolean esDocente = persona.getTipoPersona().getCodTipoPersona().equals(TipoPersonaEnum.DOCENTE.getValor());
        if (!esDocente) {
            throw new CrearException("Error, el usuario seleccionado no es docente");
        }

        List<NrcHorario> horariosDocentePeriodo = this.nrcHorarioRepository
                .findByNrcPersonaCodPersonaAndNrcPeriodoCodPeriodo(
                        persona.getCodPersona(), nrc.getPk().getCodPeriodo());

        if (!horariosDocentePeriodo.isEmpty()) {
            boolean isDocenteOcupado = isHorarioOcupado(horariosDocentePeriodo, nrc.getHorario());
            if (isDocenteOcupado) {
                throw new CrearException("Error, docente ocupado");
            }
        }

        List<Integer> codAulas = nrc.getHorario()
                .stream()
                .map(n -> n.getPk().getCodAula())
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.toList());

        for (Integer codAula : codAulas) {
            List<NrcHorario> horarioAula = this.nrcHorarioRepository.findByNrcHorarioPkCodAulaAndNrcPeriodoCodPeriodo(
                    codAula, nrc.getPk().getCodPeriodo());

            boolean isAulaOcupada = isHorarioOcupado(horarioAula, nrc.getHorario());
            if (isAulaOcupada) {
                throw new CrearException("El aula se encuentra ocupada en el horario indicado.");
            }
        }

        Materia materiaDB = this.materiaRepository.findByPkCodMateria(nrc.getPk().getCodMateria());
        nrc.setNombre(materiaDB.getNombre());
        this.nrcRepository.save(nrc);
        this.nrcHorarioRepository.saveAll(nrc.getHorario());
    }

    private boolean isHorarioOcupado(List<NrcHorario> horarioA, List<NrcHorario> horarioB) {
        return horarioA.stream()
                .filter(ha -> horarioB.stream()
                        .anyMatch(hb -> ha.getPk().getDiaSemana()
                                .equals(hb.getPk().getDiaSemana()) &&
                                ha.getHoraInicio().equals(hb.getHoraInicio()) &&
                                ha.getHoraFin().equals(hb.getHoraFin())))
                .collect(Collectors.toList())
                .size() != 0;
    }

    public void verificarDisponibilidadCuposNRCs(List<Nrc> nrcsInscritos) {
        for (Nrc nrc : nrcsInscritos) {
            if (nrc.getCupoDisponible().equals(0)) {
                throw new CuposInsuficientesException(
                        "El NRC " + nrc.getPk().getCodNrc() + " no tiene cupos disponibles");
            }
        }
    }

    public Nrc tomarUnCupoEnNRC(Nrc nrc) {
        nrc.setCupoDisponible(nrc.getCupoDisponible() - 1);
        nrc.setCupoRegistrado(nrc.getCupoRegistrado() + 1);

        return nrc;
    }
}
