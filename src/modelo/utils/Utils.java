package modelo.utils;

import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Utils {

    /**
     * Obtiene de forma segura los elementos de una lista.
     * @param <T> Clase de la lista.
     * @param lista Lista de la que se quiere saber su tamanio. 
     * @return Numero de elementos de la lista.
     */
    public static <T> int getSize(List<T> lista) {
        return lista != null ? lista.size() : 0;
    }
}
