package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.UsuarioPerfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.UsuarioPerfilPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, UsuarioPerfilPK> {
    List<UsuarioPerfil> findByPkCodUsuario(String codUsuario);
}
