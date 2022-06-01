package ec.edu.espe.arquitectura.escolastico.organizacionFisica.model;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Edificio;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Institucion;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-31T19:18:19", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Sede.class)
public class Sede_ { 

    public static volatile SingularAttribute<Sede, String> codSede;
    public static volatile SingularAttribute<Sede, String> audUsuario;
    public static volatile SingularAttribute<Sede, Date> audFecha;
    public static volatile SingularAttribute<Sede, String> direccion;
    public static volatile SingularAttribute<Sede, String> esPrincipal;
    public static volatile SingularAttribute<Sede, Institucion> institucion;
    public static volatile SingularAttribute<Sede, String> audIp;
    public static volatile SingularAttribute<Sede, String> nombre;
    public static volatile SingularAttribute<Sede, Integer> version;
    public static volatile ListAttribute<Sede, Edificio> edificios;

}