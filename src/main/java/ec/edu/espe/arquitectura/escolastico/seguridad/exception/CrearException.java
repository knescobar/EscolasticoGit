package ec.edu.espe.arquitectura.escolastico.seguridad.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CrearException extends RuntimeException {

    public CrearException(String message) {
        super(message);
    }

}
