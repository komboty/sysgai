package servicios.interfaces;

import java.util.List;
import servicios.dtos.FiltroDTO;
import servicios.dtos.ObjectToStringDTO;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface GenericServicio<T> {

    /**
     * Obtiene una lista de informacion segun el servicio y filtro.
     *
     * @param filtroDTO Filtro a realizar.
     * @return Lista con todos los T en ObjectToStringDTO.
     */
    public List<ObjectToStringDTO> getTodos(FiltroDTO filtroDTO);

    /**
     * Elimina un T del sistema por su id.
     *
     * @param id Id del T a eliminar.
     * @return Regresa verdadero si se eliminio correctamente.
     */
    public boolean eliminarPorId(int id);
}
