package ec.edu.espe.arquitectura.escolastico.general.model;

import ec.edu.espe.arquitectura.escolastico.general.model.UbicacionGeografica;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-28T17:21:04", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(InstitucionGen.class)
public class InstitucionGen_ { 

    public static volatile SingularAttribute<InstitucionGen, String> ruc;
    public static volatile SingularAttribute<InstitucionGen, String> razonSocial;
    public static volatile SingularAttribute<InstitucionGen, String> urlSistema;
    public static volatile SingularAttribute<InstitucionGen, String> dominio;
    public static volatile SingularAttribute<InstitucionGen, String> direccion;
    public static volatile SingularAttribute<InstitucionGen, String> nombreComercial;
    public static volatile SingularAttribute<InstitucionGen, String> urlInfo;
    public static volatile SingularAttribute<InstitucionGen, UbicacionGeografica> codUbicacionGeoInt;
    public static volatile SingularAttribute<InstitucionGen, Integer> version;

}