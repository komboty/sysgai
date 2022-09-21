package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import static modelo.utils.Constantes.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ConexionBD {

    private String host;
    private String puerto;
    private String basedatos;
    private String url;
    private String usuario;
    private String contrasenia;
    private Connection conexion;

    private static ConexionBD instancia;

    public ConexionBD() {
        host = DB_HOST;
        puerto = DB_PUERTO;
        basedatos = DB_NOMBRE;
        url = DB_URL;
        usuario = DB_USUARIO;
        contrasenia = DB_CONTRASENIA;
        conexion = conectarBD();
    }

    /**
     * Patron Singleton.
     *
     * @return Instancia de la clase.
     */
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    /**
     * Conecta a la base de datos.
     *
     * @return Conexion a la base de datos.
     */
    private Connection conectarBD() {
        try {
            conexion = DriverManager.getConnection(url, usuario, contrasenia);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return conexion;
    }

    public PreparedStatement getPreparedStatement(String consulta) {
        try {
            if (!conexion.isClosed()) {
                return conexion.prepareStatement(consulta);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;
    }
}
