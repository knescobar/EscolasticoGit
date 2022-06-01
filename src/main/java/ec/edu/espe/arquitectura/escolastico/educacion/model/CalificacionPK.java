package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CalificacionPK implements Serializable {

    @Column(name = "cod_matricula", nullable = false, length = 10)
    private String codMatricula;
    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;
    @Column(name = "cod_nrc", nullable = false)
    private Integer codNrc;

    public CalificacionPK() {
    }

    public CalificacionPK(String codMatricula, Integer codPersona, Integer codNrc) {
        this.codMatricula = codMatricula;
        this.codPersona = codPersona;
        this.codNrc = codNrc;
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

    public Integer getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(Integer codNrc) {
        this.codNrc = codNrc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.codMatricula);
        hash = 61 * hash + Objects.hashCode(this.codPersona);
        hash = 61 * hash + Objects.hashCode(this.codNrc);
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
        final CalificacionPK other = (CalificacionPK) obj;
        if (!Objects.equals(this.codMatricula, other.codMatricula)) {
            return false;
        }
        if (!Objects.equals(this.codPersona, other.codPersona)) {
            return false;
        }
        if (!Objects.equals(this.codNrc, other.codNrc)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.EduCalificacionPK[ codMatricula=" + codMatricula + ", codPersona=" + codPersona + ", codNrc=" + codNrc + " ]";
    }

}
