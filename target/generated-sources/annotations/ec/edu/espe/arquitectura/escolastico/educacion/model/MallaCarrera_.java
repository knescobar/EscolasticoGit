package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T17:07:34", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(MallaCarrera.class)
public class MallaCarrera_ { 

    public static volatile SingularAttribute<MallaCarrera, Integer> codMateriacarrera;
    public static volatile SingularAttribute<MallaCarrera, Materia> materia;
    public static volatile SingularAttribute<MallaCarrera, Carrera> carrera;
    public static volatile SingularAttribute<MallaCarrera, Integer> nivel;

}