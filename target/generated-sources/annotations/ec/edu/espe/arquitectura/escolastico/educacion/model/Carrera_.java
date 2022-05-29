package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T17:07:34", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Carrera.class)
public class Carrera_ { 

    public static volatile SingularAttribute<Carrera, String> grado;
    public static volatile SingularAttribute<Carrera, String> nombre;
    public static volatile SingularAttribute<Carrera, Integer> totalSemestres;
    public static volatile ListAttribute<Carrera, MallaCarrera> mallaCarrera;
    public static volatile SingularAttribute<Carrera, Integer> codCarrera;
    public static volatile SingularAttribute<Carrera, String> modalidad;
    public static volatile SingularAttribute<Carrera, BigDecimal> totalHoras;
    public static volatile SingularAttribute<Carrera, String> siglas;
    public static volatile SingularAttribute<Carrera, Departamento> departamento;
    public static volatile SingularAttribute<Carrera, BigDecimal> totalCreditos;
    public static volatile SingularAttribute<Carrera, BigDecimal> precioCredito;
    public static volatile SingularAttribute<Carrera, String> nivel;
    public static volatile SingularAttribute<Carrera, String> perfilProfesional;

}