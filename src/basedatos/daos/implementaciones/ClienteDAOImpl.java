package basedatos.daos.implementaciones;

import basedatos.ConexionBD;
import basedatos.daos.interfaces.ClienteDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.clases.Almacen;
import modelo.clases.Cliente;
import static modelo.utils.Constantes.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ClienteDAOImpl implements ClienteDAO {

    private static final ConexionBD conexion = ConexionBD.getInstancia();

    public ClienteDAOImpl() {
    }

    /**
     * Convierte un ResultSet en Cliente.
     *
     * @param resultSet ResultSet a convertir.
     * @return Cliente.
     * @throws SQLException
     */
    public Cliente resultToCliente(ResultSet resultSet) throws SQLException {
        LocalDateTime fechaModificacion = resultSet.getTimestamp(T_CLIENTE_C_FECHA_MODIFICACION) != null
                ? resultSet.getTimestamp(T_CLIENTE_C_FECHA_MODIFICACION).toLocalDateTime() : null;
// GET ALMACENES
        return new Cliente(new Almacen(), resultSet.getString(T_TIPO_NIVEL_CLIENTE_C_TIPO),
                resultSet.getInt(T_CLIENTE_C_ID),
                resultSet.getTimestamp(T_CLIENTE_C_FECHA_CREACION).toLocalDateTime(),
                fechaModificacion,
                resultSet.getString(T_CLIENTE_C_NOMBRE),
                resultSet.getString(T_CLIENTE_C_TELEFONO),
                resultSet.getString(T_CLIENTE_C_MAIL),
                resultSet.getString(T_CLIENTE_C_DIRECCION));
    }

    public Cliente getPorId(int id) {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " WHERE %s = ?";
        consulta = String.format(consulta, DB_N_T_CLIENTE,
                DB_N_T_TIPO_NIVEL_CLIENTE, DB_N_T_CLIENTE, T_CLIENTE_C_ID_TIPO_NIVEL_CLIENTE, DB_N_T_TIPO_NIVEL_CLIENTE, T_TIPO_NIVEL_CLIENTE_C_ID,
                DB_N_T_CLIENTE);
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

}
