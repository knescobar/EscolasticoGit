package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.PrerequisitoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MateriaPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.shared.exception.CrearException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MateriaService {

    private final MateriaRepository materiaRepository;
    private final PrerequisitoRepository prerequisitoRepository;
    private final NrcRepository nrcRepository;

    public List<Materia> listarMateriaDepartamento(String departamento) {
        return this.materiaRepository.findByDepartamentoNombreLikeOrderByNombre(departamento);
    }

    public void crear(Materia materia) {

        if (materia.getPrerequisito() != null) {
            boolean isMateria = materia.getPrerequisito().stream()
                    .filter(pr -> pr.getPrerequisito().getPk().equals(materia.getPk()))
                    .collect(Collectors.toList())
                    .size() != 0;
            if (isMateria) {
                throw new CrearException("Error, los prerequisitos no pueden ser la misma materia.");
            }
            this.materiaRepository.save(materia);
        } else {
            this.materiaRepository.save(materia);
        }
    }

    public void modificar(Materia materia) {
        Materia materiaDB = this.obtenerPorCodigo(materia.getPk());
        materiaDB.setNombre(materia.getNombre());
        materiaDB.setCreditos(materia.getCreditos());
        materiaDB.setHoras(materia.getHoras());
        materiaDB.setPonderacion(materia.getPonderacion());
        if (materia.getPrerequisito() != null) {
            boolean isMateria = materia.getPrerequisito().stream()
                    .filter(pr -> pr.getPrerequisito().getPk().equals(materia.getPk()))
                    .collect(Collectors.toList())
                    .size() != 0;
            if (isMateria) {
                throw new CrearException("Error, los prerequisitos no pueden ser la misma materia.");
            }
            materiaDB.setPrerequisito(materia.getPrerequisito());

        }
        List<Nrc> nrcModificar = this.nrcRepository.findByPkCodMateria(materiaDB.getPk().getCodMateria()).stream()
                .filter(nrc -> nrc.getMateria().getPk().getCodMateria().equals(materiaDB.getPk()
                        .getCodMateria()))
                .collect(Collectors.toList());

        if (nrcModificar.size() != 0) {
            nrcModificar.forEach(
                    nrc -> nrc.setNombre(materia.getNombre()));
            this.nrcRepository.saveAll(nrcModificar);
        }
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
