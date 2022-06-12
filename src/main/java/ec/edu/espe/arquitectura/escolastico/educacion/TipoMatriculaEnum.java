package ec.edu.espe.arquitectura.escolastico.educacion;

public enum TipoMatriculaEnum {

    PRIMERA("1M", "Primera matrícula"),
    SEGUNDA("2M", "Segunda matrícula"),
    TERCERA("3M", "Tercera matrícula");

    private final String valor;
    private final String texto;

    private TipoMatriculaEnum(String valor, String texto) {
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
