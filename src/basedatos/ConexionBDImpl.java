package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import static basedatos.utils.ConstantesBD.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ConexionBDImpl implements ConexionBD {

    private final String url;
    private final String usuario;
    private final String contrasenia;
    private final Connection conexion;

    public ConexionBDImpl() {
        url = URL;
        usuario = USUARIO;
        contrasenia = CONTRASENIA;
        conexion = conectarBD();
    }

    @Override
    public Connection conectarBD() {
        Connection conexionDB = null;
        try {
            conexionDB = DriverManager.getConnection(url, usuario, contrasenia);
        } catch (SQLException ex) {
            System.err.println("basedatos.ConexionBD.conectarBD()");
            System.err.println(ex);
        }
        return conexionDB;
    }

    @Override
    public PreparedStatement getPreparedStatement(String consulta) {
        try {
            if (!conexion.isClosed()) {
                return conexion.prepareStatement(consulta);
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.ConexionBD.getPreparedStatement()");
            System.err.println(ex);
        }

        return null;
    }
}
