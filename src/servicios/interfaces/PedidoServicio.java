package servicios.interfaces;

import persistencia.daos.interfaces.GenericDAO;
import java.util.List;
import servicios.dtos.PedidoDTO;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface PedidoServicio extends GenericDAO<PedidoDTO> {
    
    public PedidoDTO crearPedido(int idArrendador, int idContrato, List<Integer> idsDetalleProducto);
    
}
