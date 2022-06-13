package ec.edu.espe.arquitectura.escolastico.educacion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CuposInsuficientesException extends RuntimeException {
    public CuposInsuficientesException(String message) {
        super(message);
    }
}
