/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Aula;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "edu_nrc_horario")

public class NrcHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NrcHorarioPK eduNrcHorarioPK;
    @Basic(optional = false)
    @Column(name = "hora_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @Column(name = "hora_fin", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nrc eduNrc;
    @JoinColumn(name = "cod_aula", referencedColumnName = "cod_aula", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aula ofiAula;

    public NrcHorario() {
    }

    public NrcHorario(NrcHorarioPK eduNrcHorarioPK) {
        this.eduNrcHorarioPK = eduNrcHorarioPK;
    }

    public NrcHorario(NrcHorarioPK eduNrcHorarioPK, Date horaInicio, Date horaFin) {
        this.eduNrcHorarioPK = eduNrcHorarioPK;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public NrcHorario(short codNrc, int codPeriodo, int codDepartamento, int codMateria, int codAula, String diaSemana) {
        this.eduNrcHorarioPK = new NrcHorarioPK(codNrc, codPeriodo, codDepartamento, codMateria, codAula, diaSemana);
    }

    public NrcHorarioPK getEduNrcHorarioPK() {
        return eduNrcHorarioPK;
    }

    public void setEduNrcHorarioPK(NrcHorarioPK eduNrcHorarioPK) {
        this.eduNrcHorarioPK = eduNrcHorarioPK;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Nrc getEduNrc() {
        return eduNrc;
    }

    public void setEduNrc(Nrc eduNrc) {
        this.eduNrc = eduNrc;
    }

    public Aula getOfiAula() {
        return ofiAula;
    }

    public void setOfiAula(Aula ofiAula) {
        this.ofiAula = ofiAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduNrcHorarioPK != null ? eduNrcHorarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NrcHorario)) {
            return false;
        }
        NrcHorario other = (NrcHorario) object;
        if ((this.eduNrcHorarioPK == null && other.eduNrcHorarioPK != null) || (this.eduNrcHorarioPK != null && !this.eduNrcHorarioPK.equals(other.eduNrcHorarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduNrcHorario[ eduNrcHorarioPK=" + eduNrcHorarioPK + " ]";
    }
    
}
