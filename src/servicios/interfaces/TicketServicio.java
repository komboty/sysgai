package servicios.interfaces;

import servicios.dtos.TicketDTO;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface TicketServicio extends GenericServicio<TicketDTO> {

//    public TicketDTO crearTicket(int idTipoPrioridad, int idTipoTicket, int idUsuario, int idPedido, String descripcion);
    public TicketDTO crearTicketFalla(int idTipoPrioridad, int idUsuario, int idPedido);

    public TicketDTO crearTicketToner(int idTipoPrioridad, int idUsuario, int idPedido);
}
