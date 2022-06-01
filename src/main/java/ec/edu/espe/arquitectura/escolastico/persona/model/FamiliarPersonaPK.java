package ec.edu.espe.arquitectura.escolastico.persona.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FamiliarPersonaPK implements Serializable {

    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;
    @Column(name = "sec_familiar_persona", nullable = false)
    private Integer secFamiliarPersona;

    public FamiliarPersonaPK() {
    }

    public FamiliarPersonaPK(Integer codPersona, Integer secFamiliarPersona) {
        this.codPersona = codPersona;
        this.secFamiliarPersona = secFamiliarPersona;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public Integer getSecFamiliarPersona() {
        return secFamiliarPersona;
    }

    public void setSecFamiliarPersona(Integer secFamiliarPersona) {
        this.secFamiliarPersona = secFamiliarPersona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codPersona);
        hash = 67 * hash + Objects.hashCode(this.secFamiliarPersona);
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
        final FamiliarPersonaPK other = (FamiliarPersonaPK) obj;
        if (!Objects.equals(this.codPersona, other.codPersona)) {
            return false;
        }
        if (!Objects.equals(this.secFamiliarPersona, other.secFamiliarPersona)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.PerFamiliarPersonaPK[ codPersona=" + codPersona + ", secFamiliarPersona=" + secFamiliarPersona + " ]";
    }

}
