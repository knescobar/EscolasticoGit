package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MateriaPK implements Serializable {

    @Column(name = "cod_materia", nullable = false)
    private Integer codMateria;
    @Column(name = "cod_departamento", nullable = false)
    private Integer codDepartamento;

    public MateriaPK() {
    }

    public MateriaPK(Integer codMateria, Integer codDepartamento) {
        this.codMateria = codMateria;
        this.codDepartamento = codDepartamento;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.codMateria);
        hash = 83 * hash + Objects.hashCode(this.codDepartamento);
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
        final MateriaPK other = (MateriaPK) obj;
        if (!Objects.equals(this.codMateria, other.codMateria)) {
            return false;
        }
        if (!Objects.equals(this.codDepartamento, other.codDepartamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduMateriaPK[ codMateria=" + codMateria + ", codDepartamento=" + codDepartamento + " ]";
    }

}
