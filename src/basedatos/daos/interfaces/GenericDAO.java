package basedatos.daos.interfaces;

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
     * Edita un registro en la base de datos por su id.
     *
     * @param objectInit Objeto a editar.
     * @return Regresa el registro con los nuevos cambios.
     */
    public T editarPorId(T id);

    /**
     * Elimina un registro en la base de datos por su id.
     *
     * @param id Id del registro a eliminar.
     * @return Regresa verdadero si se eliminio correctamente.
     */
    public boolean eliminarPorId(int id);
}
