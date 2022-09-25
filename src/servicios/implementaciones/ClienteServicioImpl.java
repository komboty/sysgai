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

    @Override
    public boolean eliminarPorId(int id) {
        return clienteDAO.eliminarPorId(id);
    }

    @Override
    public Cliente crearCliente(int idTipoNivelCliente, String nombre, String telefono, String mail, String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
