package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "seg_perfil_funcionalidad")

public class PerfilFuncionalidad implements Serializable {

    private static final long serialVersionUID = 46545582L;
    @EmbeddedId
    protected PerfilFuncionalidadPK segPerfilFuncionalidadPK;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    @JoinColumn(name = "cod_funcionalidad", referencedColumnName = "cod_funcionalidad", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionalidad segFuncionalidad;
    @JoinColumn(name = "cod_perfil", referencedColumnName = "cod_perfil", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil segPerfil;

    public PerfilFuncionalidad() {
    }

    public PerfilFuncionalidad(PerfilFuncionalidadPK segPerfilFuncionalidadPK) {
        this.segPerfilFuncionalidadPK = segPerfilFuncionalidadPK;
    }
    
    public PerfilFuncionalidad(String codPerfil, int codFuncionalidad) {
        this.segPerfilFuncionalidadPK = new PerfilFuncionalidadPK(codPerfil, codFuncionalidad);
    }

    public PerfilFuncionalidadPK getSegPerfilFuncionalidadPK() {
        return segPerfilFuncionalidadPK;
    }

    public void setSegPerfilFuncionalidadPK(PerfilFuncionalidadPK segPerfilFuncionalidadPK) {
        this.segPerfilFuncionalidadPK = segPerfilFuncionalidadPK;
    }

    public String getAudUsuario() {
        return audUsuario;
    }

    public void setAudUsuario(String audUsuario) {
        this.audUsuario = audUsuario;
    }

    public Date getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }

    public String getAudIp() {
        return audIp;
    }

    public void setAudIp(String audIp) {
        this.audIp = audIp;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Funcionalidad getSegFuncionalidad() {
        return segFuncionalidad;
    }

    public void setSegFuncionalidad(Funcionalidad segFuncionalidad) {
        this.segFuncionalidad = segFuncionalidad;
    }

    public Perfil getSegPerfil() {
        return segPerfil;
    }

    public void setSegPerfil(Perfil segPerfil) {
        this.segPerfil = segPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segPerfilFuncionalidadPK != null ? segPerfilFuncionalidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PerfilFuncionalidad)) {
            return false;
        }
        PerfilFuncionalidad other = (PerfilFuncionalidad) object;
        if ((this.segPerfilFuncionalidadPK == null && other.segPerfilFuncionalidadPK != null) || (this.segPerfilFuncionalidadPK != null && !this.segPerfilFuncionalidadPK.equals(other.segPerfilFuncionalidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.SegPerfilFuncionalidad[ segPerfilFuncionalidadPK=" + segPerfilFuncionalidadPK + " ]";
    }
    
}
