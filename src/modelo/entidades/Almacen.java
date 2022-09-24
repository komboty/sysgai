package modelo.entidades;

import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Almacen extends ObjectInit {

    private Cliente cliente;
    private String direcccion;
    private List<DetalleProducto> productos;

    public Almacen() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDirecccion() {
        return direcccion;
    }

    public void setDirecccion(String direcccion) {
        this.direcccion = direcccion;
    }

    public List<DetalleProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<DetalleProducto> productos) {
        this.productos = productos;
    }

}
