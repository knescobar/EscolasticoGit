package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MatriculaPK implements Serializable {

    @Column(name = "cod_matricula", nullable = false, length = 10)
    private String codMatricula;
    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;

    public MatriculaPK() {
    }

    public MatriculaPK(String codMatricula, Integer codPersona) {
        this.codMatricula = codMatricula;
        this.codPersona = codPersona;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.codMatricula);
        hash = 79 * hash + Objects.hashCode(this.codPersona);
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
        final MatriculaPK other = (MatriculaPK) obj;
        if (!Objects.equals(this.codMatricula, other.codMatricula)) {
            return false;
        }
        if (!Objects.equals(this.codPersona, other.codPersona)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MatriculaPK [codMatricula=" + codMatricula + ", codPersona=" + codPersona + "]";
    }

}
