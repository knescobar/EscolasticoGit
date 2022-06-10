package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Funcionalidad;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-09T17:57:55", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Modulo.class)
public class Modulo_ { 

    public static volatile SingularAttribute<Modulo, String> estado;
    public static volatile SingularAttribute<Modulo, String> codModulo;
    public static volatile SingularAttribute<Modulo, String> nombre;
    public static volatile SingularAttribute<Modulo, Integer> version;
    public static volatile ListAttribute<Modulo, Funcionalidad> funcionalidades;

}