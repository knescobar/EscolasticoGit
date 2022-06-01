package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Funcionalidad;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.PerfilFuncionalidadPK;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-31T19:18:19", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(PerfilFuncionalidad.class)
public class PerfilFuncionalidad_ { 

    public static volatile SingularAttribute<PerfilFuncionalidad, String> audUsuario;
    public static volatile SingularAttribute<PerfilFuncionalidad, Date> audFecha;
    public static volatile SingularAttribute<PerfilFuncionalidad, Funcionalidad> funcionalidad;
    public static volatile SingularAttribute<PerfilFuncionalidad, String> audIp;
    public static volatile SingularAttribute<PerfilFuncionalidad, PerfilFuncionalidadPK> pk;
    public static volatile SingularAttribute<PerfilFuncionalidad, Integer> version;
    public static volatile SingularAttribute<PerfilFuncionalidad, Perfil> perfil;

}