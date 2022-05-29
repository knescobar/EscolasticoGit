package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.CalificacionPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-28T23:17:19", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Calificacion.class)
public class Calificacion_ { 

    public static volatile SingularAttribute<Calificacion, BigDecimal> nota1;
    public static volatile SingularAttribute<Calificacion, BigDecimal> nota4;
    public static volatile SingularAttribute<Calificacion, BigDecimal> nota5;
    public static volatile SingularAttribute<Calificacion, BigDecimal> nota2;
    public static volatile SingularAttribute<Calificacion, BigDecimal> promedio;
    public static volatile SingularAttribute<Calificacion, BigDecimal> nota3;
    public static volatile SingularAttribute<Calificacion, BigDecimal> nota8;
    public static volatile SingularAttribute<Calificacion, BigDecimal> nota9;
    public static volatile SingularAttribute<Calificacion, BigDecimal> nota6;
    public static volatile SingularAttribute<Calificacion, BigDecimal> nota10;
    public static volatile SingularAttribute<Calificacion, BigDecimal> nota7;
    public static volatile SingularAttribute<Calificacion, MatriculaNrc> matriculaNrc;
    public static volatile SingularAttribute<Calificacion, CalificacionPK> pk;
    public static volatile SingularAttribute<Calificacion, String> observacion;

}