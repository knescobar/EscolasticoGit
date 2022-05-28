package ec.edu.espe.arquitectura.escolastico.general.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.educacion.model.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gen_ubicacion_geografica")

public class UbicacionGeografica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ubicacion_geo_int", nullable = false)
    private Integer codUbicacionGeoInt;
    @Basic(optional = false)
    @Column(name = "cod_ubicacion_geografica", nullable = false, length = 20)
    private String codUbicacionGeografica;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "codigo_area_telefono", length = 4)
    private String codigoAreaTelefono;
    @Column(name = "codigo_alterno", length = 15)
    private String codigoAlterno;
    @Column(name = "codigo_postal", length = 15)
    private String codigoPostal;
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
    @OneToMany(mappedBy = "codUbicacionGeoInt")
    private List<InstitucionGen> genInstitucionList;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne
    private Pais codPais;
    @JoinColumns({
        @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais", insertable = false, updatable = false),
        @JoinColumn(name = "nivel", referencedColumnName = "nivel", nullable = false,  insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PaisEstructura genPaisEstructura;
    @OneToMany(mappedBy = "codUbicacionGeoPadre")
    private List<UbicacionGeografica> genUbicacionGeograficaList;
    @JoinColumn(name = "cod_ubicacion_geo_padre", referencedColumnName = "cod_ubicacion_geo_int")
    @ManyToOne
    private UbicacionGeografica codUbicacionGeoPadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lugarNacimiento")
    private List<Persona> perPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUbicacionGeoInt")
    private List<InstitucionEducativa> eduInstitucionEducativaList;

    public UbicacionGeografica() {
    }

    public UbicacionGeografica(Integer codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    public UbicacionGeografica(Integer codUbicacionGeoInt, String codUbicacionGeografica, String nombre, String audUsuario, Date audFecha, String audIp, int version) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
        this.codUbicacionGeografica = codUbicacionGeografica;
        this.nombre = nombre;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public Integer getCodUbicacionGeoInt() {
        return codUbicacionGeoInt;
    }

    public void setCodUbicacionGeoInt(Integer codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    public String getCodUbicacionGeografica() {
        return codUbicacionGeografica;
    }

    public void setCodUbicacionGeografica(String codUbicacionGeografica) {
        this.codUbicacionGeografica = codUbicacionGeografica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoAreaTelefono() {
        return codigoAreaTelefono;
    }

    public void setCodigoAreaTelefono(String codigoAreaTelefono) {
        this.codigoAreaTelefono = codigoAreaTelefono;
    }

    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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

    public List<InstitucionGen> getGenInstitucionList() {
        return genInstitucionList;
    }

    public void setGenInstitucionList(List<InstitucionGen> genInstitucionList) {
        this.genInstitucionList = genInstitucionList;
    }

    public Pais getCodPais() {
        return codPais;
    }

    public void setCodPais(Pais codPais) {
        this.codPais = codPais;
    }

    public PaisEstructura getGenPaisEstructura() {
        return genPaisEstructura;
    }

    public void setGenPaisEstructura(PaisEstructura genPaisEstructura) {
        this.genPaisEstructura = genPaisEstructura;
    }

    public List<UbicacionGeografica> getGenUbicacionGeograficaList() {
        return genUbicacionGeograficaList;
    }

    public void setGenUbicacionGeograficaList(List<UbicacionGeografica> genUbicacionGeograficaList) {
        this.genUbicacionGeograficaList = genUbicacionGeograficaList;
    }

    public UbicacionGeografica getCodUbicacionGeoPadre() {
        return codUbicacionGeoPadre;
    }

    public void setCodUbicacionGeoPadre(UbicacionGeografica codUbicacionGeoPadre) {
        this.codUbicacionGeoPadre = codUbicacionGeoPadre;
    }

    public List<Persona> getPerPersonaList() {
        return perPersonaList;
    }

    public void setPerPersonaList(List<Persona> perPersonaList) {
        this.perPersonaList = perPersonaList;
    }

    public List<InstitucionEducativa> getEduInstitucionEducativaList() {
        return eduInstitucionEducativaList;
    }

    public void setEduInstitucionEducativaList(List<InstitucionEducativa> eduInstitucionEducativaList) {
        this.eduInstitucionEducativaList = eduInstitucionEducativaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUbicacionGeoInt != null ? codUbicacionGeoInt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UbicacionGeografica)) {
            return false;
        }
        UbicacionGeografica other = (UbicacionGeografica) object;
        if ((this.codUbicacionGeoInt == null && other.codUbicacionGeoInt != null) || (this.codUbicacionGeoInt != null && !this.codUbicacionGeoInt.equals(other.codUbicacionGeoInt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.GenUbicacionGeografica[ codUbicacionGeoInt=" + codUbicacionGeoInt + " ]";
    }
    
}
