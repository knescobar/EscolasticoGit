package ec.edu.espe.arquitectura.escolastico.educacion.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum TipoMatriculaEnum {

    PRIMERA("1", "Primera matrícula"),
    SEGUNDA("2", "Segunda matrícula"),
    TERCERA("3", "Tercera matrícula");

    private final String valor;
    private final String texto;
}
