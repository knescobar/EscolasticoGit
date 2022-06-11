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

    public void modificar(Departamento departameto) {
        Departamento departamentoDb = obtenerPorCodigoOLanzarNoEncontrado(
                departameto.getCodDepartamento());

        departamentoDb.setNombre(departameto.getNombre());
        departamentoDb.setDescripcion(departameto.getDescripcion());
        departamentoDb.setSiglas(departameto.getSiglas());
        departamentoDb.setCarreras(departameto.getCarreras());
        departamentoDb.setMaterias(departameto.getMaterias());

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