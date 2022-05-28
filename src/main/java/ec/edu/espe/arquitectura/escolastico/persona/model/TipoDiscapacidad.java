package ec.edu.espe.arquitectura.escolastico.persona.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "per_tipo_discapacidad")

public class TipoDiscapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_tipo_discapacidad", nullable = false, length = 8)
    private String codTipoDiscapacidad;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
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
    @OneToMany(mappedBy = "codTipoDiscapacidad")
    private List<Persona> perPersonaList;

    public TipoDiscapacidad() {
    }

    public TipoDiscapacidad(String codTipoDiscapacidad) {
        this.codTipoDiscapacidad = codTipoDiscapacidad;
    }

    public TipoDiscapacidad(String codTipoDiscapacidad, String nombre, String audUsuario, Date audFecha, String audIp, int version) {
        this.codTipoDiscapacidad = codTipoDiscapacidad;
        this.nombre = nombre;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public String getCodTipoDiscapacidad() {
        return codTipoDiscapacidad;
    }

    public void setCodTipoDiscapacidad(String codTipoDiscapacidad) {
        this.codTipoDiscapacidad = codTipoDiscapacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<Persona> getPerPersonaList() {
        return perPersonaList;
    }

    public void setPerPersonaList(List<Persona> perPersonaList) {
        this.perPersonaList = perPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoDiscapacidad != null ? codTipoDiscapacidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDiscapacidad)) {
            return false;
        }
        TipoDiscapacidad other = (TipoDiscapacidad) object;
        if ((this.codTipoDiscapacidad == null && other.codTipoDiscapacidad != null) || (this.codTipoDiscapacidad != null && !this.codTipoDiscapacidad.equals(other.codTipoDiscapacidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.PerTipoDiscapacidad[ codTipoDiscapacidad=" + codTipoDiscapacidad + " ]";
    }
    
}
