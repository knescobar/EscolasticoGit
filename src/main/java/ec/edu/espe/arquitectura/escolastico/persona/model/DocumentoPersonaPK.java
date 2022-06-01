package ec.edu.espe.arquitectura.escolastico.persona.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DocumentoPersonaPK implements Serializable {

    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;
    @Column(name = "cod_tipo_documento", nullable = false, length = 16)
    private String codTipoDocumento;

    public DocumentoPersonaPK() {
    }

    public DocumentoPersonaPK(Integer codPersona, String codTipoDocumento) {
        this.codPersona = codPersona;
        this.codTipoDocumento = codTipoDocumento;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(String codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.codPersona);
        hash = 71 * hash + Objects.hashCode(this.codTipoDocumento);
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
        final DocumentoPersonaPK other = (DocumentoPersonaPK) obj;
        if (!Objects.equals(this.codTipoDocumento, other.codTipoDocumento)) {
            return false;
        }
        if (!Objects.equals(this.codPersona, other.codPersona)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.PerDocumentoPersonaPK[ codPersona=" + codPersona + ", codTipoDocumento=" + codTipoDocumento + " ]";
    }

}
