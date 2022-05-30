package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.general.model.UbicacionGeografica;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "edu_institucion_educativa")
public class InstitucionEducativa implements Serializable {

    private static final long serialVersionUID = 142578L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_institucion_educativa", nullable = false)
    private Integer codInstitucionEducativa;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @Column(name = "direccion", nullable = false, length = 500)
    private String direccion;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    @JoinColumn(name = "cod_ubicacion_geo_int", referencedColumnName = "cod_ubicacion_geo_int", nullable = false)
    @ManyToOne(optional = false)
    private UbicacionGeografica ubicacionGeo;

    public InstitucionEducativa() {
    }

    public InstitucionEducativa(Integer codInstitucionEducativa) {
        this.codInstitucionEducativa = codInstitucionEducativa;
    }

    public Integer getCodInstitucionEducativa() {
        return codInstitucionEducativa;
    }

    public void setCodInstitucionEducativa(Integer codInstitucionEducativa) {
        this.codInstitucionEducativa = codInstitucionEducativa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public UbicacionGeografica getUbicacionGeo() {
        return ubicacionGeo;
    }

    public void setUbicacionGeo(UbicacionGeografica ubicacionGeo) {
        this.ubicacionGeo = ubicacionGeo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInstitucionEducativa != null ? codInstitucionEducativa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof InstitucionEducativa)) {
            return false;
        }
        InstitucionEducativa other = (InstitucionEducativa) object;
        if ((this.codInstitucionEducativa == null && other.codInstitucionEducativa != null) || (this.codInstitucionEducativa != null && !this.codInstitucionEducativa.equals(other.codInstitucionEducativa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduInstitucionEducativa[ codInstitucionEducativa=" + codInstitucionEducativa + " ]";
    }

}
