package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilFuncionalidadRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;

@Service
public class PerfilService {
    private PerfilRepository perfilRepository;
    private PerfilFuncionalidadRepository perfilFuncionalidadRepository;

    public PerfilService(PerfilRepository perfilRepository, PerfilFuncionalidadRepository perfilFuncionalidadRepository) {
        this.perfilRepository = perfilRepository;
        this.perfilFuncionalidadRepository= perfilFuncionalidadRepository;
    }

    public List<Perfil> listarModulosActivos() {
        return this.perfilRepository.findByEstado(EstadosEnum.ACTIVO.getValor());
    }

    public Perfil obtenerPorCodigo(String codigo) {
        Optional<Perfil>  perfilOpt = this.perfilRepository.findById(codigo);
        if (perfilOpt.isPresent()) {
            return perfilOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Perfil perfil) {
        perfil.setEstado(EstadosEnum.INACTIVO.getValor());
        this.perfilFuncionalidadRepository.saveAll(perfil.getPerfilesFuncionalidad());
        this.perfilRepository.save(perfil);
    }

    public void modificar(Perfil perfil) {
        Perfil perfilDB = this.obtenerPorCodigo(perfil.getCodPerfil());
        perfilDB.setNombre(perfil.getNombre());
        perfilDB.setEstado(perfil.getEstado());
        this.perfilRepository.save(perfilDB);
    }
}
