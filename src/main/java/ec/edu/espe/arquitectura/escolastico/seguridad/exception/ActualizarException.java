package ec.edu.espe.arquitectura.escolastico.seguridad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ActualizarException extends RuntimeException {
    public ActualizarException(String message) {
        super(message);
    }
}
