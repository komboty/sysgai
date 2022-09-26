package basedatos.utils;

import basedatos.dtos.TipoContratoDTO;
import basedatos.dtos.TipoEstadoContratoDTO;
import basedatos.dtos.TipoEstadoProductoDTO;
import basedatos.dtos.TipoEstadoTicketDTO;
import basedatos.dtos.TipoNivelClienteDTO;
import basedatos.dtos.TipoPagoDTO;
import basedatos.dtos.TipoPrioridadDTO;
import basedatos.dtos.TipoTicketDTO;
import basedatos.dtos.TipoTonerDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import modelo.entidades.Area;
import modelo.entidades.Cliente;
import modelo.entidades.Contrato;
import modelo.entidades.Usuario;
import static basedatos.utils.ConstantesBD.*;
import modelo.entidades.Pedido;
import modelo.entidades.Ticket;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UtilsBD {

    /**
     * Obtiene de forma un LocalDateTime de un ResultSet.
     *
     * @param resultSet ResultSet a obtener su LocalDateTime.
     * @param columna Columna que debe existir en ResultSet.
     * @return Fecha en LocalDateTime.
     * @throws SQLException
     */
    public static LocalDateTime resultSetToLocalDateTime(ResultSet resultSet, String columna) throws SQLException {
        return resultSet.getTimestamp(columna) != null
                ? resultSet.getTimestamp(columna).toLocalDateTime() : null;
    }

    /**
     * Convierte un ResultSet en Usuario.
     *
     * @param resultSet ResultSet a convertir.
     * @return Usuario.
     * @throws SQLException
     */
    public static Usuario resultSetToUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getInt(T_USUARIO_C_ID));
        usuario.setFechaCreacion(resultSetToLocalDateTime(resultSet, T_USUARIO_C_FECHA_CREACION));
        usuario.setFechaModificacion(resultSetToLocalDateTime(resultSet, T_USUARIO_C_FECHA_MODIFICACION));
        usuario.setNombre(resultSet.getString(T_USUARIO_C_NOMBRE));
        usuario.setTelefono(resultSet.getString(T_USUARIO_C_TELEFONO));
        usuario.setMail(resultSet.getString(T_USUARIO_C_MAIL));
        usuario.setDireccion(resultSet.getString(T_USUARIO_C_DIRECCION));
        usuario.setContrasenia(resultSet.getString(T_USUARIO_C_CONTRASENIA));
        return usuario;
    }

    /**
     * Convierte un ResultSet en Area.
     *
     * @param resultSet ResultSet a convertir.
     * @return Area.
     * @throws SQLException
     */
    public static Area resultSetToArea(ResultSet resultSet) throws SQLException {
        Area area = new Area();
        area.setId(resultSet.getInt(T_AREA_C_ID));
        area.setFechaCreacion(resultSetToLocalDateTime(resultSet, T_AREA_C_FECHA_CREACION));
        area.setFechaModificacion(resultSetToLocalDateTime(resultSet, T_AREA_C_FECHA_MODIFICACION));
        area.setNombre(resultSet.getString(T_AREA_C_NOMBRE));
        return area;
    }

    /**
     * Convierte un ResultSet en Contrato.
     *
     * @param resultSet ResultSet a convertir.
     * @return Contrato.
     * @throws SQLException
     */
    public static Contrato resultSetToContrato(ResultSet resultSet) throws SQLException {
        Contrato contrato = new Contrato();
        contrato.setId(resultSet.getInt(T_CONTRATO_C_ID));
        contrato.setFechaCreacion(resultSetToLocalDateTime(resultSet, T_CONTRATO_C_FECHA_CREACION));
        contrato.setFechaModificacion(resultSetToLocalDateTime(resultSet, T_CONTRATO_C_FECHA_MODIFICACION));
        contrato.setInicioContrato(resultSetToLocalDateTime(resultSet, T_CONTRATO_C_INICIO_CONTRATO));
        contrato.setMesesContrato(resultSet.getInt(T_CONTRATO_C_MESES_CONTRATO));
        contrato.setDiaCorte(resultSet.getInt(T_CONTRATO_C_DIA_CORTE));
        contrato.setRentaMensual(resultSet.getInt(T_CONTRATO_C_RENTA_MENSUAL));
        contrato.setBolsaBN(resultSet.getInt(T_CONTRATO_C_BOLSA_BN));
        contrato.setBolsaColor(resultSet.getInt(T_CONTRATO_C_BOLSA_COLOR));
        contrato.setClickBN(resultSet.getFloat(T_CONTRATO_C_CLICK_BN));
        contrato.setClickColor(resultSet.getFloat(T_CONTRATO_C_CLICK_COLOR));
        return contrato;
    }
    
    /**
     * Convierte un ResultSet en Cliente.
     *
     * @param resultSet ResultSet a convertir.
     * @return Cliente.
     * @throws SQLException
     */
    public static Cliente resultSetToCliente(ResultSet resultSet) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(resultSet.getInt(T_CLIENTE_C_ID));
        cliente.setFechaCreacion(resultSetToLocalDateTime(resultSet, T_CLIENTE_C_FECHA_CREACION));
        cliente.setFechaModificacion(resultSetToLocalDateTime(resultSet, T_CLIENTE_C_FECHA_MODIFICACION));
        cliente.setNombre(resultSet.getString(T_CLIENTE_C_NOMBRE));
        cliente.setTelefono(resultSet.getString(T_CLIENTE_C_TELEFONO));
        cliente.setMail(resultSet.getString(T_CLIENTE_C_MAIL));
        cliente.setDireccion(resultSet.getString(T_CLIENTE_C_DIRECCION));
        return cliente;
    }
    
    public static Pedido resultSetToPedido(ResultSet resultSet) throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setId(resultSet.getInt(T_PEDIDO_C_ID));
        pedido.setFechaCreacion(resultSetToLocalDateTime(resultSet, T_PEDIDO_C_FECHA_CREACION));
        pedido.setFechaModificacion(resultSetToLocalDateTime(resultSet, T_PEDIDO_C_FECHA_MODIFICACION));
        return pedido;
    }
    
    /**
     * Convierte un ResultSet en Ticket.
     *
     * @param resultSet ResultSet a convertir.
     * @return Ticket.
     * @throws SQLException
     */
    public static Ticket resultSetToTicket(ResultSet resultSet) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(resultSet.getInt(T_TICKET_C_ID));
        ticket.setFechaCreacion(resultSetToLocalDateTime(resultSet, T_TICKET_C_FECHA_CREACION));
        ticket.setFechaModificacion(resultSetToLocalDateTime(resultSet, T_TICKET_C_FECHA_MODIFICACION));
        ticket.setDescripcion(resultSet.getString(T_TICKET_C_DESCRIPCION));
        return ticket;
    }
    
    /**
     * Convierte un ResultSet en TipoContratoDTO.
     *
     * @param resultSet ResultSet a convertir.
     * @return TipoContratoDTO.
     * @throws SQLException
     */
    public static TipoContratoDTO resultSetToTipoContratoDTO(ResultSet resultSet) throws SQLException {
        TipoContratoDTO tipoContratoDTO = new TipoContratoDTO();
        tipoContratoDTO.setId(resultSet.getInt(T_TIPO_CONTRATO_C_ID));
        tipoContratoDTO.setTipo(resultSet.getString(T_TIPO_CONTRATO_C_TIPO));
        return tipoContratoDTO;
    }
    
    /**
     * Convierte un ResultSet en TipoPagoDTO.
     *
     * @param resultSet ResultSet a convertir.
     * @return TipoPagoDTO.
     * @throws SQLException
     */
    public static TipoPagoDTO resultSetToTipoPagoDTO(ResultSet resultSet) throws SQLException {
        TipoPagoDTO tipoPagoDTO = new TipoPagoDTO();
        tipoPagoDTO.setId(resultSet.getInt(T_TIPO_PAGO_C_ID));
        tipoPagoDTO.setTipo(resultSet.getString(T_TIPO_PAGO_C_TIPO));
        return tipoPagoDTO;
    }
    
    /**
     * Convierte un ResultSet en TipoTonerDTO.
     *
     * @param resultSet ResultSet a convertir.
     * @return TipoTonerDTO.
     * @throws SQLException
     */
    public static TipoTonerDTO resultSetToTipoTonerDTO(ResultSet resultSet) throws SQLException {
        TipoTonerDTO tipoTonerDTO = new TipoTonerDTO();
        tipoTonerDTO.setId(resultSet.getInt(T_TIPO_TONER_C_ID));
        tipoTonerDTO.setTipo(resultSet.getString(T_TIPO_TONER_C_TIPO));
        return tipoTonerDTO;
    }
    
    /**
     * Convierte un ResultSet en TipoEstadoProductoDTO.
     *
     * @param resultSet ResultSet a convertir.
     * @return TipoEstadoProductoDTO.
     * @throws SQLException
     */
    public static TipoEstadoProductoDTO resultSetToTipoEstadoProductoDTO(ResultSet resultSet) throws SQLException {
        TipoEstadoProductoDTO tipoEstadoProductoDTO = new TipoEstadoProductoDTO();
        tipoEstadoProductoDTO.setId(resultSet.getInt(T_TIPO_ESTADO_PRODUCTO_C_ID));
        tipoEstadoProductoDTO.setTipo(resultSet.getString(T_TIPO_ESTADO_PRODUCTO_C_TIPO));
        return tipoEstadoProductoDTO;
    }
    
    /**
     * Convierte un ResultSet en TipoEstadoContratoDTO.
     *
     * @param resultSet ResultSet a convertir.
     * @return TipoEstadoContratoDTO.
     * @throws SQLException
     */
    public static TipoEstadoContratoDTO resultSetToTipoEstadoContratoDTO(ResultSet resultSet) throws SQLException {
        TipoEstadoContratoDTO tipoEstadoContratoDTO = new TipoEstadoContratoDTO();
        tipoEstadoContratoDTO.setId(resultSet.getInt(T_TIPO_ESTADO_CONTRATO_C_ID));
        tipoEstadoContratoDTO.setTipo(resultSet.getString(T_TIPO_ESTADO_CONTRATO_C_TIPO));
        return tipoEstadoContratoDTO;
    }
    
    /**
     * Convierte un ResultSet en TipoNivelClienteDTO.
     *
     * @param resultSet ResultSet a convertir.
     * @return TipoNivelClienteDTO.
     * @throws SQLException
     */
    public static TipoNivelClienteDTO resultSetToTipoNivelClienteDTO(ResultSet resultSet) throws SQLException {
        TipoNivelClienteDTO tipoNivelClienteDTO = new TipoNivelClienteDTO();
        tipoNivelClienteDTO.setId(resultSet.getInt(T_TIPO_NIVEL_CLIENTE_C_ID));
        tipoNivelClienteDTO.setTipo(resultSet.getString(T_TIPO_NIVEL_CLIENTE_C_TIPO));
        return tipoNivelClienteDTO;
    }

    /**
     * Convierte un ResultSet en TipoPrioridadDTO.
     *
     * @param resultSet ResultSet a convertir.
     * @return TipoPrioridadDTO.
     * @throws SQLException
     */
    public static TipoPrioridadDTO resultSetToTipoPrioridadDTO(ResultSet resultSet) throws SQLException {
        TipoPrioridadDTO tipoPrioridadDTO = new TipoPrioridadDTO();
        tipoPrioridadDTO.setId(resultSet.getInt(T_TIPO_PRIORIDAD_C_ID));
        tipoPrioridadDTO.setTipo(resultSet.getString(T_TIPO_PRIORIDAD_C_TIPO));
        return tipoPrioridadDTO;
    }
    
    /**
     * Convierte un ResultSet en TipoEstadoTicketDTO.
     *
     * @param resultSet ResultSet a convertir.
     * @return TipoEstadoTicketDTO.
     * @throws SQLException
     */
    public static TipoEstadoTicketDTO resultSetToTipoEstadoTicketDTO(ResultSet resultSet) throws SQLException {
        TipoEstadoTicketDTO tipoEstadoTicketDTO = new TipoEstadoTicketDTO();
        tipoEstadoTicketDTO.setId(resultSet.getInt(T_TIPO_ESTADO_TICKET_C_ID));
        tipoEstadoTicketDTO.setTipo(resultSet.getString(T_TIPO_ESTADO_TICKET_C_TIPO));
        return tipoEstadoTicketDTO;
    }
    
    /**
     * Convierte un ResultSet en TipoTicketDTO.
     *
     * @param resultSet ResultSet a convertir.
     * @return TipoTicketDTO.
     * @throws SQLException
     */
    public static TipoTicketDTO resultSetToTipoTicketDTO(ResultSet resultSet) throws SQLException {
        TipoTicketDTO tipoTicketDTO = new TipoTicketDTO();
        tipoTicketDTO.setId(resultSet.getInt(T_TIPO_TICKET_C_ID));
        tipoTicketDTO.setTipo(resultSet.getString(T_TIPO_TICKET_C_TIPO));
        return tipoTicketDTO;
    }

    
}
