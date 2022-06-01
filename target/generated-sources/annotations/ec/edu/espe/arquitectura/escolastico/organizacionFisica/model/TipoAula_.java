package ec.edu.espe.arquitectura.escolastico.organizacionFisica.model;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Aula;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-01T18:22:08", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(TipoAula.class)
public class TipoAula_ { 

    public static volatile SingularAttribute<TipoAula, String> descripcion;
    public static volatile SingularAttribute<TipoAula, String> audUsuario;
    public static volatile SingularAttribute<TipoAula, Date> audFecha;
    public static volatile ListAttribute<TipoAula, Aula> aulas;
    public static volatile SingularAttribute<TipoAula, String> codTipoAula;
    public static volatile SingularAttribute<TipoAula, String> audIp;
    public static volatile SingularAttribute<TipoAula, Integer> version;

}