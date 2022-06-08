package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-07T18:54:54", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> descripcion;
    public static volatile ListAttribute<Departamento, Carrera> carreras;
    public static volatile SingularAttribute<Departamento, Integer> codDepartamento;
    public static volatile SingularAttribute<Departamento, String> siglas;
    public static volatile SingularAttribute<Departamento, String> nombre;
    public static volatile ListAttribute<Departamento, Materia> materias;

}