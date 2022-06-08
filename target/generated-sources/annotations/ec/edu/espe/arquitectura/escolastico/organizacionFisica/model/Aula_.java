package ec.edu.espe.arquitectura.escolastico.organizacionFisica.model;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Edificio;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.EdificioBloque;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.TipoAula;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-07T18:54:54", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Aula.class)
public class Aula_ { 

    public static volatile SingularAttribute<Aula, Integer> piso;
    public static volatile SingularAttribute<Aula, Integer> codAula;
    public static volatile SingularAttribute<Aula, String> audUsuario;
    public static volatile SingularAttribute<Aula, String> codAlterno;
    public static volatile SingularAttribute<Aula, Date> audFecha;
    public static volatile SingularAttribute<Aula, String> audIp;
    public static volatile SingularAttribute<Aula, Integer> version;
    public static volatile SingularAttribute<Aula, Edificio> edificio;
    public static volatile SingularAttribute<Aula, EdificioBloque> bloque;
    public static volatile SingularAttribute<Aula, TipoAula> tipoAula;
    public static volatile SingularAttribute<Aula, Integer> capacidad;

}