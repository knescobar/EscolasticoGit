package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.seguridad.dao.FuncionalidadRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.enums.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Funcionalidad;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionalidadService {

    private final FuncionalidadRepository funcionalidadRepository;

    public Funcionalidad obtenerPorCodigo(Integer codigo) {
        Optional<Funcionalidad> funcionalidadOpt = this.funcionalidadRepository.findById(codigo);
        if (funcionalidadOpt.isPresent()) {
            return funcionalidadOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Funcionalidad funcionalidad) {
        funcionalidad.setEstado(EstadosEnum.INACTIVO.getValor());
        this.funcionalidadRepository.save(funcionalidad);
    }

    public void modificar(Funcionalidad funcionalidad) {
        Funcionalidad funcionalidadDB = this.obtenerPorCodigo(funcionalidad.getCodFuncionalidad());
        funcionalidadDB.setNombre(funcionalidad.getNombre());
        funcionalidadDB.setEstado(funcionalidad.getEstado());
        funcionalidadDB.setDescripcion(funcionalidad.getDescripcion());
        funcionalidadDB.setModulo(funcionalidad.getModulo());
        funcionalidadDB.setUrlPrincipal(funcionalidad.getUrlPrincipal());
        funcionalidadDB.setAudFecha(new Date());
        this.funcionalidadRepository.save(funcionalidadDB);
    }

    public List<Funcionalidad> listarFuncionalidadesActivas() {
        return this.funcionalidadRepository.findByEstado(EstadosEnum.ACTIVO.getValor());
    }
}