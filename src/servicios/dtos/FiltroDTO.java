package servicios.dtos;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class FiltroDTO {

    private String nombre;
    private String valor;

    public FiltroDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
