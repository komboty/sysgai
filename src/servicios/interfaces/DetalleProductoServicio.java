package servicios.interfaces;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface DetalleProductoServicio<T, K> extends GenericServicio<T> {

//    public DetalleProducto crearDetalleProducto(int idProducto, int idAlmacen, int idTipoEstadoProducto, String serie, int contadorCliente, int contadorProducto);
    public K crearDetalleImpresora(int idProducto, int idAlmacen, int idTipoEstadoProducto,
            String serie, int contadorCliente, int contadorProducto);

    public K crearDetalleRefaccion(int idProducto, int idAlmacen, String serie);

    public K crearDetalleToner(int idProducto, int idAlmacen, String serie);

}
