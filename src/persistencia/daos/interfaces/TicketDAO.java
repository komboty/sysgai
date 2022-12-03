package persistencia.daos.interfaces;

import java.util.List;
import modelo.entidades.Ticket;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface TicketDAO extends GenericDAO<Ticket> {
    
    public List<Ticket> getAsignados(int idUsuario);
}
