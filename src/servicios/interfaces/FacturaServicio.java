package servicios.interfaces;

import basedatos.daos.interfaces.GenericDAO;
import modelo.entidades.Factura;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface FacturaServicio extends GenericDAO<Factura>{
    
    public Factura crearFactura(int idContrato, int impuesto);
}
