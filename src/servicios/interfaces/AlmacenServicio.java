package servicios.interfaces;

import servicios.dtos.AlmacenDTO;


/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface AlmacenServicio extends GenericServicio<AlmacenDTO> {

    public AlmacenDTO crearAlmacen(int idCliente, String direccion);
}
