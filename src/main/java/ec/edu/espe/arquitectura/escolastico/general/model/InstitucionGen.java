package ec.edu.espe.arquitectura.escolastico.general.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gen_institucion")
public class InstitucionGen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ruc", nullable = false, length = 13)
    private String ruc;
    @Basic(optional = false)
    @Column(name = "razon_social", nullable = false, length = 128)
    private String razonSocial;
    @Basic(optional = false)
    @Column(name = "nombre_comercial", nullable = false, length = 128)
    private String nombreComercial;
    @Basic(optional = false)
    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "dominio", nullable = false, length = 64)
    private String dominio;
    @Column(name = "url_info", length = 128)
    private String urlInfo;
    @Basic(optional = false)
    @Column(name = "url_sistema", nullable = false, length = 128)
    private String urlSistema;
    @Basic(optional = false)
    @Column(name = "version", nullable = false)
    private int version;
    @JoinColumn(name = "cod_ubicacion_geo_int", referencedColumnName = "cod_ubicacion_geo_int")
    @ManyToOne
    private UbicacionGeografica codUbicacionGeoInt;

    public InstitucionGen() {
    }

    public InstitucionGen(String ruc) {
        this.ruc = ruc;
    }

    public InstitucionGen(String ruc, String razonSocial, String nombreComercial, String direccion, String dominio, String urlSistema, int version) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.dominio = dominio;
        this.urlSistema = urlSistema;
        this.version = version;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getUrlInfo() {
        return urlInfo;
    }

    public void setUrlInfo(String urlInfo) {
        this.urlInfo = urlInfo;
    }

    public String getUrlSistema() {
        return urlSistema;
    }

    public void setUrlSistema(String urlSistema) {
        this.urlSistema = urlSistema;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public UbicacionGeografica getCodUbicacionGeoInt() {
        return codUbicacionGeoInt;
    }

    public void setCodUbicacionGeoInt(UbicacionGeografica codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitucionGen)) {
            return false;
        }
        InstitucionGen other = (InstitucionGen) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.GenInstitucion[ ruc=" + ruc + " ]";
    }
    
}
