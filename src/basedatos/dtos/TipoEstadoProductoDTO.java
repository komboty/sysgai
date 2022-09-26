package basedatos.dtos;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class TipoEstadoProductoDTO {

    private int id;
    private String tipo;

    public TipoEstadoProductoDTO() {
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
