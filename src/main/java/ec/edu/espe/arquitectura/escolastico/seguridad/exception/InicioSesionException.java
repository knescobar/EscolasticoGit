package ec.edu.espe.arquitectura.escolastico.seguridad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InicioSesionException extends RuntimeException {
    public InicioSesionException(String message) {
        super(message);
    }
}
