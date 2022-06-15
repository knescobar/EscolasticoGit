package ec.edu.espe.arquitectura.escolastico.seguridad.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Getter
@RequiredArgsConstructor
public class CrearUsuarioDto {
    private String codUsuario;

    @Email(message = "El correo ingresado no es válido")
    private String mail;
    private String nombre;

    @Pattern(regexp = "\\d{10}")
    private String telefono;
    private String origen;

    @Size(min=1, message = "Los perfiles del usuario son requeridos")
    private List<String> perfiles;
}
