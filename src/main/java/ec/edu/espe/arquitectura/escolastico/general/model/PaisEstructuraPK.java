package ec.edu.espe.arquitectura.escolastico.general.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PaisEstructuraPK implements Serializable {

    @Column(name = "cod_pais", nullable = false, length = 2)
    private String codPais;
    @Column(name = "nivel", nullable = false)
    private Integer nivel;

    public PaisEstructuraPK() {
    }

    public PaisEstructuraPK(String codPais, Integer nivel) {
        this.codPais = codPais;
        this.nivel = nivel;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codPais);
        hash = 97 * hash + Objects.hashCode(this.nivel);
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
        final PaisEstructuraPK other = (PaisEstructuraPK) obj;
        if (!Objects.equals(this.codPais, other.codPais)) {
            return false;
        }
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.GenPaisEstructuraPK[ codPais=" + codPais + ", nivel=" + nivel + " ]";
    }

}
