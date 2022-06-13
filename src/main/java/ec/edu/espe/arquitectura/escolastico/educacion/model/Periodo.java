package ec.edu.espe.arquitectura.escolastico.educacion.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "edu_periodo")
public class Periodo implements Serializable {

    private static final long serialVersionUID = 58758691L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_periodo", nullable = false)
    private Integer codPeriodo;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "nivel", nullable = false, length = 32)
    private String nivel;
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "parciales", nullable = false)
    private Integer parciales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    @JsonManagedReference(value = "nrc-periodo")
    private List<Nrc> nrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    @JsonManagedReference(value = "matricula-periodo")
    private List<Matricula> matriculas;

    public Periodo() {
    }

    public Periodo(Integer codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Integer getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Integer codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getParciales() {
        return parciales;
    }

    public void setParciales(Integer parciales) {
        this.parciales = parciales;
    }

    public List<Nrc> getNrc() {
        return nrc;
    }

    public void setNrc(List<Nrc> nrc) {
        this.nrc = nrc;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPeriodo != null ? codPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.codPeriodo == null && other.codPeriodo != null)
                || (this.codPeriodo != null && !this.codPeriodo.equals(other.codPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduPeriodo[ codPeriodo=" + codPeriodo + " ]";
    }

}
