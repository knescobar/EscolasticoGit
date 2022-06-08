package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrcPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-07T18:54:54", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(MatriculaNrc.class)
public class MatriculaNrc_ { 

    public static volatile SingularAttribute<MatriculaNrc, String> estado;
    public static volatile SingularAttribute<MatriculaNrc, Integer> numero;
    public static volatile SingularAttribute<MatriculaNrc, BigDecimal> costo;
    public static volatile ListAttribute<MatriculaNrc, Calificacion> calificaciones;
    public static volatile SingularAttribute<MatriculaNrc, Matricula> matricula;
    public static volatile SingularAttribute<MatriculaNrc, MatriculaNrcPK> pk;
    public static volatile SingularAttribute<MatriculaNrc, Nrc> nrc;

}