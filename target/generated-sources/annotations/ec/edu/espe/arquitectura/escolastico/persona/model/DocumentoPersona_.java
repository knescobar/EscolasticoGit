package ec.edu.espe.arquitectura.escolastico.persona.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.DocumentoPersonaPK;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.persona.model.TipoDocumento;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-31T15:37:49", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(DocumentoPersona.class)
public class DocumentoPersona_ { 

    public static volatile SingularAttribute<DocumentoPersona, Date> fechaCaducidad;
    public static volatile SingularAttribute<DocumentoPersona, String> estado;
    public static volatile SingularAttribute<DocumentoPersona, String> digitalizado;
    public static volatile SingularAttribute<DocumentoPersona, String> audUsuario;
    public static volatile SingularAttribute<DocumentoPersona, Persona> persona;
    public static volatile SingularAttribute<DocumentoPersona, Date> fechaRegistro;
    public static volatile SingularAttribute<DocumentoPersona, Date> fechaEmision;
    public static volatile SingularAttribute<DocumentoPersona, Integer> version;
    public static volatile SingularAttribute<DocumentoPersona, String> url;
    public static volatile SingularAttribute<DocumentoPersona, TipoDocumento> tipoDocumento;
    public static volatile SingularAttribute<DocumentoPersona, Date> audFecha;
    public static volatile SingularAttribute<DocumentoPersona, String> archivado;
    public static volatile SingularAttribute<DocumentoPersona, String> audIp;
    public static volatile SingularAttribute<DocumentoPersona, DocumentoPersonaPK> pk;

}