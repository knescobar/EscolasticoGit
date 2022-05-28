/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "edu_matricula", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cod_periodo"})})

public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculaPK eduMatriculaPK;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "costo", nullable = false)
    private double costo;
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera", nullable = false)
    @ManyToOne(optional = false)
    private Carrera codCarrera;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false)
    @OneToOne(optional = false)
    private Periodo codPeriodo;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona perPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMatricula")
    private List<MatriculaNrc> eduMatriculaNrcList;

    public Matricula() {
    }

    public Matricula(MatriculaPK eduMatriculaPK) {
        this.eduMatriculaPK = eduMatriculaPK;
    }

    public Matricula(MatriculaPK eduMatriculaPK, String tipo, Date fecha, double costo) {
        this.eduMatriculaPK = eduMatriculaPK;
        this.tipo = tipo;
        this.fecha = fecha;
        this.costo = costo;
    }

    public Matricula(String codMatricula, int codPersona) {
        this.eduMatriculaPK = new MatriculaPK(codMatricula, codPersona);
    }

    public MatriculaPK getEduMatriculaPK() {
        return eduMatriculaPK;
    }

    public void setEduMatriculaPK(MatriculaPK eduMatriculaPK) {
        this.eduMatriculaPK = eduMatriculaPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Carrera getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Carrera codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Periodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Periodo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Persona getPerPersona() {
        return perPersona;
    }

    public void setPerPersona(Persona perPersona) {
        this.perPersona = perPersona;
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
        hash += (eduMatriculaPK != null ? eduMatriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.eduMatriculaPK == null && other.eduMatriculaPK != null) || (this.eduMatriculaPK != null && !this.eduMatriculaPK.equals(other.eduMatriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduMatricula[ eduMatriculaPK=" + eduMatriculaPK + " ]";
    }
    
}
