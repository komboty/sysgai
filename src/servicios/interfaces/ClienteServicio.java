package servicios.interfaces;

import servicios.dtos.ClienteDTO;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface ClienteServicio extends GenericServicio<ClienteDTO> {

    public ClienteDTO crearCliente(int idTipoNivelCliente, String nombre, String telefono,
            String mail, String direccion);
}
