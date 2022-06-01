package ec.edu.espe.arquitectura.escolastico.persona.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DireccionPersonaPK implements Serializable {

    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;
    @Column(name = "sec_direccion", nullable = false)
    private Integer secDireccion;

    public DireccionPersonaPK() {
    }

    public DireccionPersonaPK(Integer codPersona, Integer secDireccion) {
        this.codPersona = codPersona;
        this.secDireccion = secDireccion;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public Integer getSecDireccion() {
        return secDireccion;
    }

    public void setSecDireccion(Integer secDireccion) {
        this.secDireccion = secDireccion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.codPersona);
        hash = 41 * hash + Objects.hashCode(this.secDireccion);
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
        final DireccionPersonaPK other = (DireccionPersonaPK) obj;
        if (!Objects.equals(this.codPersona, other.codPersona)) {
            return false;
        }
        if (!Objects.equals(this.secDireccion, other.secDireccion)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.PerDireccionPersonaPK[ codPersona=" + codPersona + ", secDireccion=" + secDireccion + " ]";
    }

}
