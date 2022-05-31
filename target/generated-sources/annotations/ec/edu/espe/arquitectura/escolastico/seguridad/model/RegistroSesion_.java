package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-31T15:37:48", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(RegistroSesion.class)
public class RegistroSesion_ { 

    public static volatile SingularAttribute<RegistroSesion, String> codUsuario;
    public static volatile SingularAttribute<RegistroSesion, String> ipConexion;
    public static volatile SingularAttribute<RegistroSesion, String> resultado;
    public static volatile SingularAttribute<RegistroSesion, Integer> secuencia;
    public static volatile SingularAttribute<RegistroSesion, String> error;
    public static volatile SingularAttribute<RegistroSesion, Date> fechaConexion;

}