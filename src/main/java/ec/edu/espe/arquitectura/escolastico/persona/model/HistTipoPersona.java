/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.escolastico.persona.model;

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
@Table(name = "per_hist_tipo_persona")

public class HistTipoPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistTipoPersonaPK perHistTipoPersonaPK;
    @Basic(optional = false)
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "cod_usuario_ini", nullable = false, length = 30)
    private String codUsuarioIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "cod_usuario_fin", length = 30)
    private String codUsuarioFin;
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
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona perPersona;
    @JoinColumn(name = "cod_tipo_persona", referencedColumnName = "cod_tipo_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoPersona perTipoPersona;

    public HistTipoPersona() {
    }

    public HistTipoPersona(HistTipoPersonaPK perHistTipoPersonaPK) {
        this.perHistTipoPersonaPK = perHistTipoPersonaPK;
    }

    public HistTipoPersona(HistTipoPersonaPK perHistTipoPersonaPK, Date fechaInicio, String codUsuarioIni, String audUsuario, Date audFecha, String audIp, int version) {
        this.perHistTipoPersonaPK = perHistTipoPersonaPK;
        this.fechaInicio = fechaInicio;
        this.codUsuarioIni = codUsuarioIni;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public HistTipoPersona(int codPersona, String codTipoPersona) {
        this.perHistTipoPersonaPK = new HistTipoPersonaPK(codPersona, codTipoPersona);
    }

    public HistTipoPersonaPK getPerHistTipoPersonaPK() {
        return perHistTipoPersonaPK;
    }

    public void setPerHistTipoPersonaPK(HistTipoPersonaPK perHistTipoPersonaPK) {
        this.perHistTipoPersonaPK = perHistTipoPersonaPK;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCodUsuarioIni() {
        return codUsuarioIni;
    }

    public void setCodUsuarioIni(String codUsuarioIni) {
        this.codUsuarioIni = codUsuarioIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodUsuarioFin() {
        return codUsuarioFin;
    }

    public void setCodUsuarioFin(String codUsuarioFin) {
        this.codUsuarioFin = codUsuarioFin;
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

    public Persona getPerPersona() {
        return perPersona;
    }

    public void setPerPersona(Persona perPersona) {
        this.perPersona = perPersona;
    }

    public TipoPersona getPerTipoPersona() {
        return perTipoPersona;
    }

    public void setPerTipoPersona(TipoPersona perTipoPersona) {
        this.perTipoPersona = perTipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perHistTipoPersonaPK != null ? perHistTipoPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistTipoPersona)) {
            return false;
        }
        HistTipoPersona other = (HistTipoPersona) object;
        if ((this.perHistTipoPersonaPK == null && other.perHistTipoPersonaPK != null) || (this.perHistTipoPersonaPK != null && !this.perHistTipoPersonaPK.equals(other.perHistTipoPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.PerHistTipoPersona[ perHistTipoPersonaPK=" + perHistTipoPersonaPK + " ]";
    }
    
}
