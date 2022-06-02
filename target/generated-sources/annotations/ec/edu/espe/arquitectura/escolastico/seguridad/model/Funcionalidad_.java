package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.PerfilFuncionalidad;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-01T20:30:28", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Funcionalidad.class)
public class Funcionalidad_ { 

    public static volatile SingularAttribute<Funcionalidad, String> descripcion;
    public static volatile SingularAttribute<Funcionalidad, String> estado;
    public static volatile SingularAttribute<Funcionalidad, String> audUsuario;
    public static volatile SingularAttribute<Funcionalidad, Date> audFecha;
    public static volatile SingularAttribute<Funcionalidad, String> audIp;
    public static volatile SingularAttribute<Funcionalidad, String> urlPrincipal;
    public static volatile SingularAttribute<Funcionalidad, Integer> codFuncionalidad;
    public static volatile SingularAttribute<Funcionalidad, String> nombre;
    public static volatile SingularAttribute<Funcionalidad, Integer> version;
    public static volatile SingularAttribute<Funcionalidad, Modulo> modulo;
    public static volatile ListAttribute<Funcionalidad, PerfilFuncionalidad> perfilFuncionalidades;

}