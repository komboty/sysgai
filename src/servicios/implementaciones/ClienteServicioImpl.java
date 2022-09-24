package servicios.implementaciones;

import basedatos.daos.interfaces.ClienteDAO;
import java.util.List;
import modelo.entidades.Cliente;
import servicios.interfaces.ClienteServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ClienteServicioImpl implements ClienteServicio {

    private ClienteDAO clienteDAO;

    public ClienteServicioImpl(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public List<Cliente> getTodos() {
        return clienteDAO.getTodos();
    }

}
