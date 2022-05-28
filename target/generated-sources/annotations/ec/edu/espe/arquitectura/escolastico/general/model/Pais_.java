package ec.edu.espe.arquitectura.escolastico.general.model;

import ec.edu.espe.arquitectura.escolastico.general.model.PaisEstructura;
import ec.edu.espe.arquitectura.escolastico.general.model.UbicacionGeografica;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-28T17:42:49", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, String> audUsuario;
    public static volatile ListAttribute<Pais, Persona> perPersonaList;
    public static volatile SingularAttribute<Pais, String> codigoTelefonico;
    public static volatile SingularAttribute<Pais, String> codPais;
    public static volatile ListAttribute<Pais, PaisEstructura> genPaisEstructuraList;
    public static volatile SingularAttribute<Pais, String> nombre;
    public static volatile SingularAttribute<Pais, Integer> version;
    public static volatile SingularAttribute<Pais, String> nacionalidad;
    public static volatile SingularAttribute<Pais, String> porOmision;
    public static volatile SingularAttribute<Pais, Date> audFecha;
    public static volatile ListAttribute<Pais, UbicacionGeografica> genUbicacionGeograficaList;
    public static volatile SingularAttribute<Pais, String> audIp;
    public static volatile ListAttribute<Pais, Persona> perPersonaList1;

}