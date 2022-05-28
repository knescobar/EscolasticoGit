package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MateriaPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Prerequisito;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-28T17:42:49", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, BigDecimal> horas;
    public static volatile SingularAttribute<Materia, MateriaPK> eduMateriaPK;
    public static volatile SingularAttribute<Materia, BigDecimal> ponderacion;
    public static volatile ListAttribute<Materia, Nrc> eduNrcList;
    public static volatile SingularAttribute<Materia, Departamento> eduDepartamento;
    public static volatile ListAttribute<Materia, MallaCarrera> eduMallaCarreraList;
    public static volatile ListAttribute<Materia, Prerequisito> eduPrerequisitoList1;
    public static volatile ListAttribute<Materia, Prerequisito> eduPrerequisitoList;
    public static volatile SingularAttribute<Materia, BigDecimal> creditos;
    public static volatile SingularAttribute<Materia, String> nombre;

}