package ec.edu.espe.arquitectura.escolastico.persona.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.DocumentoPersona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-01T20:30:28", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(TipoDocumento.class)
public class TipoDocumento_ { 

    public static volatile ListAttribute<TipoDocumento, DocumentoPersona> perDocumentoPersonaList;
    public static volatile SingularAttribute<TipoDocumento, String> audUsuario;
    public static volatile SingularAttribute<TipoDocumento, Date> audFecha;
    public static volatile SingularAttribute<TipoDocumento, String> codTipoDocumento;
    public static volatile SingularAttribute<TipoDocumento, String> audIp;
    public static volatile SingularAttribute<TipoDocumento, String> nombre;
    public static volatile SingularAttribute<TipoDocumento, Integer> version;

}