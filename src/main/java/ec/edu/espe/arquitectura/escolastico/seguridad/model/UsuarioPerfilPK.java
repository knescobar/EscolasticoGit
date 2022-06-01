package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioPerfilPK implements Serializable {

    @Column(name = "cod_usuario", nullable = false, length = 30)
    private String codUsuario;
    @Column(name = "cod_perfil", nullable = false, length = 8)
    private String codPerfil;

    public UsuarioPerfilPK() {
    }

    public UsuarioPerfilPK(String codUsuario, String codPerfil) {
        this.codUsuario = codUsuario;
        this.codPerfil = codPerfil;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codUsuario);
        hash = 59 * hash + Objects.hashCode(this.codPerfil);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioPerfilPK other = (UsuarioPerfilPK) obj;
        if (!Objects.equals(this.codUsuario, other.codUsuario)) {
            return false;
        }
        if (!Objects.equals(this.codPerfil, other.codPerfil)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.SegUsuarioPerfilPK[ codUsuario=" + codUsuario + ", codPerfil=" + codPerfil + " ]";
    }

}
