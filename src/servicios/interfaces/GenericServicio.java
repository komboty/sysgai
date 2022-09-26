package servicios.interfaces;

import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface GenericServicio<T> {

    /**
     * Obtiene una lista de informacion segun el servicio y filtro.
     *
     * @param filtro Nombre del filtro.
     * @param valor Valor a filtrar.
     * @return Lista con todos los T.
     */
    public List<T> getTodos(String filtro, String valor);

    /**
     * Elimina un T del sistema por su id.
     *
     * @param id Id del T a eliminar.
     * @return Regresa verdadero si se eliminio correctamente.
     */
    public boolean eliminarPorId(int id);
}
