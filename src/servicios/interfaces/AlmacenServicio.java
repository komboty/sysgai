package servicios.interfaces;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface AlmacenServicio<T, K> extends GenericServicio<T> {

    public K crearAlmacen(int idCliente, String direccion);
}
