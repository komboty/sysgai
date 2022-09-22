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
}
