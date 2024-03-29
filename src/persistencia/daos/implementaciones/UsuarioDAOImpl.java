package persistencia.daos.implementaciones;

import persistencia.daos.interfaces.UsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Usuario;
import static persistencia.utils.ConstantesBD.*;
import persistencia.ConexionBD;
import persistencia.utils.UtilsBD;
import static persistencia.utils.UtilsBD.resultSetToLocalDateTime;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UsuarioDAOImpl implements UsuarioDAO {

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
    public Usuario registrar(Usuario usuario) {
        String consulta = "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s) "
                + " VALUES (DEFAULT, ?, CURRENT_TIMESTAMP, NULL, ?, ?, ?, ?, ?)"
                + " RETURNING %s, %s";
        consulta = String.format(consulta, N_T_USUARIO,
                T_USUARIO_C_ID, T_USUARIO_C_ID_AREA, T_USUARIO_C_FECHA_CREACION,
                T_USUARIO_C_FECHA_MODIFICACION, T_USUARIO_C_NOMBRE, T_USUARIO_C_TELEFONO,
                T_USUARIO_C_MAIL, T_USUARIO_C_DIRECCION, T_USUARIO_C_CONTRASENIA,
                T_USUARIO_C_ID, T_USUARIO_C_FECHA_CREACION);
        PreparedStatement statement = conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }

        // Si hay conexion a la base de datos, se registra el Usuario.
        try {
            statement.setInt(1, usuario.getArea().getId());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getTelefono());
            statement.setString(4, usuario.getMail());
            statement.setString(5, usuario.getDireccion());
            statement.setString(6, usuario.getContrasenia());
            ResultSet resultSet = statement.executeQuery();
            
            // Si se registro el Usuario en la base de datos.
            if (resultSet.next()) {                
                usuario.setId(resultSet.getInt(T_USUARIO_C_ID));
                usuario.setFechaCreacion(resultSetToLocalDateTime(resultSet, T_USUARIO_C_FECHA_CREACION));
                return usuario;
            }           
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.UsuarioDAOImpl.registrar()");
            System.err.println(ex);
        }

        // Si no se registro el Usuario en la base de datos.
        return null;
    }

    @Override
    public List<Usuario> getTodos() {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s";
        consulta = String.format(consulta, N_T_USUARIO,
                N_T_AREA, N_T_USUARIO, T_USUARIO_C_ID_AREA, N_T_AREA, T_AREA_C_ID);
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
        PreparedStatement statement = conexion.getPreparedStatement(consulta);

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
