package servicios.implementaciones;

import persistencia.daos.interfaces.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.utils.UtilsModelo;
import servicios.dtos.ClienteDTO;
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
    public List<ClienteDTO> getTodos(String filtro, String valor) {
        List<Cliente> clientes = clienteDAO.getTodos();
        List<ClienteDTO> objectToStringDTO = new ArrayList<>();
        for (Cliente cliente : clientes) {
            objectToStringDTO.add(UtilsModelo.clienteToClienteDTO(cliente));
        }
        return objectToStringDTO;
    }

    @Override
    public boolean eliminarPorId(int id) {
        return clienteDAO.eliminarPorId(id);
    }

    @Override
    public ClienteDTO crearCliente(int idTipoNivelCliente, String nombre,
            String telefono, String mail, String direccion) {

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setMail(mail);
        cliente.setDireccion(direccion);
        cliente.setNivel(String.valueOf(idTipoNivelCliente));

        // Se registra en la base de datos.
        cliente = clienteDAO.registrar(cliente);
        // Si no se registro el usuario.
        if (cliente == null) {
            return null;
        }
        //Si se registro el usuario.        
        return UtilsModelo.clienteToClienteDTO(cliente);
    }

}
