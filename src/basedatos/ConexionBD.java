package basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface ConexionBD {

    /**
     * Conecta a la base de datos.
     *
     * @return Conexion a la base de datos.
     */
    public Connection conectarBD();

    /**
     * Dada una consulata de regresa el resultado.
     *
     * @param consulta Consulta a ejecutar en la base de datos.
     * @return Resultado de la consulta.
     */
    public PreparedStatement getPreparedStatement(String consulta);
}
