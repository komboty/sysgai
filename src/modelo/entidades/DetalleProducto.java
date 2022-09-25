package modelo.entidades;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class DetalleProducto extends ObjectInit {

    private int contadorCliente;
    private int contadorProducto;
    private String serie;
    private String estado;

    public DetalleProducto() {
    }

    public void restablecerContadorCliente() {
    }

    public int getContadorCliente() {
        return contadorCliente;
    }

    public void setContadorCliente(int contadorCliente) {
        this.contadorCliente = contadorCliente;
    }

    public int getContadorProducto() {
        return contadorProducto;
    }

    public void setContadorProducto(int contadorProducto) {
        this.contadorProducto = contadorProducto;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
