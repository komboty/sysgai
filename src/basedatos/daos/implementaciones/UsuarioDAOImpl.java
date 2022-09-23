package basedatos.daos.implementaciones;

import basedatos.daos.interfaces.UsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Usuario;
import static modelo.utils.Constantes.*;
import basedatos.ConexionBD;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private ConexionBD conexion;

    public UsuarioDAOImpl(ConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Convierte un ResultSet en Usuario.
     *
     * @param resultSet ResultSet a convertir.
     * @return Usuario.
     * @throws SQLException
     */
    public Usuario resultToUsuario(ResultSet resultSet) throws SQLException {
        LocalDateTime fechaModificacion = resultSet.getTimestamp(T_USUARIO_C_FECHA_MODIFICACION) != null
                ? resultSet.getTimestamp(T_USUARIO_C_FECHA_MODIFICACION).toLocalDateTime() : null;

        return new Usuario(resultSet.getString(T_TIPO_USUARIO_C_TIPO),
                resultSet.getString(T_USUARIO_C_CONTRASENIA),
                resultSet.getInt(T_USUARIO_C_ID),
                resultSet.getTimestamp(T_USUARIO_C_FECHA_CREACION).toLocalDateTime(),
                fechaModificacion,
                resultSet.getString(T_USUARIO_C_NOMBRE),
                resultSet.getString(T_USUARIO_C_TELEFONO),
                resultSet.getString(T_USUARIO_C_MAIL),
                resultSet.getString(T_USUARIO_C_DIRECCION));
    }

    @Override
    public Usuario getPorMailYContrasenia(String mail, String contrasenia) {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " WHERE %s = ? AND %s = ?";
        consulta = String.format(consulta, DB_N_T_USUARIO,
                DB_N_T_TIPO_USUARIO, DB_N_T_USUARIO, T_USUARIO_C_ID_TIPO_USUARIO, DB_N_T_TIPO_USUARIO, T_TIPO_USUARIO_C_ID,
                T_USUARIO_C_MAIL, T_USUARIO_C_CONTRASENIA);
        PreparedStatement statement = conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }

        // Si hay conexion a la base de datos, se busca el Usuario.
        try {
            statement.setString(1, mail);
            statement.setString(2, contrasenia);
            ResultSet resultSet = statement.executeQuery();

            // Si se encontro el Usuario en la base de datos.
            if (resultSet.next()) {
                return resultToUsuario(resultSet);
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.UsuarioDAOImpl.getPorMailYContrasenia()");
            System.err.println(ex);
        }

        // Si no se encontro el Usuario en la base de datos.
        return null;
    }

    @Override
    public List<Usuario> getTodos() {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s";
        consulta = String.format(consulta, DB_N_T_USUARIO, DB_N_T_TIPO_USUARIO,
                DB_N_T_USUARIO, T_USUARIO_C_ID_TIPO_USUARIO,
                DB_N_T_TIPO_USUARIO, T_TIPO_USUARIO_C_ID);
        PreparedStatement statement = conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }

        // Si hay conexion a la base de datos, se obtienen todos los Usuarios.
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                usuarios.add(resultToUsuario(resultSet));
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.UsuarioDAOImpl.getTodos()");
            System.err.println(ex);
        }
        return usuarios;
    }

}
