package ec.edu.espe.arquitectura.escolastico.persona.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-28T17:42:50", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(TipoDiscapacidad.class)
public class TipoDiscapacidad_ { 

    public static volatile SingularAttribute<TipoDiscapacidad, String> audUsuario;
    public static volatile SingularAttribute<TipoDiscapacidad, Date> audFecha;
    public static volatile ListAttribute<TipoDiscapacidad, Persona> perPersonaList;
    public static volatile SingularAttribute<TipoDiscapacidad, String> audIp;
    public static volatile SingularAttribute<TipoDiscapacidad, String> codTipoDiscapacidad;
    public static volatile SingularAttribute<TipoDiscapacidad, String> nombre;
    public static volatile SingularAttribute<TipoDiscapacidad, Integer> version;

}