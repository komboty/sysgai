package basedatos.daos.implementacion;

import basedatos.ConexionBD;
import basedatos.daos.interfaces.UsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import modelo.clases.Usuario;
import static modelo.utils.Constantes.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private ConexionBD conexion;

    public UsuarioDAOImpl() {
        conexion = ConexionBD.getInstancia();
    }

    /**
     * Convierte un ResultSet en Usuario.
     *
     * @param resultSet ResultSet a convertir.
     * @return Usuario.
     * @throws SQLException
     */
    private Usuario resultToUsuario(ResultSet resultSet) throws SQLException {
        LocalDateTime fechaCreacion = null;
        if (resultSet.getTimestamp(T_USUARIO_C_FECHA_MODIFICACION) != null) {
            fechaCreacion = resultSet.getTimestamp(T_USUARIO_C_FECHA_MODIFICACION).toLocalDateTime();
        }

        return new Usuario(resultSet.getString(T_TIPO_USUARIO_C_TIPO),
                resultSet.getString(T_USUARIO_C_CONTRASENIA),
                resultSet.getInt(T_USUARIO_C_ID),
                resultSet.getTimestamp(T_USUARIO_C_FECHA_CREACION).toLocalDateTime(),
                fechaCreacion,
                resultSet.getString(T_USUARIO_C_NOMBRE),
                resultSet.getString(T_USUARIO_C_TELEFONO),
                resultSet.getString(T_USUARIO_C_MAIL),
                resultSet.getString(T_USUARIO_C_DIRECCION));
    }

    @Override
    public Usuario getUsuario(String mail, String contrasenia) {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " WHERE %s = ? AND %s = ?";
        consulta = String.format(consulta, DB_N_T_USUARIO, DB_N_T_TIPO_USUARIO,
                DB_N_T_USUARIO, T_USUARIO_C_ID_TIPO_USUARIO,
                DB_N_T_TIPO_USUARIO, T_TIPO_USUARIO_C_ID,
                T_USUARIO_C_MAIL, T_USUARIO_C_CONTRASENIA);
        PreparedStatement statement = conexion.getPreparedStatement(consulta);
        
        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }
        
        // Si hay conexion a la base de datos, se busca el Usuario.
        Usuario usuario = null;
        try {
            statement.setString(1, mail);
            statement.setString(2, contrasenia);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                usuario = resultToUsuario(resultSet);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return usuario;
    }

}
