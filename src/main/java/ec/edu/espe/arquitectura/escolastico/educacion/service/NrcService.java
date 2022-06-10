package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CrearException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NrcService {

    private final NrcRepository nrcRepository;
    private final PersonaRepository personaRepository;

    public void crear(Nrc nrc) {
        Optional<Persona> perOpt = this.personaRepository.findById(nrc.getPersona().getCodPersona());
        if (!perOpt.isPresent()) {
            throw new CrearException(
                    "Error, usuario no existe");
        }

        if (!nrc.getPersona().getTipoPersona().getCodTipoPersona().equals("DOC")) {
            throw new CrearException(
                    "Error, el usuario seleccionado no es docente");

        }
        this.nrcRepository.save(nrc);
    }

}
