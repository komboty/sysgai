package persistencia.daos.implementaciones;

import persistencia.ConexionBD;
import persistencia.daos.interfaces.ClienteDAO;
import persistencia.utils.UtilsBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import static persistencia.utils.ConstantesBD.*;
import static persistencia.utils.UtilsBD.resultSetToLocalDateTime;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ClienteDAOImpl implements ClienteDAO {

    private ConexionBD conexion;

    public ClienteDAOImpl(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public Cliente getPorId(int id) {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " WHERE %s = ?";
        consulta = String.format(consulta, N_T_CLIENTE,
                N_T_TIPO_NIVEL_CLIENTE, N_T_CLIENTE, T_CLIENTE_C_ID_TIPO_NIVEL_CLIENTE, N_T_TIPO_NIVEL_CLIENTE, T_TIPO_NIVEL_CLIENTE_C_ID,
                T_CLIENTE_C_ID);
        PreparedStatement statement = conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }

        try {
            // Si hay conexion a la base de datos, se obtienen el Cliente.
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Cliente cliente = UtilsBD.resultSetToCliente(resultSet);
                cliente.setNivel(UtilsBD.resultSetToTipoNivelClienteDTO(resultSet).getTipo());
                return cliente;
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.ClienteDAOImpl.getPorId()");
            System.err.println(ex);
        }

        return null;
    }
    
    @Override
    public Cliente registrar(Cliente cliente) {
        String consulta = "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s) VALUES "
                + " (DEFAULT, ?, CURRENT_TIMESTAMP, NULL, ?, ?, ?, ?)"
                + " RETURNING %s, %s";
        consulta = String.format(consulta, N_T_CLIENTE,
                T_CLIENTE_C_ID, T_CLIENTE_C_ID_TIPO_NIVEL_CLIENTE, T_CLIENTE_C_FECHA_CREACION,
                T_CLIENTE_C_FECHA_MODIFICACION, T_CLIENTE_C_NOMBRE, T_CLIENTE_C_TELEFONO,
                T_CLIENTE_C_MAIL, T_CLIENTE_C_DIRECCION,
                T_CLIENTE_C_ID, T_CLIENTE_C_FECHA_CREACION);
        PreparedStatement statement = conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }

        // Si hay conexion a la base de datos, se registra el Usuario.
        try {
            statement.setInt(1, Integer.parseInt(cliente.getNivel()));
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getTelefono());
            statement.setString(4, cliente.getMail());
            statement.setString(5, cliente.getDireccion());
            ResultSet resultSet = statement.executeQuery();
            
            // Si se registro el Cliente en la base de datos.
            if (resultSet.next()) {                
                cliente.setId(resultSet.getInt(T_CLIENTE_C_ID));
                cliente.setFechaCreacion(resultSetToLocalDateTime(resultSet, T_CLIENTE_C_FECHA_CREACION));
                return cliente;
            }           
        } catch (SQLException ex) {
            System.err.println("persistencia.daos.implementaciones.ClienteDAOImpl.registrar()");
            System.err.println(ex);
        }

        // Si no se registro el Cliente en la base de datos.
        return null;
    }

    @Override
    public List<Cliente> getTodos() {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s";
        consulta = String.format(consulta, N_T_CLIENTE,
                N_T_TIPO_NIVEL_CLIENTE, N_T_CLIENTE, T_CLIENTE_C_ID_TIPO_NIVEL_CLIENTE, N_T_TIPO_NIVEL_CLIENTE, T_TIPO_NIVEL_CLIENTE_C_ID);
        PreparedStatement statement = conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }

        // Si hay conexion a la base de datos, se obtienen todos los Clientes.
        List<Cliente> clientes = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = UtilsBD.resultSetToCliente(resultSet);
                cliente.setNivel(UtilsBD.resultSetToTipoNivelClienteDTO(resultSet).getTipo());
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.ClienteDAOImpl.getTodos()");
            System.err.println(ex);
        }

        return clientes;
    }

    @Override
    public Cliente actualizarPorId(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarPorId(int id) {
        String consulta = "DELETE FROM %s"
                + " WHERE %s = ?";
        consulta = String.format(consulta, N_T_CLIENTE, T_CLIENTE_C_ID);
        PreparedStatement statement = conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return false;
        }

        // Si hay conexion a la base de datos, se elimina el Cliente.
        try {
            statement.setInt(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.ClienteDAOImpl.eliminarPorId()");
            System.err.println(ex);
        }

        // Si ocurrio un error en la base de datos.
        return false;
    }

}
