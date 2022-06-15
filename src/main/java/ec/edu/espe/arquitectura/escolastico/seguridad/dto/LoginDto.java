package ec.edu.espe.arquitectura.escolastico.seguridad.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginDto {
    private final String codigoOMail;
    private final String password;
}
