package ec.edu.espe.arquitectura.escolastico.persona.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.HistTipoPersona;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-28T17:21:04", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(TipoPersona.class)
public class TipoPersona_ { 

    public static volatile SingularAttribute<TipoPersona, String> descripcion;
    public static volatile SingularAttribute<TipoPersona, String> estado;
    public static volatile SingularAttribute<TipoPersona, String> audUsuario;
    public static volatile SingularAttribute<TipoPersona, Date> audFecha;
    public static volatile ListAttribute<TipoPersona, Persona> perPersonaList;
    public static volatile SingularAttribute<TipoPersona, String> audIp;
    public static volatile SingularAttribute<TipoPersona, String> nombre;
    public static volatile SingularAttribute<TipoPersona, Integer> version;
    public static volatile ListAttribute<TipoPersona, HistTipoPersona> perHistTipoPersonaList;
    public static volatile SingularAttribute<TipoPersona, String> codTipoPersona;

}