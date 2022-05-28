package ec.edu.espe.arquitectura.escolastico.organizacionFisica.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Edificio;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.EdificioBloque;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.TipoAula;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-28T17:21:04", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Aula.class)
public class Aula_ { 

    public static volatile SingularAttribute<Aula, Short> piso;
    public static volatile SingularAttribute<Aula, Integer> codAula;
    public static volatile SingularAttribute<Aula, EdificioBloque> codEdificioBloque;
    public static volatile SingularAttribute<Aula, String> audUsuario;
    public static volatile SingularAttribute<Aula, String> codAlterno;
    public static volatile SingularAttribute<Aula, Date> audFecha;
    public static volatile SingularAttribute<Aula, Edificio> codEdificio;
    public static volatile ListAttribute<Aula, NrcHorario> eduNrcHorarioList;
    public static volatile SingularAttribute<Aula, String> audIp;
    public static volatile SingularAttribute<Aula, TipoAula> codTipoAula;
    public static volatile SingularAttribute<Aula, Integer> version;
    public static volatile SingularAttribute<Aula, Short> capacidad;

}