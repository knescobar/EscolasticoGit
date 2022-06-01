package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PerfilFuncionalidadPK implements Serializable {

    @Column(name = "cod_perfil", nullable = false, length = 8)
    private String codPerfil;
    @Column(name = "cod_funcionalidad", nullable = false)
    private Integer codFuncionalidad;

    public PerfilFuncionalidadPK() {
    }

    public PerfilFuncionalidadPK(String codPerfil, Integer codFuncionalidad) {
        this.codPerfil = codPerfil;
        this.codFuncionalidad = codFuncionalidad;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public Integer getCodFuncionalidad() {
        return codFuncionalidad;
    }

    public void setCodFuncionalidad(Integer codFuncionalidad) {
        this.codFuncionalidad = codFuncionalidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.codPerfil);
        hash = 37 * hash + Objects.hashCode(this.codFuncionalidad);
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
        final PerfilFuncionalidadPK other = (PerfilFuncionalidadPK) obj;
        if (!Objects.equals(this.codPerfil, other.codPerfil)) {
            return false;
        }
        if (!Objects.equals(this.codFuncionalidad, other.codFuncionalidad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.SegPerfilFuncionalidadPK[ codPerfil=" + codPerfil + ", codFuncionalidad=" + codFuncionalidad + " ]";
    }

}
