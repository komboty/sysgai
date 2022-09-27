package servicios.interfaces;

import modelo.entidades.DetalleProducto;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface DetalleProductoServicio extends GenericServicio<DetalleProducto> {

//    public DetalleProducto crearDetalleProducto(int idProducto, int idAlmacen, int idTipoEstadoProducto, String serie, int contadorCliente, int contadorProducto);
    public DetalleProducto crearDetalleImpresora(int idProducto, int idAlmacen, int idTipoEstadoProducto, String serie, int contadorCliente, int contadorProducto);

    public DetalleProducto crearDetalleRefaccion(int idProducto, int idAlmacen, String serie);

    public DetalleProducto crearDetalleToner(int idProducto, int idAlmacen, String serie);

}
