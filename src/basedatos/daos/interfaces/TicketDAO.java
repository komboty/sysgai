package basedatos.daos.interfaces;

import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface TicketDAO<T> extends GenericDAO<T> {
    
    public List<T> getAsignados(int idUsuario);
}
