package ec.edu.espe.arquitectura.escolastico.persona.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "per_direccion_persona")

public class DireccionPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DireccionPersonaPK perDireccionPersonaPK;
    @Basic(optional = false)
    @Column(name = "cod_tipo_direccion", nullable = false, length = 3)
    private String codTipoDireccion;
    @Basic(optional = false)
    @Column(name = "cod_org_geo_direccion", nullable = false)
    private int codOrgGeoDireccion;
    @Basic(optional = false)
    @Column(name = "calle_principal", nullable = false, length = 100)
    private String callePrincipal;
    @Basic(optional = false)
    @Column(name = "numeracion", nullable = false, length = 15)
    private String numeracion;
    @Column(name = "calle_secundaria", length = 100)
    private String calleSecundaria;
    @Column(name = "direccion_adicional", length = 50)
    private String direccionAdicional;
    @Column(name = "barrio", length = 100)
    private String barrio;
    @Column(name = "referencia", length = 255)
    private String referencia;
    @Column(name = "telefono", length = 15)
    private String telefono;
    @Basic(optional = false)
    @Column(name = "principal", nullable = false, length = 1)
    private String principal;
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

    public DireccionPersona() {
    }

    public DireccionPersona(DireccionPersonaPK perDireccionPersonaPK) {
        this.perDireccionPersonaPK = perDireccionPersonaPK;
    }

    public DireccionPersona(DireccionPersonaPK perDireccionPersonaPK, String codTipoDireccion, int codOrgGeoDireccion, String callePrincipal, String numeracion, String principal, String audUsuario, Date audFecha, String audIp, int version) {
        this.perDireccionPersonaPK = perDireccionPersonaPK;
        this.codTipoDireccion = codTipoDireccion;
        this.codOrgGeoDireccion = codOrgGeoDireccion;
        this.callePrincipal = callePrincipal;
        this.numeracion = numeracion;
        this.principal = principal;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public DireccionPersona(int codPersona, short secDireccion) {
        this.perDireccionPersonaPK = new DireccionPersonaPK(codPersona, secDireccion);
    }

    public DireccionPersonaPK getPerDireccionPersonaPK() {
        return perDireccionPersonaPK;
    }

    public void setPerDireccionPersonaPK(DireccionPersonaPK perDireccionPersonaPK) {
        this.perDireccionPersonaPK = perDireccionPersonaPK;
    }

    public String getCodTipoDireccion() {
        return codTipoDireccion;
    }

    public void setCodTipoDireccion(String codTipoDireccion) {
        this.codTipoDireccion = codTipoDireccion;
    }

    public int getCodOrgGeoDireccion() {
        return codOrgGeoDireccion;
    }

    public void setCodOrgGeoDireccion(int codOrgGeoDireccion) {
        this.codOrgGeoDireccion = codOrgGeoDireccion;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getDireccionAdicional() {
        return direccionAdicional;
    }

    public void setDireccionAdicional(String direccionAdicional) {
        this.direccionAdicional = direccionAdicional;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perDireccionPersonaPK != null ? perDireccionPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionPersona)) {
            return false;
        }
        DireccionPersona other = (DireccionPersona) object;
        if ((this.perDireccionPersonaPK == null && other.perDireccionPersonaPK != null) || (this.perDireccionPersonaPK != null && !this.perDireccionPersonaPK.equals(other.perDireccionPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.PerDireccionPersona[ perDireccionPersonaPK=" + perDireccionPersonaPK + " ]";
    }
    
}
