package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorarioPK;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Aula;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-31T19:18:19", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(NrcHorario.class)
public class NrcHorario_ { 

    public static volatile SingularAttribute<NrcHorario, Date> horaFin;
    public static volatile SingularAttribute<NrcHorario, Aula> aula;
    public static volatile SingularAttribute<NrcHorario, NrcHorarioPK> pk;
    public static volatile SingularAttribute<NrcHorario, Date> horaInicio;
    public static volatile SingularAttribute<NrcHorario, Nrc> nrc;

}