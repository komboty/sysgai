package servicios.implementaciones;

import basedatos.daos.interfaces.TicketDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Ticket;
import static modelo.utils.ConstantesModelo.*;
import modelo.utils.UtilsModelo;
import servicios.dtos.FiltroDTO;
import servicios.dtos.ObjectToStringDTO;
import servicios.interfaces.TicketServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class TicketServicioImpl implements TicketServicio {

    private TicketDAO ticketDAO;

    public TicketServicioImpl(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @Override
    public List<ObjectToStringDTO> getTodos(FiltroDTO filtroDTO) {
        List<Ticket> tickets;
        if (filtroDTO.getNombre() != null && filtroDTO.getNombre().equals(FILTRO_ASIGNADOS)) {
            tickets = ticketDAO.getAsignados(Integer.parseInt(filtroDTO.getValor()));
        } else {
            tickets = ticketDAO.getTodos();
        }
        List<ObjectToStringDTO> objectToStringDTO = new ArrayList<>();
        for (Ticket ticket : tickets) {
            objectToStringDTO.add(UtilsModelo.ticketToObjectToStringDTO(ticket));
        }
        return objectToStringDTO;
    }

    @Override
    public boolean eliminarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ticket crearTicketFalla(int idTipoPrioridad, int idUsuario, int idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ticket crearTicketToner(int idTipoPrioridad, int idUsuario, int idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
