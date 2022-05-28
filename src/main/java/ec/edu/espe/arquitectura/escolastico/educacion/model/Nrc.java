/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "edu_nrc", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cod_periodo"})})

public class Nrc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NrcPK eduNrcPK;
    @Basic(optional = false)
    @Column(name = "cupo_disponible", nullable = false)
    private short cupoDisponible;
    @Basic(optional = false)
    @Column(name = "cupo_registrado", nullable = false)
    private short cupoRegistrado;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @JoinColumns({
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Materia eduMateria;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Periodo eduPeriodo;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false)
    @ManyToOne(optional = false)
    private Persona codPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduNrc")
    private List<NrcHorario> eduNrcHorarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduNrc")
    private List<MatriculaNrc> eduMatriculaNrcList;

    public Nrc() {
    }

    public Nrc(NrcPK eduNrcPK) {
        this.eduNrcPK = eduNrcPK;
    }

    public Nrc(NrcPK eduNrcPK, short cupoDisponible, short cupoRegistrado) {
        this.eduNrcPK = eduNrcPK;
        this.cupoDisponible = cupoDisponible;
        this.cupoRegistrado = cupoRegistrado;
    }

    public Nrc(short codNrc, int codPeriodo, int codDepartamento, int codMateria) {
        this.eduNrcPK = new NrcPK(codNrc, codPeriodo, codDepartamento, codMateria);
    }

    public NrcPK getEduNrcPK() {
        return eduNrcPK;
    }

    public void setEduNrcPK(NrcPK eduNrcPK) {
        this.eduNrcPK = eduNrcPK;
    }

    public short getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(short cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public short getCupoRegistrado() {
        return cupoRegistrado;
    }

    public void setCupoRegistrado(short cupoRegistrado) {
        this.cupoRegistrado = cupoRegistrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Materia getEduMateria() {
        return eduMateria;
    }

    public void setEduMateria(Materia eduMateria) {
        this.eduMateria = eduMateria;
    }

    public Periodo getEduPeriodo() {
        return eduPeriodo;
    }

    public void setEduPeriodo(Periodo eduPeriodo) {
        this.eduPeriodo = eduPeriodo;
    }

    public Persona getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Persona codPersona) {
        this.codPersona = codPersona;
    }

    public List<NrcHorario> getEduNrcHorarioList() {
        return eduNrcHorarioList;
    }

    public void setEduNrcHorarioList(List<NrcHorario> eduNrcHorarioList) {
        this.eduNrcHorarioList = eduNrcHorarioList;
    }

    public List<MatriculaNrc> getEduMatriculaNrcList() {
        return eduMatriculaNrcList;
    }

    public void setEduMatriculaNrcList(List<MatriculaNrc> eduMatriculaNrcList) {
        this.eduMatriculaNrcList = eduMatriculaNrcList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduNrcPK != null ? eduNrcPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nrc)) {
            return false;
        }
        Nrc other = (Nrc) object;
        if ((this.eduNrcPK == null && other.eduNrcPK != null) || (this.eduNrcPK != null && !this.eduNrcPK.equals(other.eduNrcPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduNrc[ eduNrcPK=" + eduNrcPK + " ]";
    }
    
}
