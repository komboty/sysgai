package servicios.implementaciones;

import basedatos.daos.interfaces.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.utils.UtilsModelo;
import servicios.dtos.ObjectToStringDTO;
import servicios.interfaces.ClienteServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ClienteServicioImpl implements ClienteServicio<ObjectToStringDTO, ObjectToStringDTO> {

    private ClienteDAO clienteDAO;

    public ClienteServicioImpl(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public List<ObjectToStringDTO> getTodos(String filtro, String valor) {
        List<Cliente> clientes = clienteDAO.getTodos();
        List<ObjectToStringDTO> objectToStringDTO = new ArrayList<>();
        for (Cliente cliente : clientes) {
            objectToStringDTO.add(UtilsModelo.clienteToObjectToStringDTO(cliente));
        }
        return objectToStringDTO;
    }

    @Override
    public boolean eliminarPorId(int id) {
        return clienteDAO.eliminarPorId(id);
    }

    @Override
    public ObjectToStringDTO crearCliente(int idTipoNivelCliente, String nombre, String telefono, String mail, String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
