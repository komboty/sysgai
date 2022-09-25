package servicios.interfaces;

import basedatos.daos.interfaces.GenericDAO;
import java.util.List;
import modelo.entidades.Pedido;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface PedidoServicio extends GenericDAO<Pedido> {
    
    public Pedido crearPedido(int idArrendador, int idContrato, List<Integer> idsDetalleProducto);
    
}
