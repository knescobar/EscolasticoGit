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
@Table(name = "seg_usuario_perfil")

public class UsuarioPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPerfilPK segUsuarioPerfilPK;
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
    @JoinColumn(name = "cod_perfil", referencedColumnName = "cod_perfil", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil segPerfil;
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario segUsuario;

    public UsuarioPerfil() {
    }

    public UsuarioPerfil(UsuarioPerfilPK segUsuarioPerfilPK) {
        this.segUsuarioPerfilPK = segUsuarioPerfilPK;
    }

    public UsuarioPerfil(UsuarioPerfilPK segUsuarioPerfilPK, String audUsuario, Date audFecha, String audIp, int version) {
        this.segUsuarioPerfilPK = segUsuarioPerfilPK;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public UsuarioPerfil(String codUsuario, String codPerfil) {
        this.segUsuarioPerfilPK = new UsuarioPerfilPK(codUsuario, codPerfil);
    }

    public UsuarioPerfilPK getSegUsuarioPerfilPK() {
        return segUsuarioPerfilPK;
    }

    public void setSegUsuarioPerfilPK(UsuarioPerfilPK segUsuarioPerfilPK) {
        this.segUsuarioPerfilPK = segUsuarioPerfilPK;
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

    public Perfil getSegPerfil() {
        return segPerfil;
    }

    public void setSegPerfil(Perfil segPerfil) {
        this.segPerfil = segPerfil;
    }

    public Usuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(Usuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segUsuarioPerfilPK != null ? segUsuarioPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPerfil)) {
            return false;
        }
        UsuarioPerfil other = (UsuarioPerfil) object;
        if ((this.segUsuarioPerfilPK == null && other.segUsuarioPerfilPK != null) || (this.segUsuarioPerfilPK != null && !this.segUsuarioPerfilPK.equals(other.segUsuarioPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.SegUsuarioPerfil[ segUsuarioPerfilPK=" + segUsuarioPerfilPK + " ]";
    }
    
}
