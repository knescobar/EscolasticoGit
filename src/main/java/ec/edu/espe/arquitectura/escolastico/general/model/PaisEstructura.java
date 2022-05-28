package ec.edu.espe.arquitectura.escolastico.general.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gen_pais_estructura")

public class PaisEstructura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaisEstructuraPK genPaisEstructuraPK;
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
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pais genPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genPaisEstructura")
    private List<UbicacionGeografica> genUbicacionGeograficaList;

    public PaisEstructura() {
    }

    public PaisEstructura(PaisEstructuraPK genPaisEstructuraPK) {
        this.genPaisEstructuraPK = genPaisEstructuraPK;
    }

    public PaisEstructura(PaisEstructuraPK genPaisEstructuraPK, String nombre, String audUsuario, Date audFecha, String audIp, int version) {
        this.genPaisEstructuraPK = genPaisEstructuraPK;
        this.nombre = nombre;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public PaisEstructura(String codPais, short nivel) {
        this.genPaisEstructuraPK = new PaisEstructuraPK(codPais, nivel);
    }

    public PaisEstructuraPK getGenPaisEstructuraPK() {
        return genPaisEstructuraPK;
    }

    public void setGenPaisEstructuraPK(PaisEstructuraPK genPaisEstructuraPK) {
        this.genPaisEstructuraPK = genPaisEstructuraPK;
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

    public Pais getGenPais() {
        return genPais;
    }

    public void setGenPais(Pais genPais) {
        this.genPais = genPais;
    }

    public List<UbicacionGeografica> getGenUbicacionGeograficaList() {
        return genUbicacionGeograficaList;
    }

    public void setGenUbicacionGeograficaList(List<UbicacionGeografica> genUbicacionGeograficaList) {
        this.genUbicacionGeograficaList = genUbicacionGeograficaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genPaisEstructuraPK != null ? genPaisEstructuraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaisEstructura)) {
            return false;
        }
        PaisEstructura other = (PaisEstructura) object;
        if ((this.genPaisEstructuraPK == null && other.genPaisEstructuraPK != null) || (this.genPaisEstructuraPK != null && !this.genPaisEstructuraPK.equals(other.genPaisEstructuraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.GenPaisEstructura[ genPaisEstructuraPK=" + genPaisEstructuraPK + " ]";
    }
    
}
