/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.escolastico.general.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author nicol
 */
@Embeddable
public class PaisEstructuraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_pais", nullable = false, length = 2)
    private String codPais;
    @Basic(optional = false)
    @Column(name = "nivel", nullable = false)
    private short nivel;

    public PaisEstructuraPK() {
    }

    public PaisEstructuraPK(String codPais, short nivel) {
        this.codPais = codPais;
        this.nivel = nivel;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public short getNivel() {
        return nivel;
    }

    public void setNivel(short nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        hash += (int) nivel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaisEstructuraPK)) {
            return false;
        }
        PaisEstructuraPK other = (PaisEstructuraPK) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.GenPaisEstructuraPK[ codPais=" + codPais + ", nivel=" + nivel + " ]";
    }
    
}
