package ec.edu.espe.arquitectura.escolastico.general.model;

import ec.edu.espe.arquitectura.escolastico.general.model.InstitucionGeneral;
import ec.edu.espe.arquitectura.escolastico.general.model.Pais;
import ec.edu.espe.arquitectura.escolastico.general.model.PaisEstructura;
import ec.edu.espe.arquitectura.escolastico.general.model.UbicacionGeografica;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T17:07:34", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(UbicacionGeografica.class)
public class UbicacionGeografica_ { 

    public static volatile SingularAttribute<UbicacionGeografica, String> audUsuario;
    public static volatile ListAttribute<UbicacionGeografica, InstitucionGeneral> instituciones;
    public static volatile SingularAttribute<UbicacionGeografica, String> codigoPostal;
    public static volatile SingularAttribute<UbicacionGeografica, String> codUbicacionGeografica;
    public static volatile SingularAttribute<UbicacionGeografica, String> codigoAreaTelefono;
    public static volatile SingularAttribute<UbicacionGeografica, Pais> codPais;
    public static volatile SingularAttribute<UbicacionGeografica, PaisEstructura> paisEstructura;
    public static volatile SingularAttribute<UbicacionGeografica, String> nombre;
    public static volatile SingularAttribute<UbicacionGeografica, Integer> version;
    public static volatile SingularAttribute<UbicacionGeografica, Date> audFecha;
    public static volatile SingularAttribute<UbicacionGeografica, String> audIp;
    public static volatile SingularAttribute<UbicacionGeografica, String> codigoAlterno;
    public static volatile SingularAttribute<UbicacionGeografica, Integer> codUbicacionGeoInt;
    public static volatile SingularAttribute<UbicacionGeografica, UbicacionGeografica> ubicacionGeoPadre;

}