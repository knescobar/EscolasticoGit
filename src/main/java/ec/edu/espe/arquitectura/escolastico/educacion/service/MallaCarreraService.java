package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.MallaCarreraRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CrearException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MallaCarreraService {

    private final MateriaRepository materiaRepository;
    private final MallaCarreraRepository mallaCarreraRepository;

    public MallaCarrera obtenerPorCodigo(Integer codigo) {
        Optional<MallaCarrera> mallamallaCarreraOpt = this.mallaCarreraRepository.findById(codigo);
        if (mallamallaCarreraOpt.isPresent()) {
            return mallamallaCarreraOpt.get();
        } else {
            return null;
        }
    }

    public List<MallaCarrera> listarMaLlaCarrera(String carrera) {
        return this.mallaCarreraRepository.findByCarreraNombreLikeOrderByNivel(carrera);
    }

    public void crear(MallaCarrera mallaCarrera) {
        if (mallaCarrera.getCarrera() == null) {
            throw new CrearException(
                    "Error al crear la malla, la carrera es requerida");
        }

        Optional<Materia> materiaOpt = this.materiaRepository.findById(mallaCarrera.getMateria().getPk());
        if (!materiaOpt.isPresent()) {
            throw new CrearException(
                    "Error al crear la malla, la materia no existe");
        }

        this.mallaCarreraRepository.save(mallaCarrera);
    }

    public void modificar(MallaCarrera mallaCarrera) {
        MallaCarrera mallaCarreraDB = this.obtenerPorCodigo(mallaCarrera.getCodMateriacarrera());
        mallaCarreraDB.setMateria(mallaCarrera.getMateria());
        mallaCarreraDB.setNivel(mallaCarrera.getNivel());
        this.mallaCarreraRepository.save(mallaCarreraDB);
    }
}
