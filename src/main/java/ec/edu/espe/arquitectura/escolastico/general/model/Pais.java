/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.escolastico.general.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "gen_pais")

public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_pais", nullable = false, length = 2)
    private String codPais;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "por_omision", nullable = false, length = 1)
    private String porOmision;
    @Column(name = "codigo_telefonico", length = 3)
    private String codigoTelefonico;
    @Column(name = "nacionalidad", length = 50)
    private String nacionalidad;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genPais")
    private List<PaisEstructura> genPaisEstructuraList;
    @OneToMany(mappedBy = "codPais")
    private List<UbicacionGeografica> genUbicacionGeograficaList;
    @OneToMany(mappedBy = "codPaisNacimiento")
    private List<Persona> perPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidad")
    private List<Persona> perPersonaList1;

    public Pais() {
    }

    public Pais(String codPais) {
        this.codPais = codPais;
    }

    public Pais(String codPais, String nombre, String porOmision, String audUsuario, Date audFecha, String audIp, int version) {
        this.codPais = codPais;
        this.nombre = nombre;
        this.porOmision = porOmision;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorOmision() {
        return porOmision;
    }

    public void setPorOmision(String porOmision) {
        this.porOmision = porOmision;
    }

    public String getCodigoTelefonico() {
        return codigoTelefonico;
    }

    public void setCodigoTelefonico(String codigoTelefonico) {
        this.codigoTelefonico = codigoTelefonico;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public List<PaisEstructura> getGenPaisEstructuraList() {
        return genPaisEstructuraList;
    }

    public void setGenPaisEstructuraList(List<PaisEstructura> genPaisEstructuraList) {
        this.genPaisEstructuraList = genPaisEstructuraList;
    }

    public List<UbicacionGeografica> getGenUbicacionGeograficaList() {
        return genUbicacionGeograficaList;
    }

    public void setGenUbicacionGeograficaList(List<UbicacionGeografica> genUbicacionGeograficaList) {
        this.genUbicacionGeograficaList = genUbicacionGeograficaList;
    }


    public List<Persona> getPerPersonaList() {
        return perPersonaList;
    }

    public void setPerPersonaList(List<Persona> perPersonaList) {
        this.perPersonaList = perPersonaList;
    }

    public List<Persona> getPerPersonaList1() {
        return perPersonaList1;
    }

    public void setPerPersonaList1(List<Persona> perPersonaList1) {
        this.perPersonaList1 = perPersonaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.GenPais[ codPais=" + codPais + " ]";
    }
    
}
