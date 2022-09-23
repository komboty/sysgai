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
}
