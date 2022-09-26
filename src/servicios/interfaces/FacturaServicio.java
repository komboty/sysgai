package servicios.interfaces;

import basedatos.daos.interfaces.GenericDAO;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface FacturaServicio<T, K> extends GenericDAO<T> {

    public K crearFactura(int idContrato, int impuesto);
}
