package servicios.interfaces;

import modelo.entidades.Ticket;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface TicketServicio extends GenericServicio<Ticket> {

//    public Ticket crearTicket(int idTipoPrioridad, int idTipoTicket, int idUsuario, int idPedido, String descripcion);
    public Ticket crearTicketFalla(int idTipoPrioridad, int idUsuario, int idPedido);

    public Ticket crearTicketToner(int idTipoPrioridad, int idUsuario, int idPedido);
}
