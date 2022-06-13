package ec.edu.espe.arquitectura.escolastico.educacion.dto;

import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrcPK;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class MatriculaDto {
    // Usado para el update
    private String codMatricula;

    @NotNull(message = "El código de la persona es requerido")
    private Integer codPersona;

    @NotNull(message = "El tipo de matrícula es requerido")
    @NotEmpty(message = "El tipo de matrícula es requerido")
    private String tipo;

    @NotNull(message = "El código de la carrera es requerido")
    private Integer codCarrera;

    @NotNull(message = "El código del período es requerido")
    private Integer codPeriodo;

    @NotNull(message = "Las matrículas inscritas son requeridas")
    @Size(min = 1, max = 6, message = "Se debe tener entre 1 y 6 materia(s)")
    private List<MatriculaNrcPK> matriculaNrcPKs;
}
