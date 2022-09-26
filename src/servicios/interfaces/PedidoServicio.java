package servicios.interfaces;

import basedatos.daos.interfaces.GenericDAO;
import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface PedidoServicio<T, K> extends GenericDAO<T> {

    public K crearPedido(int idArrendador, int idContrato, List<Integer> idsDetalleProducto);

}
