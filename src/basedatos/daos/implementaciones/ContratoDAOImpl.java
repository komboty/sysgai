package basedatos.daos.implementaciones;

import basedatos.ConexionBD;
import basedatos.daos.interfaces.ContratoDAO;
import basedatos.utils.UtilsBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Contrato;
import static basedatos.utils.ConstantesBD.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ContratoDAOImpl implements ContratoDAO<Contrato> {

    private ConexionBD conexion;

    public ContratoDAOImpl(ConexionBD conexion) {
        this.conexion = conexion;
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
        consulta = String.format(consulta, N_T_CONTRATO,
                N_T_CLIENTE, N_T_CONTRATO, T_CONTRATO_C_ID_CLIENTE, N_T_CLIENTE, T_CLIENTE_C_ID,
                N_T_TIPO_CONTRATO, N_T_CONTRATO, T_CONTRATO_C_ID_TIPO_CONTRATO, N_T_TIPO_CONTRATO, T_TIPO_CONTRATO_C_ID,
                N_T_TIPO_PAGO, N_T_CONTRATO, T_CONTRATO_C_ID_TIPO_PAGO, N_T_TIPO_PAGO, T_TIPO_PAGO_C_ID,
                N_T_TIPO_TONER, N_T_CONTRATO, T_CONTRATO_C_ID_TIPO_TONER, N_T_TIPO_TONER, T_TIPO_TONER_C_ID,
                N_T_TIPO_ESTADO_PRODUCTO, N_T_CONTRATO, T_CONTRATO_C_ID_TIPO_ESTADO_PRODUCTO, N_T_TIPO_ESTADO_PRODUCTO, T_TIPO_ESTADO_PRODUCTO_C_ID,
                N_T_TIPO_ESTADO_CONTRATO, N_T_CONTRATO, T_CONTRATO_C_ID_TIPO_ESTADO_CONTRATO, N_T_TIPO_ESTADO_CONTRATO, T_TIPO_ESTADO_CONTRATO_C_ID);
        PreparedStatement statement = (PreparedStatement) conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }

        // Si hay conexion a la base de datos, se obtienen todos los Contratos.
        List<Contrato> contratos = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Contrato contrato = UtilsBD.resultSetToContrato(resultSet);
                contrato.setCliente(UtilsBD.resultSetToCliente(resultSet));
                contrato.setTipoContrato(UtilsBD.resultSetToTipoContratoDTO(resultSet).getTipo());
                contrato.setFormaPago(UtilsBD.resultSetToTipoPagoDTO(resultSet).getTipo());
                contrato.setTipoToner(UtilsBD.resultSetToTipoTonerDTO(resultSet).getTipo());
                contrato.setTipoImpresora(UtilsBD.resultSetToTipoEstadoProductoDTO(resultSet).getTipo());
                contrato.setEstado(UtilsBD.resultSetToTipoEstadoContratoDTO(resultSet).getTipo());
                contratos.add(contrato);
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.ContratoDAOImpl.getTodos()");
            System.err.println(ex);
        }

        return contratos;
    }

    @Override
    public Contrato actualizarPorId(Contrato contrato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
