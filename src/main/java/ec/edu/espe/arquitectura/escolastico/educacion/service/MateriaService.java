package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.PrerequisitoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MateriaPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Prerequisito;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MateriaService {

    private final MateriaRepository materiaRepository;
    private final PrerequisitoRepository prerequisitoRepository;

    public List<Materia> listarMateriaDepartamento(String departamento) {
        return this.materiaRepository.findByDepartamentoNombreLikeOrderByNombre(departamento);
    }

    public void crear(Materia materia) {
        this.materiaRepository.save(materia);

        this.prerequisitoRepository.saveAll(materia.getPrerequisito());
    }

    public void modificar(Materia materia) {
        Materia materiaDB = this.obtenerPorCodigo(materia.getPk());
        materiaDB.setNombre(materia.getNombre());
        materiaDB.setCreditos(materia.getCreditos());
        materiaDB.setHoras(materia.getHoras());
        materiaDB.setPonderacion(materia.getPonderacion());
        materiaDB.setPrerequisito(materia.getPrerequisito());
        this.materiaRepository.save(materiaDB);
    }

    public Materia obtenerPorCodigo(MateriaPK pk) {
        Optional<Materia> materiaOpt = this.materiaRepository.findById(pk);
        if (materiaOpt.isPresent()) {
            return materiaOpt.get();
        } else {
            return null;
        }
    }

}
