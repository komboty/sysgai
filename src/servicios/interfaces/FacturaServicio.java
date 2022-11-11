package servicios.interfaces;

import persistencia.daos.interfaces.GenericDAO;
import servicios.dtos.FacturaDTO;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface FacturaServicio extends GenericDAO<FacturaDTO>{
    
    public FacturaDTO crearFactura(int idContrato, int impuesto);
}
