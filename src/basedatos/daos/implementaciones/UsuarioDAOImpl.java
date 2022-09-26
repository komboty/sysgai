package basedatos.daos.implementaciones;

import basedatos.daos.interfaces.UsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Usuario;
import static basedatos.utils.ConstantesBD.*;
import basedatos.ConexionBD;
import basedatos.utils.UtilsBD;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UsuarioDAOImpl implements UsuarioDAO<Usuario> {

    private ConexionBD conexion;

    public UsuarioDAOImpl(ConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Usuario getPorMailYContrasenia(String mail, String contrasenia) {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " WHERE %s = ? AND %s = ?";
        consulta = String.format(consulta, N_T_USUARIO,
                N_T_AREA, N_T_USUARIO, T_USUARIO_C_ID_AREA, N_T_AREA, T_AREA_C_ID,
                T_USUARIO_C_MAIL, T_USUARIO_C_CONTRASENIA);
        PreparedStatement statement = (PreparedStatement) conexion.getPreparedStatement(consulta);

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
                Usuario usuario = UtilsBD.resultSetToUsuario(resultSet);
                usuario.setArea(UtilsBD.resultSetToArea(resultSet));
                return usuario;
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
        consulta = String.format(consulta, N_T_USUARIO,
                N_T_AREA, N_T_USUARIO, T_USUARIO_C_ID_AREA, N_T_AREA, T_AREA_C_ID);
        PreparedStatement statement = (PreparedStatement) conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }

        // Si hay conexion a la base de datos, se obtienen todos los Usuarios.
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = UtilsBD.resultSetToUsuario(resultSet);
                usuario.setArea(UtilsBD.resultSetToArea(resultSet));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.UsuarioDAOImpl.getTodos()");
            System.err.println(ex);
        }
        return usuarios;
    }

    @Override
    public Usuario actualizarPorId(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarPorId(int id) {
        String consulta = "DELETE FROM %s"
                + " WHERE %s = ?";
        consulta = String.format(consulta, N_T_USUARIO, T_USUARIO_C_ID);
        PreparedStatement statement = (PreparedStatement) conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return false;
        }

        // Si hay conexion a la base de datos, se elimina el Usuario.
        try {
            statement.setInt(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.UsuarioDAOImpl.eliminarPorId()");
            System.err.println(ex);
        }

        // Si ocurrio un error en la base de datos.
        return false;
    }

}
