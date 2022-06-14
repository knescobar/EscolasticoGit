package ec.edu.espe.arquitectura.escolastico.educacion.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum EstadoMatriculaEnum {
    APROBADO("APR", "Aprobado"),
    REPROBADO("REP", "Reprobado"),
    INSCRITO("INS", "Inscrito"),
    RETIRADO("RET", "Retirado");

    private final String valor;
    private final String texto;
}
