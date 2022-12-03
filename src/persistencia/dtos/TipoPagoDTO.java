package persistencia.dtos;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class TipoPagoDTO {

    private int id;
    private String tipo;

    public TipoPagoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
