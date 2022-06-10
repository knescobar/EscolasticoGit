package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "edu_nrc", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "cod_periodo" }) })
public class Nrc implements Serializable {

    private static final long serialVersionUID = 5724581L;
    @EmbeddedId
    private NrcPK pk;
    @Column(name = "cupo_disponible", nullable = false)
    private Integer cupoDisponible;
    @Column(name = "cupo_registrado", nullable = false)
    private Integer cupoRegistrado;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @JoinColumns({
            @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false) })
    @ManyToOne(optional = false)
    @JsonIgnore
    private Materia materia;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    @JsonIgnore
    private Periodo periodo;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false)
    @ManyToOne(optional = false)

    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrc")
    private List<NrcHorario> horario;

    public Nrc() {
    }

    public Nrc(NrcPK eduNrcPK) {
        this.pk = eduNrcPK;
    }

    public Nrc(Integer codNrc, int codPeriodo, int codDepartamento, int codMateria) {
        this.pk = new NrcPK(codNrc, codPeriodo, codDepartamento, codMateria);
    }

    public NrcPK getPk() {
        return pk;
    }

    public void setPk(NrcPK pk) {
        this.pk = pk;
    }

    public Integer getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(Integer cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public Integer getCupoRegistrado() {
        return cupoRegistrado;
    }

    public void setCupoRegistrado(Integer cupoRegistrado) {
        this.cupoRegistrado = cupoRegistrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<NrcHorario> getHorario() {
        return horario;
    }

    public void setHorario(List<NrcHorario> horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Nrc)) {
            return false;
        }
        Nrc other = (Nrc) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduNrc[ eduNrcPK=" + pk + " ]";
    }

}
