package basedatos.daos.implementaciones;

import basedatos.ConexionBD;
import basedatos.daos.interfaces.ContratoDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.Contrato;
import static modelo.utils.Constantes.*;
import modelo.utils.Utils;

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
        // FALTA FACTURAS Y PEDIDOS.
        Contrato contrato = new Contrato();
        contrato.setId(resultSet.getInt(T_CONTRATO_C_ID));
        contrato.setFechaCreacion(Utils.resultSetToLocalDateTime(resultSet, T_CONTRATO_C_FECHA_CREACION));
        contrato.setFechaModificacion(Utils.resultSetToLocalDateTime(resultSet, T_CONTRATO_C_FECHA_MODIFICACION));
        contrato.setInicioContrato(Utils.resultSetToLocalDateTime(resultSet, T_CONTRATO_C_INICIO_CONTRATO));
        contrato.setTipoContrato(resultSet.getString(T_TIPO_CONTRATO_C_TIPO));
        contrato.setMesesContrato(resultSet.getInt(T_CONTRATO_C_MESES_CONTRATO));
        contrato.setDiaCorte(resultSet.getInt(T_CONTRATO_C_DIA_CORTE));
        contrato.setFormaPago(resultSet.getString(T_TIPO_PAGO_C_TIPO));
        contrato.setTipoImpresora(resultSet.getString(T_TIPO_ESTADO_PRODUCTO_C_TIPO));
        contrato.setTipoToner(resultSet.getString(T_TIPO_TONER_C_TIPO));
        contrato.setEstado(resultSet.getString(T_TIPO_ESTADO_CONTRATO_C_TIPO));
        contrato.setRentaMensual(resultSet.getInt(T_CONTRATO_C_RENTA_MENSUAL));
        contrato.setBolsaBN(resultSet.getInt(T_CONTRATO_C_BOLSA_BN));
        contrato.setBolsaColor(resultSet.getInt(T_CONTRATO_C_BOLSA_COLOR));
        contrato.setClickBN(resultSet.getFloat(T_CONTRATO_C_CLICK_BN));
        contrato.setClickColor(resultSet.getFloat(T_CONTRATO_C_CLICK_COLOR));

        Cliente cliente = new Cliente();
        cliente.setToStringTodo(false);
        cliente.setId(resultSet.getInt(T_CLIENTE_C_ID));
        cliente.setNombre(resultSet.getString(T_CLIENTE_C_NOMBRE));
        contrato.setCliente(cliente);
        return contrato;
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
    public Contrato actualizarPorId(Contrato contrato) {
        return null;
    }

    @Override
    public boolean eliminarPorId(int id) {
        System.out.println("ELIMIAR CONTRATO CON ID: " + id);
        return false;
    }

}
