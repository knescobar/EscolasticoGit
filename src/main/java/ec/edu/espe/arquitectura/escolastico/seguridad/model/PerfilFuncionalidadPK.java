package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PerfilFuncionalidadPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_perfil", nullable = false, length = 8)
    private String codPerfil;
    @Basic(optional = false)
    @Column(name = "cod_funcionalidad", nullable = false)
    private int codFuncionalidad;

    public PerfilFuncionalidadPK() {
    }

    public PerfilFuncionalidadPK(String codPerfil, int codFuncionalidad) {
        this.codPerfil = codPerfil;
        this.codFuncionalidad = codFuncionalidad;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public int getCodFuncionalidad() {
        return codFuncionalidad;
    }

    public void setCodFuncionalidad(int codFuncionalidad) {
        this.codFuncionalidad = codFuncionalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPerfil != null ? codPerfil.hashCode() : 0);
        hash += (int) codFuncionalidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilFuncionalidadPK)) {
            return false;
        }
        PerfilFuncionalidadPK other = (PerfilFuncionalidadPK) object;
        if ((this.codPerfil == null && other.codPerfil != null) || (this.codPerfil != null && !this.codPerfil.equals(other.codPerfil))) {
            return false;
        }
        if (this.codFuncionalidad != other.codFuncionalidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.SegPerfilFuncionalidadPK[ codPerfil=" + codPerfil + ", codFuncionalidad=" + codFuncionalidad + " ]";
    }
    
}
