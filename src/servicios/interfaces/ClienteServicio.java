package servicios.interfaces;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface ClienteServicio<T, K> extends GenericServicio<T> {

    public K crearCliente(int idTipoNivelCliente, String nombre, String telefono,
            String mail, String direccion);
}
