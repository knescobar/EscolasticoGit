package ec.edu.espe.arquitectura.escolastico.persona.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.general.model.Pais;
import ec.edu.espe.arquitectura.escolastico.general.model.UbicacionGeografica;
import ec.edu.espe.arquitectura.escolastico.persona.model.DireccionPersona;
import ec.edu.espe.arquitectura.escolastico.persona.model.DocumentoPersona;
import ec.edu.espe.arquitectura.escolastico.persona.model.TipoDiscapacidad;
import ec.edu.espe.arquitectura.escolastico.persona.model.TipoPersona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-05-29T17:07:33", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> estado;
    public static volatile SingularAttribute<Persona, String> audUsuario;
    public static volatile SingularAttribute<Persona, TipoPersona> tipoPersona;
    public static volatile SingularAttribute<Persona, Integer> codPersona;
    public static volatile SingularAttribute<Persona, String> tipoIdentificacion;
    public static volatile SingularAttribute<Persona, Date> fechaNacimiento;
    public static volatile SingularAttribute<Persona, Short> porcentajeDiscapacidad;
    public static volatile SingularAttribute<Persona, String> nombre2;
    public static volatile SingularAttribute<Persona, String> nombreCompleto;
    public static volatile SingularAttribute<Persona, String> nombre1;
    public static volatile SingularAttribute<Persona, Pais> nacionalidad;
    public static volatile ListAttribute<Persona, DocumentoPersona> documentos;
    public static volatile SingularAttribute<Persona, Date> audFecha;
    public static volatile SingularAttribute<Persona, String> carnetConadis;
    public static volatile SingularAttribute<Persona, String> genero;
    public static volatile SingularAttribute<Persona, Pais> codPaisNacimiento;
    public static volatile SingularAttribute<Persona, String> requiereRepresentante;
    public static volatile SingularAttribute<Persona, String> codigoAlterno;
    public static volatile SingularAttribute<Persona, String> email;
    public static volatile SingularAttribute<Persona, String> apellido2;
    public static volatile ListAttribute<Persona, Nrc> eduNrcList;
    public static volatile SingularAttribute<Persona, String> apellido1;
    public static volatile SingularAttribute<Persona, String> nombreComun;
    public static volatile SingularAttribute<Persona, String> identificacion;
    public static volatile SingularAttribute<Persona, String> estadoCivil;
    public static volatile SingularAttribute<Persona, Integer> version;
    public static volatile SingularAttribute<Persona, TipoDiscapacidad> tipoDiscapacidad;
    public static volatile SingularAttribute<Persona, String> extranjero;
    public static volatile ListAttribute<Persona, Matricula> eduMatriculaList;
    public static volatile ListAttribute<Persona, DireccionPersona> perDireccionPersonaList;
    public static volatile SingularAttribute<Persona, String> emailAlterno;
    public static volatile SingularAttribute<Persona, String> discapacidad;
    public static volatile SingularAttribute<Persona, String> telefonoMovil;
    public static volatile SingularAttribute<Persona, String> audIp;
    public static volatile SingularAttribute<Persona, UbicacionGeografica> lugarNacimiento;

}