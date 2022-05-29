package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T17:07:34", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, Date> fecha;
    public static volatile SingularAttribute<Matricula, String> tipo;
    public static volatile SingularAttribute<Matricula, Persona> persona;
    public static volatile SingularAttribute<Matricula, Double> costo;
    public static volatile SingularAttribute<Matricula, Periodo> periodo;
    public static volatile ListAttribute<Matricula, MatriculaNrc> matriculaNrc;
    public static volatile SingularAttribute<Matricula, MatriculaPK> pk;
    public static volatile SingularAttribute<Matricula, Carrera> carrera;

}