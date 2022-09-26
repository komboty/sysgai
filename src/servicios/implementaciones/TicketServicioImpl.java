package servicios.implementaciones;

import basedatos.daos.interfaces.TicketDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Ticket;
import static modelo.utils.ConstantesModelo.*;
import modelo.utils.UtilsModelo;
import servicios.dtos.ObjectToStringDTO;
import servicios.interfaces.TicketServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class TicketServicioImpl implements TicketServicio<ObjectToStringDTO, ObjectToStringDTO> {

    private TicketDAO ticketDAO;

    public TicketServicioImpl(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @Override
    public List<ObjectToStringDTO> getTodos(String filtro, String valor) {
        List<Ticket> tickets;
        if (filtro.equals(FILTRO_ASIGNADOS)) {
            tickets = ticketDAO.getAsignados(Integer.parseInt(valor));
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
    public ObjectToStringDTO crearTicketFalla(int idTipoPrioridad, int idUsuario, int idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObjectToStringDTO crearTicketToner(int idTipoPrioridad, int idUsuario, int idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
