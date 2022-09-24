package basedatos.daos.implementaciones;

import basedatos.ConexionBD;
import basedatos.daos.interfaces.ClienteDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Almacen;
import modelo.entidades.Cliente;
import static modelo.utils.Constantes.*;
import modelo.utils.Utils;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ClienteDAOImpl implements ClienteDAO {

    private ConexionBD conexion;

    public ClienteDAOImpl(ConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Convierte un ResultSet en Cliente.
     *
     * @param resultSet ResultSet a convertir.
     * @return Cliente.
     * @throws SQLException
     */
    public Cliente resultToCliente(ResultSet resultSet) throws SQLException {
        // FALTA GET ALMACENES Y CONTRATOS
        Cliente cliente = new Cliente();
        cliente.setId(resultSet.getInt(T_CLIENTE_C_ID));
        cliente.setNivel(resultSet.getString(T_TIPO_NIVEL_CLIENTE_C_TIPO));
        cliente.setFechaCreacion(Utils.resultSetToLocalDateTime(resultSet, T_CLIENTE_C_FECHA_CREACION));
        cliente.setFechaModificacion(Utils.resultSetToLocalDateTime(resultSet, T_CLIENTE_C_FECHA_MODIFICACION));
        cliente.setNombre(resultSet.getString(T_CLIENTE_C_NOMBRE));
        cliente.setTelefono(resultSet.getString(T_CLIENTE_C_TELEFONO));
        cliente.setMail(resultSet.getString(T_CLIENTE_C_MAIL));
        cliente.setDireccion(resultSet.getString(T_CLIENTE_C_DIRECCION));
        return cliente;
    }

    public Cliente getPorId(int id) {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " WHERE %s = ?";
        consulta = String.format(consulta, DB_N_T_CLIENTE,
                DB_N_T_TIPO_NIVEL_CLIENTE, DB_N_T_CLIENTE, T_CLIENTE_C_ID_TIPO_NIVEL_CLIENTE, DB_N_T_TIPO_NIVEL_CLIENTE, T_TIPO_NIVEL_CLIENTE_C_ID,
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
                return resultToCliente(resultSet);
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.ClienteDAOImpl.getPorId()");
            System.err.println(ex);
        }

        return null;
    }

    @Override
    public List<Cliente> getTodos() {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s";
        consulta = String.format(consulta, DB_N_T_CLIENTE,
                DB_N_T_TIPO_NIVEL_CLIENTE, DB_N_T_CLIENTE, T_CLIENTE_C_ID_TIPO_NIVEL_CLIENTE, DB_N_T_TIPO_NIVEL_CLIENTE, T_TIPO_NIVEL_CLIENTE_C_ID);
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
                clientes.add(resultToCliente(resultSet));
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.ClienteDAOImpl.getTodos()");
            System.err.println(ex);
        }

        return clientes;
    }

    @Override
    public Cliente editarPorId(Cliente cliente) {        
        return new Cliente();
    }

    @Override
    public boolean eliminarPorId(int id) {
        String consulta = "DELETE FROM %s"
                + " WHERE %s = ?";
        consulta = String.format(consulta, DB_N_T_CLIENTE, T_CLIENTE_C_ID);
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
