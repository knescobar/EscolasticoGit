package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-28T17:42:49", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Nrc.class)
public class Nrc_ { 

    public static volatile SingularAttribute<Nrc, Short> cupoDisponible;
    public static volatile ListAttribute<Nrc, MatriculaNrc> eduMatriculaNrcList;
    public static volatile SingularAttribute<Nrc, Persona> codPersona;
    public static volatile ListAttribute<Nrc, NrcHorario> eduNrcHorarioList;
    public static volatile SingularAttribute<Nrc, NrcPK> eduNrcPK;
    public static volatile SingularAttribute<Nrc, Materia> eduMateria;
    public static volatile SingularAttribute<Nrc, Short> cupoRegistrado;
    public static volatile SingularAttribute<Nrc, Periodo> eduPeriodo;
    public static volatile SingularAttribute<Nrc, String> nombre;

}