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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "edu_matricula_nrc")

public class MatriculaNrc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculaNrcPK eduMatriculaNrcPK;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Basic(optional = false)
    @Column(name = "numero", nullable = false)
    private short numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "costo", nullable = false, precision = 7, scale = 2)
    private BigDecimal costo;
    @JoinColumns({
        @JoinColumn(name = "cod_matricula", referencedColumnName = "cod_matricula", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Matricula eduMatricula;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nrc eduNrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMatriculaNrc")
    private List<Calificacion> eduCalificacionList;

    public MatriculaNrc() {
    }

    public MatriculaNrc(MatriculaNrcPK eduMatriculaNrcPK) {
        this.eduMatriculaNrcPK = eduMatriculaNrcPK;
    }

    public MatriculaNrc(MatriculaNrcPK eduMatriculaNrcPK, String estado, short numero, BigDecimal costo) {
        this.eduMatriculaNrcPK = eduMatriculaNrcPK;
        this.estado = estado;
        this.numero = numero;
        this.costo = costo;
    }

    public MatriculaNrc(String codMatricula, int codPersona, short codNrc, int codPeriodo, int codDepartamento, int codMateria) {
        this.eduMatriculaNrcPK = new MatriculaNrcPK(codMatricula, codPersona, codNrc, codPeriodo, codDepartamento, codMateria);
    }

    public MatriculaNrcPK getEduMatriculaNrcPK() {
        return eduMatriculaNrcPK;
    }

    public void setEduMatriculaNrcPK(MatriculaNrcPK eduMatriculaNrcPK) {
        this.eduMatriculaNrcPK = eduMatriculaNrcPK;
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

    public Matricula getEduMatricula() {
        return eduMatricula;
    }

    public void setEduMatricula(Matricula eduMatricula) {
        this.eduMatricula = eduMatricula;
    }

    public Nrc getEduNrc() {
        return eduNrc;
    }

    public void setEduNrc(Nrc eduNrc) {
        this.eduNrc = eduNrc;
    }

    public List<Calificacion> getEduCalificacionList() {
        return eduCalificacionList;
    }

    public void setEduCalificacionList(List<Calificacion> eduCalificacionList) {
        this.eduCalificacionList = eduCalificacionList;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduMatriculaNrcPK != null ? eduMatriculaNrcPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatriculaNrc)) {
            return false;
        }
        MatriculaNrc other = (MatriculaNrc) object;
        if ((this.eduMatriculaNrcPK == null && other.eduMatriculaNrcPK != null) || (this.eduMatriculaNrcPK != null && !this.eduMatriculaNrcPK.equals(other.eduMatriculaNrcPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduMatriculaNrc[ eduMatriculaNrcPK=" + eduMatriculaNrcPK + " ]";
    }
    
}
