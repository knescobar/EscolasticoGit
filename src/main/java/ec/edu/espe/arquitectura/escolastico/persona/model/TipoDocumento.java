package ec.edu.espe.arquitectura.escolastico.persona.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "per_tipo_documento")

public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 58578581L;
    @Id
    @Column(name = "cod_tipo_documento", nullable = false, length = 16)
    private String codTipoDocumento;
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private List<DocumentoPersona> perDocumentoPersonaList;

    public TipoDocumento() {
    }

    public TipoDocumento(String codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public String getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(String codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
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

    public List<DocumentoPersona> getPerDocumentoPersonaList() {
        return perDocumentoPersonaList;
    }

    public void setPerDocumentoPersonaList(List<DocumentoPersona> perDocumentoPersonaList) {
        this.perDocumentoPersonaList = perDocumentoPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoDocumento != null ? codTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.codTipoDocumento == null && other.codTipoDocumento != null) || (this.codTipoDocumento != null && !this.codTipoDocumento.equals(other.codTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.PerTipoDocumento[ codTipoDocumento=" + codTipoDocumento + " ]";
    }
    
}
