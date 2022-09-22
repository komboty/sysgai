package servicios.implementaciones;

import basedatos.daos.implementaciones.ClienteDAOImpl;
import basedatos.daos.interfaces.ClienteDAO;
import java.util.List;
import modelo.clases.Cliente;
import servicios.interfaces.ClienteServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ClienteServicioImpl implements ClienteServicio {

    private static ClienteDAO clienteDAO = new ClienteDAOImpl();

    public ClienteServicioImpl() {
    }

    @Override
    public List<Cliente> getTodos() {
        return clienteDAO.getTodos();
    }

}
