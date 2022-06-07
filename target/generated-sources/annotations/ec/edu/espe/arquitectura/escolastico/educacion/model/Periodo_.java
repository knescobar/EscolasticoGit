package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-07T13:21:23", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Periodo.class)
public class Periodo_ { 

    public static volatile SingularAttribute<Periodo, Date> fechaInicio;
    public static volatile SingularAttribute<Periodo, Matricula> matricula;
    public static volatile SingularAttribute<Periodo, Integer> codPeriodo;
    public static volatile SingularAttribute<Periodo, String> nombre;
    public static volatile SingularAttribute<Periodo, String> nivel;
    public static volatile SingularAttribute<Periodo, Date> fechaFin;
    public static volatile SingularAttribute<Periodo, Integer> parciales;
    public static volatile SingularAttribute<Periodo, Nrc> nrc;

}