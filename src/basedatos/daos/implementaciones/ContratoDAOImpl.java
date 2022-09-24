package basedatos.daos.implementaciones;

import basedatos.ConexionBD;
import basedatos.daos.interfaces.ContratoDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.Contrato;
import static modelo.utils.Constantes.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ContratoDAOImpl implements ContratoDAO {

    private ConexionBD conexion;

    public ContratoDAOImpl(ConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Convierte un ResultSet en Contrato.
     *
     * @param resultSet ResultSet a convertir.
     * @return Contrato.
     * @throws SQLException
     */
    public Contrato resultToContrato(ResultSet resultSet) throws SQLException {
        LocalDateTime fechaModificacion = resultSet.getTimestamp(T_CONTRATO_C_FECHA_MODIFICACION) != null
                ? resultSet.getTimestamp(T_CONTRATO_C_FECHA_MODIFICACION).toLocalDateTime() : null;

        Cliente cliente = new Cliente();
        cliente.setId(resultSet.getInt(T_CONTRATO_C_ID_CLIENTE));
        cliente.setNombre(resultSet.getString(T_CLIENTE_C_NOMBRE));
//        Contrato contrato = new Contrato(cliente, resultSet.getTimestamp(T_CONTRATO_C_INICIO_CONTRATO).toLocalDateTime(),
//                resultSet.getString(T_TIPO_CONTRATO_C_TIPO),
//                resultSet.getInt(T_CONTRATO_C_MESES_CONTRATO),
//                resultSet.getInt(T_CONTRATO_C_DIA_CORTE),
//                resultSet.getString(T_TIPO_PAGO_C_TIPO),
//                resultSet.getString(T_TIPO_ESTADO_PRODUCTO_C_TIPO),
//                resultSet.getString(T_TIPO_TONER_C_TIPO),
//                resultSet.getString(T_TIPO_ESTADO_CONTRATO_C_TIPO),
//                resultSet.getInt(T_CONTRATO_C_RENTA_MENSUAL),
//                resultSet.getInt(T_CONTRATO_C_BOLSA_BN),
//                resultSet.getInt(T_CONTRATO_C_BOLSA_COLOR),
//                resultSet.getInt(T_CONTRATO_C_CLICK_BN),
//                resultSet.getInt(T_CONTRATO_C_CLICK_COLOR),
//                resultSet.getInt(T_CONTRATO_C_ID),
//                resultSet.getTimestamp(T_CONTRATO_C_FECHA_CREACION).toLocalDateTime(),
//                fechaModificacion);
        System.out.println(String.format("ContratoDAOImpl IdEstadoContrato:%d", resultSet.getInt(T_TIPO_ESTADO_CONTRATO_C_ID)));
//        GET FACTURAS
        return new Contrato();
    }

    @Override
    public List<Contrato> getTodos() {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " JOIN %s ON %s.%s = %s.%s";
        consulta = String.format(consulta, DB_N_T_CONTRATO,
                DB_N_T_CLIENTE, DB_N_T_CONTRATO, T_CONTRATO_C_ID_CLIENTE, DB_N_T_CLIENTE, T_CLIENTE_C_ID,
                DB_N_T_TIPO_CONTRATO, DB_N_T_CONTRATO, T_CONTRATO_C_ID_TIPO_CONTRATO, DB_N_T_TIPO_CONTRATO, T_TIPO_CONTRATO_C_ID,
                DB_N_T_TIPO_PAGO, DB_N_T_CONTRATO, T_CONTRATO_C_ID_TIPO_PAGO, DB_N_T_TIPO_PAGO, T_TIPO_PAGO_C_ID,
                DB_N_T_TIPO_TONER, DB_N_T_CONTRATO, T_CONTRATO_C_ID_TIPO_TONER, DB_N_T_TIPO_TONER, T_TIPO_TONER_C_ID,
                DB_N_T_TIPO_ESTADO_PRODUCTO, DB_N_T_CONTRATO, T_CONTRATO_C_ID_TIPO_ESTADO_PRODUCTO, DB_N_T_TIPO_ESTADO_PRODUCTO, T_TIPO_ESTADO_PRODUCTO_C_ID,
                DB_N_T_TIPO_ESTADO_CONTRATO, DB_N_T_CONTRATO, T_CONTRATO_C_ID_TIPO_ESTADO_CONTRATO, DB_N_T_TIPO_ESTADO_CONTRATO, T_TIPO_ESTADO_CONTRATO_C_ID);
        PreparedStatement statement = conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }

        // Si hay conexion a la base de datos, se obtienen todos los Contratos.
        List<Contrato> clientes = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                clientes.add(resultToContrato(resultSet));
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.ContratoDAOImpl.getTodos()");
            System.err.println(ex);
        }

        return clientes;
    }

    @Override
    public Contrato editarPorId(Contrato contrato) {
        System.out.println("EDITAR CONTRATO CON ID: " + contrato.getId());
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarPorId(int id) {
        System.out.println("ELIMIAR CONTRATO CON ID: " + id);
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
