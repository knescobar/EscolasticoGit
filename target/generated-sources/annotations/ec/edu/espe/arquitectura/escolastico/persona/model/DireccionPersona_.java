package ec.edu.espe.arquitectura.escolastico.persona.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.DireccionPersonaPK;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T17:18:52", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(DireccionPersona.class)
public class DireccionPersona_ { 

    public static volatile SingularAttribute<DireccionPersona, String> barrio;
    public static volatile SingularAttribute<DireccionPersona, String> audUsuario;
    public static volatile SingularAttribute<DireccionPersona, Persona> persona;
    public static volatile SingularAttribute<DireccionPersona, String> direccionAdicional;
    public static volatile SingularAttribute<DireccionPersona, String> callePrincipal;
    public static volatile SingularAttribute<DireccionPersona, String> numeracion;
    public static volatile SingularAttribute<DireccionPersona, Integer> version;
    public static volatile SingularAttribute<DireccionPersona, String> principal;
    public static volatile SingularAttribute<DireccionPersona, Integer> codOrgGeoDireccion;
    public static volatile SingularAttribute<DireccionPersona, Date> audFecha;
    public static volatile SingularAttribute<DireccionPersona, String> audIp;
    public static volatile SingularAttribute<DireccionPersona, DireccionPersonaPK> pk;
    public static volatile SingularAttribute<DireccionPersona, String> telefono;
    public static volatile SingularAttribute<DireccionPersona, String> calleSecundaria;
    public static volatile SingularAttribute<DireccionPersona, String> codTipoDireccion;
    public static volatile SingularAttribute<DireccionPersona, String> referencia;

}