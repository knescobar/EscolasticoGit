package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.UsuarioPerfilPK;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-07T19:20:19", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(UsuarioPerfil.class)
public class UsuarioPerfil_ { 

    public static volatile SingularAttribute<UsuarioPerfil, String> audUsuario;
    public static volatile SingularAttribute<UsuarioPerfil, Date> audFecha;
    public static volatile SingularAttribute<UsuarioPerfil, String> audIp;
    public static volatile SingularAttribute<UsuarioPerfil, Usuario> usuario;
    public static volatile SingularAttribute<UsuarioPerfil, UsuarioPerfilPK> pk;
    public static volatile SingularAttribute<UsuarioPerfil, Integer> version;
    public static volatile SingularAttribute<UsuarioPerfil, Perfil> perfil;

}