package ec.edu.espe.arquitectura.escolastico.persona.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HistTipoPersonaPK implements Serializable {

    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;
    @Column(name = "cod_tipo_persona", nullable = false, length = 3)
    private String codTipoPersona;

    public HistTipoPersonaPK() {
    }

    public HistTipoPersonaPK(Integer codPersona, String codTipoPersona) {
        this.codPersona = codPersona;
        this.codTipoPersona = codTipoPersona;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodTipoPersona() {
        return codTipoPersona;
    }

    public void setCodTipoPersona(String codTipoPersona) {
        this.codTipoPersona = codTipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.codPersona);
        hash = 59 * hash + Objects.hashCode(this.codTipoPersona);
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
        final HistTipoPersonaPK other = (HistTipoPersonaPK) obj;
        if (!Objects.equals(this.codTipoPersona, other.codTipoPersona)) {
            return false;
        }
        if (!Objects.equals(this.codPersona, other.codPersona)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.PerHistTipoPersonaPK[ codPersona=" + codPersona + ", codTipoPersona=" + codTipoPersona + " ]";
    }

}
