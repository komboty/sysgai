package modelo.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static modelo.utils.Constantes.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Utils {

    /**
     * Obtiene de forma segura los elementos de una lista.
     *
     * @param <T> Clase de la lista.
     * @param lista Lista de la que se quiere saber su tamanio.
     * @return Numero de elementos de la lista.
     */
    public static <T> int getSize(List<T> lista) {
        return lista != null ? lista.size() : 0;
    }

    /**
     * Obtiene de forma un LocalDateTime de un ResultSet.
     *
     * @param resultSet ResultSet a obtener su LocalDateTime.
     * @param columna Columna que debe existir en ResultSet.
     * @return Fecha en LocalDateTime.
     * @throws SQLException
     */
    public static LocalDateTime resultSetToLocalDateTime(ResultSet resultSet, String columna) throws SQLException {
        return resultSet.getTimestamp(columna) != null
                ? resultSet.getTimestamp(columna).toLocalDateTime() : null;
    }

    /**
     * Regresa la fecha con formato especifico.
     *
     * @param localDateTime Fecha a poner formato.
     * @return Fecha con formato.
     */
    public static String localDateTimeToString(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(VISTA_FECHA_FORMATO);
        return localDateTime.format(formato);
    }
}
