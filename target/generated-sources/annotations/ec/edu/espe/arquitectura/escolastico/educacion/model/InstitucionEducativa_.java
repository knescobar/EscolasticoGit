package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.general.model.UbicacionGeografica;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-31T19:18:19", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(InstitucionEducativa.class)
public class InstitucionEducativa_ { 

    public static volatile SingularAttribute<InstitucionEducativa, Integer> codInstitucionEducativa;
    public static volatile SingularAttribute<InstitucionEducativa, String> tipo;
    public static volatile SingularAttribute<InstitucionEducativa, String> audUsuario;
    public static volatile SingularAttribute<InstitucionEducativa, Date> audFecha;
    public static volatile SingularAttribute<InstitucionEducativa, String> direccion;
    public static volatile SingularAttribute<InstitucionEducativa, UbicacionGeografica> ubicacionGeo;
    public static volatile SingularAttribute<InstitucionEducativa, String> audIp;
    public static volatile SingularAttribute<InstitucionEducativa, String> nombre;
    public static volatile SingularAttribute<InstitucionEducativa, Integer> version;

}