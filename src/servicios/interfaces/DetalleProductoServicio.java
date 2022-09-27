package servicios.interfaces;

import servicios.dtos.DetalleProductoDTO;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface DetalleProductoServicio extends GenericServicio<DetalleProductoDTO> {

//    public DetalleProducto crearDetalleProducto(int idProducto, int idAlmacen, int idTipoEstadoProducto, String serie, int contadorCliente, int contadorProducto);
    public DetalleProductoDTO crearDetalleImpresora(int idProducto, int idAlmacen, int idTipoEstadoProducto, String serie, int contadorCliente, int contadorProducto);

    public DetalleProductoDTO crearDetalleRefaccion(int idProducto, int idAlmacen, String serie);

    public DetalleProductoDTO crearDetalleToner(int idProducto, int idAlmacen, String serie);

}
