package servicios.interfaces;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface TicketServicio<T, K> extends GenericServicio<T> {

//    public Ticket crearTicket(int idTipoPrioridad, int idTipoTicket, int idUsuario, int idPedido, String descripcion);
    public K crearTicketFalla(int idTipoPrioridad, int idUsuario, int idPedido);

    public K crearTicketToner(int idTipoPrioridad, int idUsuario, int idPedido);
}
