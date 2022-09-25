package servicios.interfaces;

import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface GenericServicio<T> {

    /**
     * Obtiene todos los T del sistema.
     *
     * @return Lista con todos los T.
     */
    public List<T> getTodos();

    /**
     * Elimina un T del sistema por su id.
     *
     * @param id Id del T a eliminar.
     * @return Regresa verdadero si se eliminio correctamente.
     */
    public boolean eliminarPorId(int id);
}
