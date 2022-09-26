package modelo.entidades;

import java.util.List;
import modelo.utils.UtilsModelo;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Area extends ObjectInit {

    private String nombre;
    private List<Usuario> empleados;
    private List<Ticket> tickets;

    public Area() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Usuario> empleados) {
        this.empleados = empleados;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
