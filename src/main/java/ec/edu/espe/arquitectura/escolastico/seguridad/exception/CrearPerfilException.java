package ec.edu.espe.arquitectura.escolastico.seguridad.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CrearPerfilException extends RuntimeException {

    public CrearPerfilException(String message) {
        super(message);
    }

}
