package ec.edu.espe.arquitectura.escolastico.educacion.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum TipoPersonaEnum {

    DOCENTE("DOC", "Docente"),
    ESTUDIANTE("EST", "Estudiante"),
    ADMINISTRATIVO("ADM", "Administrativo");

    private final String valor;
    private final String texto;
}
