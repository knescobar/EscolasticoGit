package ec.edu.espe.arquitectura.escolastico.educacion;

public enum TipoCalificacionEnum {

    APROBADO("APR", "Aprobado"),
    REPROBADO("REP", "Reprobado");

    private final String valor;
    private final String texto;

    private TipoCalificacionEnum(String valor, String texto) {
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
