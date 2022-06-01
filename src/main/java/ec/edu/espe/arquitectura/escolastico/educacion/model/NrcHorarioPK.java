package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NrcHorarioPK implements Serializable {

    @Column(name = "cod_nrc", nullable = false)
    private Integer codNrc;
    @Column(name = "cod_periodo", nullable = false)
    private Integer codPeriodo;
    @Column(name = "cod_departamento", nullable = false)
    private Integer codDepartamento;
    @Column(name = "cod_materia", nullable = false)
    private Integer codMateria;
    @Column(name = "cod_aula", nullable = false)
    private Integer codAula;
    @Column(name = "dia_semana", nullable = false, length = 25)
    private String diaSemana;

    public NrcHorarioPK() {
    }

    public NrcHorarioPK(Integer codNrc, Integer codPeriodo, Integer codDepartamento, Integer codMateria, Integer codAula, String diaSemana) {
        this.codNrc = codNrc;
        this.codPeriodo = codPeriodo;
        this.codDepartamento = codDepartamento;
        this.codMateria = codMateria;
        this.codAula = codAula;
        this.diaSemana = diaSemana;
    }

    public Integer getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(Integer codNrc) {
        this.codNrc = codNrc;
    }

    public Integer getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Integer codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    public Integer getCodAula() {
        return codAula;
    }

    public void setCodAula(Integer codAula) {
        this.codAula = codAula;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codNrc;
        hash += (int) codPeriodo;
        hash += (int) codDepartamento;
        hash += (int) codMateria;
        hash += (int) codAula;
        hash += (diaSemana != null ? diaSemana.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NrcHorarioPK other = (NrcHorarioPK) obj;
        if (!Objects.equals(this.diaSemana, other.diaSemana)) {
            return false;
        }
        if (!Objects.equals(this.codNrc, other.codNrc)) {
            return false;
        }
        if (!Objects.equals(this.codPeriodo, other.codPeriodo)) {
            return false;
        }
        if (!Objects.equals(this.codDepartamento, other.codDepartamento)) {
            return false;
        }
        if (!Objects.equals(this.codMateria, other.codMateria)) {
            return false;
        }
        if (!Objects.equals(this.codAula, other.codAula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduNrcHorarioPK[ codNrc=" + codNrc + ", codPeriodo=" + codPeriodo + ", codDepartamento=" + codDepartamento + ", codMateria=" + codMateria + ", codAula=" + codAula + ", diaSemana=" + diaSemana + " ]";
    }

}
