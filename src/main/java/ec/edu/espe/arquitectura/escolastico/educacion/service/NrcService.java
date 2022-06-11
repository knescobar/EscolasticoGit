package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcHorarioRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
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

    public void crear(Nrc nrc) {

        Optional<Persona> personaOpt = this.personaRepository.findById(nrc.getPersona().getCodPersona());
        Persona persona = this.personaRepository.findByCodPersona(nrc.getPersona().getCodPersona());
        if (!personaOpt.isPresent()) {
            throw new CrearException(
                    "Error, no existe el docente");
        }
        if (!persona.getTipoPersona().getCodTipoPersona().equals("DOC")) {
            throw new CrearException(
                    "Error, el usuario seleccionado no es docente");

        }

        this.nrcRepository.save(nrc);

        nrc.getHorario().forEach(
                (t) -> {
                    if (this.nrcHorarioRepository
                            .findByNrcHorarioPkCodPeriodoAndNrcHorarioPkCodAulaAndNrcHorarioPkDiaSemanaAndHoraInicioAndHoraFin(
                                    t.getPk().getCodPeriodo(), t.getPk().getCodAula(), t.getPk().getDiaSemana(),
                                    t.getHoraInicio(), t.getHoraFin()) != null) {

                        this.nrcHorarioRepository.save(t);
                    } else {
                        throw new CrearException(
                                "Error, horario ocupado");
                    }
                });

    }

    public List<Nrc> listarNrc() {
        return this.nrcRepository.findAll();
    }

}