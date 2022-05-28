/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "edu_departamento")

public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_departamento", nullable = false)
    private Integer codDepartamento;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "siglas", nullable = false, length = 32)
    private String siglas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDepartamento")
    private List<Carrera> eduCarreraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduDepartamento")
    private List<Materia> eduMateriaList;

    public Departamento() {
    }

    public Departamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public Departamento(Integer codDepartamento, String nombre, String descripcion, String siglas) {
        this.codDepartamento = codDepartamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.siglas = siglas;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public List<Carrera> getEduCarreraList() {
        return eduCarreraList;
    }

    public void setEduCarreraList(List<Carrera> eduCarreraList) {
        this.eduCarreraList = eduCarreraList;
    }

    public List<Materia> getEduMateriaList() {
        return eduMateriaList;
    }

    public void setEduMateriaList(List<Materia> eduMateriaList) {
        this.eduMateriaList = eduMateriaList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDepartamento != null ? codDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.codDepartamento == null && other.codDepartamento != null) || (this.codDepartamento != null && !this.codDepartamento.equals(other.codDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduDepartamento[ codDepartamento=" + codDepartamento + " ]";
    }
    
}
