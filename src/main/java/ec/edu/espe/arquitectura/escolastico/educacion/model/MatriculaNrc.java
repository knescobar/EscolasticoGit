package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "edu_matricula_nrc")

public class MatriculaNrc implements Serializable {

    private static final long serialVersionUID = 758581L;
    @EmbeddedId
    private MatriculaNrcPK pk;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "numero", nullable = false)
    private short numero;
    @Column(name = "costo", nullable = false, precision = 7, scale = 2)
    private BigDecimal costo;
    @JoinColumns({
        @JoinColumn(name = "cod_matricula", referencedColumnName = "cod_matricula", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Matricula matricula;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nrc nrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculaNrc")
    private List<Calificacion> calificaciones;

    public MatriculaNrc() {
    }

    public MatriculaNrc(MatriculaNrcPK eduMatriculaNrcPK) {
        this.pk = eduMatriculaNrcPK;
    }

    public MatriculaNrc(String codMatricula, int codPersona, short codNrc, int codPeriodo, int codDepartamento, int codMateria) {
        this.pk = new MatriculaNrcPK(codMatricula, codPersona, codNrc, codPeriodo, codDepartamento, codMateria);
    }

    public MatriculaNrcPK getPk() {
        return pk;
    }

    public void setPk(MatriculaNrcPK pk) {
        this.pk = pk;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Nrc getNrc() {
        return nrc;
    }

    public void setNrc(Nrc nrc) {
        this.nrc = nrc;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MatriculaNrc)) {
            return false;
        }
        MatriculaNrc other = (MatriculaNrc) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduMatriculaNrc[ eduMatriculaNrcPK=" + pk + " ]";
    }
    
}
