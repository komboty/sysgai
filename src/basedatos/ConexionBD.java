package basedatos;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface ConexionBD<T, K> {

    /**
     * Conecta a la base de datos.
     *
     * @return Conexion a la base de datos.
     */
    public T conectarBD();

    /**
     * Dada una consulata de regresa un objeto para hacer una consulta
     * parametrizada.
     *
     * @param consulta Consulta a ejecutar en la base de datos.
     * @return Objeto para hacer una consulta parametrizada.
     */
    public K getPreparedStatement(String consulta);
}
