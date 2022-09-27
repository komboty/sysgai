package servicios.interfaces;

import modelo.entidades.Cliente;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface ClienteServicio extends GenericServicio<Cliente> {

    public Cliente crearCliente(int idTipoNivelCliente, String nombre, String telefono,
            String mail, String direccion);
}
