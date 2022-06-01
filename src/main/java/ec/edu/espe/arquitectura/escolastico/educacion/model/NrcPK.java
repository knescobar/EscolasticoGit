package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NrcPK implements Serializable {

    @Column(name = "cod_nrc", nullable = false)
    private Integer codNrc;
    @Column(name = "cod_periodo", nullable = false)
    private Integer codPeriodo;
    @Column(name = "cod_departamento", nullable = false)
    private Integer codDepartamento;
    @Column(name = "cod_materia", nullable = false)
    private Integer codMateria;

    public NrcPK() {
    }

    public NrcPK(Integer codNrc, Integer codPeriodo, Integer codDepartamento, Integer codMateria) {
        this.codNrc = codNrc;
        this.codPeriodo = codPeriodo;
        this.codDepartamento = codDepartamento;
        this.codMateria = codMateria;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codNrc;
        hash += (int) codPeriodo;
        hash += (int) codDepartamento;
        hash += (int) codMateria;
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
        final NrcPK other = (NrcPK) obj;
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
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduNrcPK[ codNrc=" + codNrc + ", codPeriodo=" + codPeriodo + ", codDepartamento=" + codDepartamento + ", codMateria=" + codMateria + " ]";
    }

}
