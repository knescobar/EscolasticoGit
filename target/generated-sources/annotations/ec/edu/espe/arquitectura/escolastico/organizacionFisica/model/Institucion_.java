package ec.edu.espe.arquitectura.escolastico.organizacionFisica.model;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Sede;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T21:18:21", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Institucion.class)
public class Institucion_ { 

    public static volatile SingularAttribute<Institucion, String> ruc;
    public static volatile SingularAttribute<Institucion, String> razonSocial;
    public static volatile SingularAttribute<Institucion, String> audUsuario;
    public static volatile ListAttribute<Institucion, Sede> sedes;
    public static volatile SingularAttribute<Institucion, Date> audFecha;
    public static volatile SingularAttribute<Institucion, Short> codInstitucion;
    public static volatile SingularAttribute<Institucion, String> dominio;
    public static volatile SingularAttribute<Institucion, String> nombreComercial;
    public static volatile SingularAttribute<Institucion, String> audIp;
    public static volatile SingularAttribute<Institucion, Integer> version;

}