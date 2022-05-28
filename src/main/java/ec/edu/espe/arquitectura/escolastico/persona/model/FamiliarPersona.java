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
@Table(name = "per_familiar_persona")

public class FamiliarPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FamiliarPersonaPK perFamiliarPersonaPK;
    @Basic(optional = false)
    @Column(name = "tipo_familiar", nullable = false, length = 3)
    private String tipoFamiliar;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;
    @Column(name = "tipo_identificacion", length = 3)
    private String tipoIdentificacion;
    @Column(name = "identificacion", length = 20)
    private String identificacion;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "telefono", length = 20)
    private String telefono;
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

    public FamiliarPersona() {
    }

    public FamiliarPersona(FamiliarPersonaPK perFamiliarPersonaPK) {
        this.perFamiliarPersonaPK = perFamiliarPersonaPK;
    }

    public FamiliarPersona(FamiliarPersonaPK perFamiliarPersonaPK, String tipoFamiliar, String nombre, String audUsuario, Date audFecha, String audIp, int version) {
        this.perFamiliarPersonaPK = perFamiliarPersonaPK;
        this.tipoFamiliar = tipoFamiliar;
        this.nombre = nombre;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public FamiliarPersona(int codPersona, short secFamiliarPersona) {
        this.perFamiliarPersonaPK = new FamiliarPersonaPK(codPersona, secFamiliarPersona);
    }

    public FamiliarPersonaPK getPerFamiliarPersonaPK() {
        return perFamiliarPersonaPK;
    }

    public void setPerFamiliarPersonaPK(FamiliarPersonaPK perFamiliarPersonaPK) {
        this.perFamiliarPersonaPK = perFamiliarPersonaPK;
    }

    public String getTipoFamiliar() {
        return tipoFamiliar;
    }

    public void setTipoFamiliar(String tipoFamiliar) {
        this.tipoFamiliar = tipoFamiliar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (perFamiliarPersonaPK != null ? perFamiliarPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamiliarPersona)) {
            return false;
        }
        FamiliarPersona other = (FamiliarPersona) object;
        if ((this.perFamiliarPersonaPK == null && other.perFamiliarPersonaPK != null) || (this.perFamiliarPersonaPK != null && !this.perFamiliarPersonaPK.equals(other.perFamiliarPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.PerFamiliarPersona[ perFamiliarPersonaPK=" + perFamiliarPersonaPK + " ]";
    }
    
}
