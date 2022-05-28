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

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-28T17:42:49", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(MatriculaNrc.class)
public class MatriculaNrc_ { 

    public static volatile SingularAttribute<MatriculaNrc, String> estado;
    public static volatile SingularAttribute<MatriculaNrc, Short> numero;
    public static volatile SingularAttribute<MatriculaNrc, BigDecimal> costo;
    public static volatile SingularAttribute<MatriculaNrc, Nrc> eduNrc;
    public static volatile ListAttribute<MatriculaNrc, Calificacion> eduCalificacionList;
    public static volatile SingularAttribute<MatriculaNrc, MatriculaNrcPK> eduMatriculaNrcPK;
    public static volatile SingularAttribute<MatriculaNrc, Matricula> eduMatricula;

}