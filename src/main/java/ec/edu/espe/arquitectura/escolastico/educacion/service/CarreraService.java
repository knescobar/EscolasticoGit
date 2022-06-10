package ec.edu.espe.arquitectura.escolastico.educacion.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.CarreraRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MallaCarreraRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CrearException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarreraService {

    private final CarreraRepository carreraRepository;
    private final MallaCarreraRepository mallaCarreraRepository;

    public Carrera obtenerPorCodigo(Integer codigo) {
        Optional<Carrera> carreraOpt = this.carreraRepository.findById(codigo);
        if (carreraOpt.isPresent()) {
            return carreraOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Carrera carrera) {
        if (carrera.getDepartamento() == null) {
            throw new CrearException(
                    "Error al crear la carrera, el departamento es requerido");
        } else if (carrera.getMallaCarrera() == null
                || carrera.getMallaCarrera().isEmpty()) {
            throw new CrearException(
                    "Error al crear la carrera, la malla es requerida");
        }

        this.carreraRepository.save(carrera);
        this.mallaCarreraRepository.saveAll(carrera.getMallaCarrera());
    }

    public void modificar(Carrera carrera) {
        Carrera carreraDB = this.obtenerPorCodigo(carrera.getCodCarrera());
        carreraDB.setNombre(carrera.getNombre());
        carreraDB.setTotalSemestres(carrera.getTotalSemestres());
        carreraDB.setGrado(carrera.getGrado());
        carreraDB.setPerfilProfesional(carrera.getPerfilProfesional());
        carreraDB.setNivel(carrera.getNivel());
        carreraDB.setTotalCreditos(carrera.getTotalCreditos());
        carreraDB.setTotalHoras(carrera.getTotalHoras());
        carreraDB.setSiglas(carrera.getSiglas());
        carreraDB.setPrecioCredito(carrera.getPrecioCredito());
        carreraDB.setMallaCarrera(carrera.getMallaCarrera());
        this.carreraRepository.save(carreraDB);
    }

    public List<Carrera> listarCarreraNivel(String nivel) {
        return this.carreraRepository.findByNivelOrderByNombre(nivel);
    }

    public List<Carrera> listarCarreraModalidad(String modalidad) {
        return this.carreraRepository.findByModalidadOrderByNombre(modalidad);
    }

}
