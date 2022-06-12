package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.DepartamentoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.exception.NoEncontradoException;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    public Departamento obtenerPorCodigo(Integer codigo) {
        return obtenerPorCodigoOLanzarNoEncontrado(codigo);
    }

    public void crear(Departamento departamento) {
        this.departamentoRepository.save(departamento);
    }

    public void modificar(Departamento departamento) {
        Departamento departamentoDb = obtenerPorCodigoOLanzarNoEncontrado(
                departamento.getCodDepartamento());

        departamentoDb.setNombre(departamento.getNombre());
        departamentoDb.setDescripcion(departamento.getDescripcion());
        departamentoDb.setSiglas(departamento.getSiglas());
        departamentoDb.setCarreras(departamento.getCarreras());
        departamentoDb.setMaterias(departamento.getMaterias());

        this.departamentoRepository.save(departamentoDb);
    }

    public List<Departamento> listarDepartamentos() {
        return this.departamentoRepository.findAll();
    }

    private Departamento obtenerPorCodigoOLanzarNoEncontrado(Integer codigo) {
        return this.departamentoRepository.findById(codigo)
                .orElseThrow(() -> new NoEncontradoException(
                        "No se ha encontrado un departamento con el codigo: " + codigo));
    }
}