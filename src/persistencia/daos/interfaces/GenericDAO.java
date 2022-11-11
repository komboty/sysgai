package persistencia.daos.interfaces;

import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface GenericDAO<T> {

//    public T getPorId(int id) throws SQLException;
    /**
     * Obtiene todos los registros de T en la base de datos.
     *
     * @return Lista con todos los registros de T.
     */
    public List<T> getTodos();
    
    /**
     * Actualiza un registro en la base de datos por su id.
     *
     * @param objectInit Objeto a actulizar, debe contener Id.
     * @return Regresa el registro de la base de datos con los nuevos cambios.
     */
    public T actualizarPorId(T objectInit);

    /**
     * Elimina un registro en la base de datos por su id.
     *
     * @param id Id del registro a eliminar.
     * @return Regresa verdadero si se eliminio correctamente.
     */
    public boolean eliminarPorId(int id);
}
