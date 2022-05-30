package ec.edu.espe.arquitectura.escolastico.organizacionFisica.model;

import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.EdificioBloque;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.model.Sede;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T21:35:08", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Edificio.class)
public class Edificio_ { 

    public static volatile SingularAttribute<Edificio, String> descripcion;
    public static volatile SingularAttribute<Edificio, String> manejaBloques;
    public static volatile SingularAttribute<Edificio, String> audUsuario;
    public static volatile SingularAttribute<Edificio, String> codAlterno;
    public static volatile SingularAttribute<Edificio, Short> pisos;
    public static volatile SingularAttribute<Edificio, Sede> sede;
    public static volatile SingularAttribute<Edificio, String> direccion;
    public static volatile ListAttribute<Edificio, EdificioBloque> bloques;
    public static volatile SingularAttribute<Edificio, String> comentario;
    public static volatile SingularAttribute<Edificio, String> nombre;
    public static volatile SingularAttribute<Edificio, Integer> version;
    public static volatile SingularAttribute<Edificio, String> codEdificio;
    public static volatile SingularAttribute<Edificio, Date> audFecha;
    public static volatile SingularAttribute<Edificio, String> poseeAulas;
    public static volatile SingularAttribute<Edificio, String> audIp;

}