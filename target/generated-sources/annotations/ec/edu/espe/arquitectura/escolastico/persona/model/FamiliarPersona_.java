package ec.edu.espe.arquitectura.escolastico.persona.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.FamiliarPersonaPK;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T21:18:21", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(FamiliarPersona.class)
public class FamiliarPersona_ { 

    public static volatile SingularAttribute<FamiliarPersona, String> audUsuario;
    public static volatile SingularAttribute<FamiliarPersona, Persona> persona;
    public static volatile SingularAttribute<FamiliarPersona, Date> audFecha;
    public static volatile SingularAttribute<FamiliarPersona, String> tipoIdentificacion;
    public static volatile SingularAttribute<FamiliarPersona, Date> fechaNacimiento;
    public static volatile SingularAttribute<FamiliarPersona, String> identificacion;
    public static volatile SingularAttribute<FamiliarPersona, String> tipoFamiliar;
    public static volatile SingularAttribute<FamiliarPersona, String> audIp;
    public static volatile SingularAttribute<FamiliarPersona, FamiliarPersonaPK> pk;
    public static volatile SingularAttribute<FamiliarPersona, String> telefono;
    public static volatile SingularAttribute<FamiliarPersona, String> nombre;
    public static volatile SingularAttribute<FamiliarPersona, Integer> version;

}