package ec.edu.espe.arquitectura.escolastico.general.model;

import ec.edu.espe.arquitectura.escolastico.general.model.UbicacionGeografica;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T21:35:08", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(InstitucionGeneral.class)
public class InstitucionGeneral_ { 

    public static volatile SingularAttribute<InstitucionGeneral, String> ruc;
    public static volatile SingularAttribute<InstitucionGeneral, String> razonSocial;
    public static volatile SingularAttribute<InstitucionGeneral, String> urlSistema;
    public static volatile SingularAttribute<InstitucionGeneral, String> dominio;
    public static volatile SingularAttribute<InstitucionGeneral, String> direccion;
    public static volatile SingularAttribute<InstitucionGeneral, UbicacionGeografica> ubicacionGeo;
    public static volatile SingularAttribute<InstitucionGeneral, String> nombreComercial;
    public static volatile SingularAttribute<InstitucionGeneral, String> urlInfo;
    public static volatile SingularAttribute<InstitucionGeneral, Integer> version;

}