package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T17:07:33", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Prerequisito.class)
public class Prerequisito_ { 

    public static volatile SingularAttribute<Prerequisito, String> tipo;
    public static volatile SingularAttribute<Prerequisito, Integer> codPrerequisito;
    public static volatile SingularAttribute<Prerequisito, Materia> materia;
    public static volatile SingularAttribute<Prerequisito, Materia> prerequisito;

}