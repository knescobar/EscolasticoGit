package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorarioPK;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Aula;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-28T17:42:49", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(NrcHorario.class)
public class NrcHorario_ { 

    public static volatile SingularAttribute<NrcHorario, Date> horaFin;
    public static volatile SingularAttribute<NrcHorario, Aula> ofiAula;
    public static volatile SingularAttribute<NrcHorario, Nrc> eduNrc;
    public static volatile SingularAttribute<NrcHorario, NrcHorarioPK> eduNrcHorarioPK;
    public static volatile SingularAttribute<NrcHorario, Date> horaInicio;

}