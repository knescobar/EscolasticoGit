package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilFuncionalidadRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.enums.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.escolastico.shared.exception.CrearException;

@Service
public class PerfilService {
    private PerfilRepository perfilRepository;
    private PerfilFuncionalidadRepository perfilFuncionalidadRepository;

    public PerfilService(PerfilRepository perfilRepository,
            PerfilFuncionalidadRepository perfilFuncionalidadRepository) {
        this.perfilRepository = perfilRepository;
        this.perfilFuncionalidadRepository = perfilFuncionalidadRepository;
    }

    public List<Perfil> listarModulosActivos() {
        return this.perfilRepository.findByEstado(EstadosEnum.ACTIVO.getValor());
    }

    public Perfil obtenerPorCodigo(String codigo) {
        Optional<Perfil> perfilOpt = this.perfilRepository.findById(codigo);
        return perfilOpt.orElse(null);
    }

    public void crear(Perfil perfil) {
        if (perfil.getPerfilesFuncionalidad() == null
                || perfil.getPerfilesFuncionalidad().isEmpty()) {
            throw new CrearException(
                    "Error al crear el perfil, las funcionalidades son requeridas");
        }

        perfil.setEstado(EstadosEnum.ACTIVO.getValor());
        perfil.setAudFecha(new Date());
        perfil.setAudIp("localhost");
        perfil.setAudUsuario("");
        this.perfilRepository.save(perfil);
        this.perfilFuncionalidadRepository.saveAll(perfil.getPerfilesFuncionalidad());
    }

    public void modificar(Perfil perfil) {
        Perfil perfilDB = this.obtenerPorCodigo(perfil.getCodPerfil());
        perfilDB.setNombre(perfil.getNombre());
        perfilDB.setEstado(perfil.getEstado());
        perfilDB.setPerfilesFuncionalidad(perfil.getPerfilesFuncionalidad());
        this.perfilRepository.save(perfilDB);
    }

    public void eliminar(Perfil perfil) {

    }
}
