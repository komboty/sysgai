package modelo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.Contrato;
import modelo.entidades.Ticket;
import modelo.entidades.Usuario;
import static modelo.utils.ConstantesModelo.*;
import servicios.dtos.ClienteDTO;
import servicios.dtos.ContratoDTO;
import servicios.dtos.TicketDTO;
import static vistas.utils.ConstantesVista.*;
import servicios.dtos.UsuarioDTO;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UtilsModelo {

    /**
     * Obtiene de forma segura los elementos de una lista.
     *
     * @param <T> Clase de la lista.
     * @param lista Lista de la que se quiere saber su tamanio.
     * @return Numero de elementos de la lista.
     */
    public static <T> int getSize(List<T> lista) {
        return lista != null ? lista.size() : 0;
    }

    /**
     * Regresa la fecha con formato especifico.
     *
     * @param localDateTime Fecha a poner formato.
     * @return Fecha con formato.
     */
    public static String localDateTimeToString(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(FORMATO_VISTA_FECHA);
        return localDateTime.format(formato);
    }

    public static UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setFechaCreacion(localDateTimeToString(usuario.getFechaCreacion()));
        usuarioDTO.setFechaModificacion(localDateTimeToString(usuario.getFechaModificacion()));
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setTelefono(usuario.getTelefono());
        usuarioDTO.setMail(usuario.getMail());
        usuarioDTO.setNombreArea(usuario.getArea().getNombre());
        usuarioDTO.setDireccion(usuario.getDireccion().replaceAll(DELIMITADOR_DIRECCCION, "\n"));
        return usuarioDTO;
    }

    public static TicketDTO ticketToTicketDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticket.getId());
        ticketDTO.setFechaCreacion(localDateTimeToString(ticket.getFechaCreacion()));
        ticketDTO.setFechaModificacion(localDateTimeToString(ticket.getFechaModificacion()));
        ticketDTO.setPrioridad(ticket.getPrioridad());
        ticketDTO.setEstado(ticket.getEstado());
        ticketDTO.setTipo(ticket.getTipo());
        ticketDTO.setNombreAreaAsignada(ticket.getAreaAsignada().getNombre());
        ticketDTO.setMailUsuarioAsignado(ticket.getUsuarioAsignado() != null ? ticket.getUsuarioAsignado().getMail() : null);
        ticketDTO.setIdPedido(ticket.getPedido() != null ? ticket.getPedido().getId() : null);
        ticketDTO.setDescripcion(ticket.getDescripcion());
        return ticketDTO;
    }

    public static ContratoDTO contratoToContratoDTO(Contrato contrato) {
        ContratoDTO contratoDTO = new ContratoDTO();
        contratoDTO.setId(contrato.getId());
        contratoDTO.setFechaCreacion(localDateTimeToString(contrato.getFechaCreacion()));
        contratoDTO.setFechaModificacion(localDateTimeToString(contrato.getFechaModificacion()));
        contratoDTO.setNombreCliente(contrato.getCliente().getNombre());
        contratoDTO.setInicioContrato(localDateTimeToString(contrato.getInicioContrato()));
        contratoDTO.setTipoContrato(contrato.getTipoContrato());
        contratoDTO.setEstado(contrato.getEstado());
        contratoDTO.setMesesContrato(contrato.getMesesContrato());
        contratoDTO.setDiaCorte(contrato.getDiaCorte());
        contratoDTO.setFormaPago(contrato.getFormaPago());
        contratoDTO.setTipoImpresora(contrato.getTipoImpresora());
        contratoDTO.setTipoToner(contrato.getTipoToner());
        contratoDTO.setRentaMensual(contrato.getRentaMensual());
        contratoDTO.setBolsaBN(contrato.getBolsaBN());
        contratoDTO.setBolsaColor(contrato.getBolsaColor());
        contratoDTO.setClickBN(contrato.getClickBN());
        contratoDTO.setClickColor(contrato.getClickColor());
        return contratoDTO;
    }

    public static ClienteDTO clienteToClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setFechaCreacion(localDateTimeToString(cliente.getFechaCreacion()));
        clienteDTO.setFechaModificacion(localDateTimeToString(cliente.getFechaModificacion()));
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setTelefono(cliente.getTelefono());
        clienteDTO.setMail(cliente.getMail());
        clienteDTO.setNivel(cliente.getNivel());
        clienteDTO.setDireccion(cliente.getDireccion().replaceAll(DELIMITADOR_DIRECCCION, "\n"));
        return clienteDTO;
    }

}
