package ec.edu.espe.arquitectura.escolastico.organizacionFisica.model;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Aula;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Edificio;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T21:35:08", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(EdificioBloque.class)
public class EdificioBloque_ { 

    public static volatile SingularAttribute<EdificioBloque, String> descripcion;
    public static volatile SingularAttribute<EdificioBloque, String> codEdificioBloque;
    public static volatile SingularAttribute<EdificioBloque, String> nombreBloque;
    public static volatile SingularAttribute<EdificioBloque, String> audUsuario;
    public static volatile SingularAttribute<EdificioBloque, Date> audFecha;
    public static volatile ListAttribute<EdificioBloque, Aula> aulas;
    public static volatile SingularAttribute<EdificioBloque, String> audIp;
    public static volatile SingularAttribute<EdificioBloque, Integer> version;
    public static volatile SingularAttribute<EdificioBloque, Edificio> edificio;

}