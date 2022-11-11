package persistencia.daos.implementaciones;

import persistencia.ConexionBD;
import persistencia.daos.interfaces.TicketDAO;
import static persistencia.utils.ConstantesBD.*;
import persistencia.utils.UtilsBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Ticket;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class TicketDAOImpl implements TicketDAO {

    private ConexionBD conexion;

    public TicketDAOImpl(ConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Ticket> getAsignados(int idUsuario) {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " LEFT JOIN %s ON %s.%s = %s.%s"
                + " LEFT JOIN %s ON %s.%s = %s.%s"
                + " WHERE %s.%s = ?";
        consulta = String.format(consulta, N_T_TICKET,
                N_T_TIPO_PRIORIDAD, N_T_TICKET, T_TICKET_C_ID_TIPO_PRIORIDAD, N_T_TIPO_PRIORIDAD, T_TIPO_PRIORIDAD_C_ID,
                N_T_TIPO_ESTADO_TICKET, N_T_TICKET, T_TICKET_C_ID_TIPO_ESTADO_TICKET, N_T_TIPO_ESTADO_TICKET, T_TIPO_ESTADO_TICKET_C_ID,
                N_T_TIPO_TICKET, N_T_TICKET, T_TICKET_C_ID_TIPO_TICKET, N_T_TIPO_TICKET, T_TIPO_TICKET_C_ID,
                N_T_AREA, N_T_TICKET, T_TICKET_C_ID_AREA, N_T_AREA, T_AREA_C_ID,
                N_T_USUARIO, N_T_TICKET, T_TICKET_C_ID_USUARIO, N_T_USUARIO, T_USUARIO_C_ID,
                N_T_PEDIDO, N_T_TICKET, T_TICKET_C_ID_PEDIDO, N_T_PEDIDO, T_PEDIDO_C_ID,
                N_T_TICKET, T_TICKET_C_ID_USUARIO);
        PreparedStatement statement = conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }

        // Si hay conexion a la base de datos, se obtienen todos los Tickets.
        List<Ticket> tickets = new ArrayList<>();
        try {
            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = UtilsBD.resultSetToTicket(resultSet);
                ticket.setPrioridad(UtilsBD.resultSetToTipoPrioridadDTO(resultSet).getTipo());
                ticket.setEstado(UtilsBD.resultSetToTipoEstadoTicketDTO(resultSet).getTipo());
                ticket.setTipo(UtilsBD.resultSetToTipoTicketDTO(resultSet).getTipo());
                ticket.setAreaAsignada(UtilsBD.resultSetToArea(resultSet));
                ticket.setUsuarioAsignado(UtilsBD.resultSetToUsuario(resultSet));
                ticket.setPedido(UtilsBD.resultSetToPedido(resultSet));
                tickets.add(ticket);
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.TicketDAOImpl.getAsignados()");
            System.err.println(ex);
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTodos() {
        String consulta = "SELECT * FROM %s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " JOIN %s ON %s.%s = %s.%s"
                + " LEFT JOIN %s ON %s.%s = %s.%s"
                + " LEFT JOIN %s ON %s.%s = %s.%s";
        consulta = String.format(consulta, N_T_TICKET,
                N_T_TIPO_PRIORIDAD, N_T_TICKET, T_TICKET_C_ID_TIPO_PRIORIDAD, N_T_TIPO_PRIORIDAD, T_TIPO_PRIORIDAD_C_ID,
                N_T_TIPO_ESTADO_TICKET, N_T_TICKET, T_TICKET_C_ID_TIPO_ESTADO_TICKET, N_T_TIPO_ESTADO_TICKET, T_TIPO_ESTADO_TICKET_C_ID,
                N_T_TIPO_TICKET, N_T_TICKET, T_TICKET_C_ID_TIPO_TICKET, N_T_TIPO_TICKET, T_TIPO_TICKET_C_ID,
                N_T_AREA, N_T_TICKET, T_TICKET_C_ID_AREA, N_T_AREA, T_AREA_C_ID,
                N_T_USUARIO, N_T_TICKET, T_TICKET_C_ID_USUARIO, N_T_USUARIO, T_USUARIO_C_ID,
                N_T_PEDIDO, N_T_TICKET, T_TICKET_C_ID_PEDIDO, N_T_PEDIDO, T_PEDIDO_C_ID);
        PreparedStatement statement = conexion.getPreparedStatement(consulta);

        // Si no hay conexion a la base de datos.
        if (statement == null) {
            return null;
        }

        // Si hay conexion a la base de datos, se obtienen todos los Tickets.
        List<Ticket> tickets = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = UtilsBD.resultSetToTicket(resultSet);
                ticket.setPrioridad(UtilsBD.resultSetToTipoPrioridadDTO(resultSet).getTipo());
                ticket.setEstado(UtilsBD.resultSetToTipoEstadoTicketDTO(resultSet).getTipo());
                ticket.setTipo(UtilsBD.resultSetToTipoTicketDTO(resultSet).getTipo());
                ticket.setAreaAsignada(UtilsBD.resultSetToArea(resultSet));
                ticket.setUsuarioAsignado(UtilsBD.resultSetToUsuario(resultSet));
                ticket.setPedido(UtilsBD.resultSetToPedido(resultSet));
                tickets.add(ticket);
            }
        } catch (SQLException ex) {
            System.err.println("basedatos.daos.implementaciones.TicketDAOImpl.getTodos()");
            System.err.println(ex);
        }
        return tickets;
    }

    @Override
    public Ticket actualizarPorId(Ticket objectInit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
