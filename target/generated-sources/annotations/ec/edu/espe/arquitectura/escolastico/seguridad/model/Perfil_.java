package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.PerfilFuncionalidad;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T21:35:08", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile SingularAttribute<Perfil, String> estado;
    public static volatile SingularAttribute<Perfil, String> audUsuario;
    public static volatile SingularAttribute<Perfil, String> codPerfil;
    public static volatile SingularAttribute<Perfil, Date> audFecha;
    public static volatile ListAttribute<Perfil, PerfilFuncionalidad> perfilesFuncionalidad;
    public static volatile SingularAttribute<Perfil, String> audIp;
    public static volatile SingularAttribute<Perfil, String> nombre;
    public static volatile SingularAttribute<Perfil, Integer> version;

}