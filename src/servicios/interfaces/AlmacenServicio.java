package servicios.interfaces;

import modelo.entidades.Almacen;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface AlmacenServicio extends GenericServicio<Almacen> {

    public Almacen crearAlmacen(int idCliente, String direccion);
}
