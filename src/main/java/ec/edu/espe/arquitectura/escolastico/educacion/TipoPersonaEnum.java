package ec.edu.espe.arquitectura.escolastico.educacion;

public enum TipoPersonaEnum {

    DOCENTE("DOC", "Docente"),
    ESTUDIANTE("EST", "Estudiante"),
    ADMINISTRATIVO("ADM", "Administrativo");

    private final String valor;
    private final String texto;

    private TipoPersonaEnum(String valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }

    public String getTexto() {
        return this.texto;
    }

    public String getValor() {
        return this.valor;
    }
}
