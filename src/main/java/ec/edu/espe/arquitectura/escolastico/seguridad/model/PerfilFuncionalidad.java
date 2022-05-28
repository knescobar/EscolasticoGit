/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "seg_perfil_funcionalidad")

public class PerfilFuncionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilFuncionalidadPK segPerfilFuncionalidadPK;
    @Basic(optional = false)
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Basic(optional = false)
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Basic(optional = false)
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Basic(optional = false)
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

    public PerfilFuncionalidad(PerfilFuncionalidadPK segPerfilFuncionalidadPK, String audUsuario, Date audFecha, String audIp, int version) {
        this.segPerfilFuncionalidadPK = segPerfilFuncionalidadPK;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
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
