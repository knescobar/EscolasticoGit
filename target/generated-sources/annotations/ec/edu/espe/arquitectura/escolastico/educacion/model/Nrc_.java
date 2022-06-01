package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-01T18:22:09", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Nrc.class)
public class Nrc_ { 

    public static volatile SingularAttribute<Nrc, Integer> cupoDisponible;
    public static volatile SingularAttribute<Nrc, Persona> persona;
    public static volatile ListAttribute<Nrc, NrcHorario> horario;
    public static volatile SingularAttribute<Nrc, Periodo> periodo;
    public static volatile SingularAttribute<Nrc, Integer> cupoRegistrado;
    public static volatile SingularAttribute<Nrc, Materia> materia;
    public static volatile SingularAttribute<Nrc, NrcPK> pk;
    public static volatile SingularAttribute<Nrc, String> nombre;

}