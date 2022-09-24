package modelo.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.utils.Utils;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Usuario extends Persona {

    private Area area;
    private String contrasenia;
    private List<Ticket> tickets;
    private List<Pedido> pedidos;

    public Usuario() {
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        String toString;
        if (isToStringTodos()) {
            
            toString = String.format("%s\n-----------------\nAREA:%s\n-----------------\nTickets Asignados: %d\n",
                    super.toString(), area.toString(), Utils.getSize(tickets));
        } else {
            toString = String.format("%s", super.toString());
        }
        return toString;
    }
}
