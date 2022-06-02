package ec.edu.espe.arquitectura.escolastico.general.model;

import ec.edu.espe.arquitectura.escolastico.general.model.Pais;
import ec.edu.espe.arquitectura.escolastico.general.model.PaisEstructuraPK;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-01T20:30:28", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(PaisEstructura.class)
public class PaisEstructura_ { 

    public static volatile SingularAttribute<PaisEstructura, String> audUsuario;
    public static volatile SingularAttribute<PaisEstructura, Date> audFecha;
    public static volatile SingularAttribute<PaisEstructura, String> audIp;
    public static volatile SingularAttribute<PaisEstructura, PaisEstructuraPK> pk;
    public static volatile SingularAttribute<PaisEstructura, String> nombre;
    public static volatile SingularAttribute<PaisEstructura, Integer> version;
    public static volatile SingularAttribute<PaisEstructura, Pais> pais;

}