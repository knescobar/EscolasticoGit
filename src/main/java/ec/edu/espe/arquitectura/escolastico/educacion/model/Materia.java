/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "edu_materia")

public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MateriaPK eduMateriaPK;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "creditos", nullable = false, precision = 4, scale = 2)
    private BigDecimal creditos;
    @Basic(optional = false)
    @Column(name = "horas", nullable = false, precision = 4, scale = 2)
    private BigDecimal horas;
    @Basic(optional = false)
    @Column(name = "ponderacion", nullable = false, precision = 5, scale = 2)
    private BigDecimal ponderacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMateria")
    private List<Nrc> eduNrcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMateria")
    private List<MallaCarrera> eduMallaCarreraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMateria")
    private List<Prerequisito> eduPrerequisitoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMateria1")
    private List<Prerequisito> eduPrerequisitoList1;
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departamento eduDepartamento;

    public Materia() {
    }

    public Materia(MateriaPK eduMateriaPK) {
        this.eduMateriaPK = eduMateriaPK;
    }

    public Materia(MateriaPK eduMateriaPK, String nombre, BigDecimal creditos, BigDecimal horas, BigDecimal ponderacion) {
        this.eduMateriaPK = eduMateriaPK;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas = horas;
        this.ponderacion = ponderacion;
    }

    public Materia(int codMateria, int codDepartamento) {
        this.eduMateriaPK = new MateriaPK(codMateria, codDepartamento);
    }

    public MateriaPK getEduMateriaPK() {
        return eduMateriaPK;
    }

    public void setEduMateriaPK(MateriaPK eduMateriaPK) {
        this.eduMateriaPK = eduMateriaPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCreditos() {
        return creditos;
    }

    public void setCreditos(BigDecimal creditos) {
        this.creditos = creditos;
    }

    public BigDecimal getHoras() {
        return horas;
    }

    public void setHoras(BigDecimal horas) {
        this.horas = horas;
    }

    public BigDecimal getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(BigDecimal ponderacion) {
        this.ponderacion = ponderacion;
    }

    public List<Nrc> getEduNrcList() {
        return eduNrcList;
    }

    public void setEduNrcList(List<Nrc> eduNrcList) {
        this.eduNrcList = eduNrcList;
    }

    public List<MallaCarrera> getEduMallaCarreraList() {
        return eduMallaCarreraList;
    }

    public void setEduMallaCarreraList(List<MallaCarrera> eduMallaCarreraList) {
        this.eduMallaCarreraList = eduMallaCarreraList;
    }

    public List<Prerequisito> getEduPrerequisitoList() {
        return eduPrerequisitoList;
    }

    public void setEduPrerequisitoList(List<Prerequisito> eduPrerequisitoList) {
        this.eduPrerequisitoList = eduPrerequisitoList;
    }

    public List<Prerequisito> getEduPrerequisitoList1() {
        return eduPrerequisitoList1;
    }

    public void setEduPrerequisitoList1(List<Prerequisito> eduPrerequisitoList1) {
        this.eduPrerequisitoList1 = eduPrerequisitoList1;
    }

    public Departamento getEduDepartamento() {
        return eduDepartamento;
    }

    public void setEduDepartamento(Departamento eduDepartamento) {
        this.eduDepartamento = eduDepartamento;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduMateriaPK != null ? eduMateriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.eduMateriaPK == null && other.eduMateriaPK != null) || (this.eduMateriaPK != null && !this.eduMateriaPK.equals(other.eduMateriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduMateria[ eduMateriaPK=" + eduMateriaPK + " ]";
    }
    
}
