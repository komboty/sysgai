package modelo.entidades;

import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Pedido extends ObjectInit {

    private String estado;
    private Ticket ticket;
    private Usuario arrendador;
    private Contrato contrato;
    private List<DetalleProducto> productos;

    public Pedido() {
    }

    public void validar() {
    }

    public void surtir() {
    }

    public void distribuir() {
    }

    public void instalar() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Usuario getArrendador() {
        return arrendador;
    }

    public void setArrendador(Usuario arrendador) {
        this.arrendador = arrendador;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public List<DetalleProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<DetalleProducto> productos) {
        this.productos = productos;
    }

}
