package ec.edu.espe.arquitectura.escolastico.persona.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.HistTipoPersonaPK;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import ec.edu.espe.arquitectura.escolastico.persona.model.TipoPersona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-28T17:21:04", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(HistTipoPersona.class)
public class HistTipoPersona_ { 

    public static volatile SingularAttribute<HistTipoPersona, Persona> perPersona;
    public static volatile SingularAttribute<HistTipoPersona, HistTipoPersonaPK> perHistTipoPersonaPK;
    public static volatile SingularAttribute<HistTipoPersona, TipoPersona> perTipoPersona;
    public static volatile SingularAttribute<HistTipoPersona, String> audUsuario;
    public static volatile SingularAttribute<HistTipoPersona, Date> audFecha;
    public static volatile SingularAttribute<HistTipoPersona, Date> fechaInicio;
    public static volatile SingularAttribute<HistTipoPersona, String> codUsuarioFin;
    public static volatile SingularAttribute<HistTipoPersona, String> audIp;
    public static volatile SingularAttribute<HistTipoPersona, String> codUsuarioIni;
    public static volatile SingularAttribute<HistTipoPersona, Date> fechaFin;
    public static volatile SingularAttribute<HistTipoPersona, Integer> version;

}