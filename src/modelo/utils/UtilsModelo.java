package modelo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.Contrato;
import modelo.entidades.Ticket;
import modelo.entidades.Usuario;
import static modelo.utils.ConstantesModelo.*;
import static vistas.utils.ConstantesVista.*;
import servicios.dtos.ObjectToStringDTO;

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

    //    public static UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
//        UsuarioDTO usuarioDTO = new UsuarioDTO();
//        usuarioDTO.setId(usuario.getId());
//        usuarioDTO.setFechaCreacion(localDateTimeToString(usuario.getFechaCreacion()));
//        usuarioDTO.setFechaModificacion(localDateTimeToString(usuario.getFechaModificacion()));
//        usuarioDTO.setNombre(usuario.getNombre());
//        usuarioDTO.setTelefono(usuario.getTelefono());
//        usuarioDTO.setMail(usuario.getMail());
//        usuarioDTO.setDireccion(usuario.getDireccion());
//        usuarioDTO.setNombreArea(usuario.getArea().getNombre());
//        return usuarioDTO;
//    }
    
    public static ObjectToStringDTO usuarioToObjectToStringDTO(Usuario usuario) {
        ObjectToStringDTO objectToStringDTO = new ObjectToStringDTO();
        objectToStringDTO.setId(usuario.getId());
        objectToStringDTO.setDatos(String.format(FORMATO_USUARIO_TO_STRING,
                usuario.getId(),
                localDateTimeToString(usuario.getFechaCreacion()),
                localDateTimeToString(usuario.getFechaModificacion()),
                usuario.getNombre(),
                usuario.getTelefono(),
                usuario.getMail(),
                usuario.getArea().getNombre(),
                usuario.getDireccion().replaceAll(DELIMITADOR_DIRECCCION, "\n")
        ));
        return objectToStringDTO;
    }

    public static ObjectToStringDTO contratoToObjectToStringDTO(Contrato contrato) {
        ObjectToStringDTO objectToStringDTO = new ObjectToStringDTO();
        objectToStringDTO.setId(contrato.getId());
        objectToStringDTO.setEstado(contrato.getEstado());
        objectToStringDTO.setDatos(String.format(FORMATO_CONTRATO_TO_STRING,
                contrato.getId(),
                localDateTimeToString(contrato.getFechaCreacion()),
                localDateTimeToString(contrato.getFechaModificacion()),
                contrato.getCliente().getNombre(),
                localDateTimeToString(contrato.getInicioContrato()),
                contrato.getTipoContrato(),
                contrato.getEstado(),
                contrato.getMesesContrato(),
                contrato.getDiaCorte(),
                contrato.getFormaPago(),
                contrato.getTipoImpresora(),
                contrato.getTipoToner(),
                contrato.getRentaMensual(),
                contrato.getBolsaBN(),
                contrato.getBolsaColor(),
                contrato.getClickBN(),
                contrato.getClickColor()
        ));
        return objectToStringDTO;
    }
    
    public static ObjectToStringDTO clienteToObjectToStringDTO(Cliente cliente) {
        ObjectToStringDTO objectToStringDTO = new ObjectToStringDTO();
        objectToStringDTO.setId(cliente.getId());
        objectToStringDTO.setDatos(String.format(FORMATO_CLIENTE_TO_STRING,
                cliente.getId(),
                localDateTimeToString(cliente.getFechaCreacion()),
                localDateTimeToString(cliente.getFechaModificacion()),
                cliente.getNombre(),
                cliente.getTelefono(),
                cliente.getMail(),
                cliente.getNivel(),
                cliente.getDireccion().replaceAll(DELIMITADOR_DIRECCCION, "\n")
        ));
        return objectToStringDTO;
    }

    public static ObjectToStringDTO ticketToObjectToStringDTO(Ticket ticket) {
        ObjectToStringDTO objectToStringDTO = new ObjectToStringDTO();
        objectToStringDTO.setId(ticket.getId());
        objectToStringDTO.setDatos(String.format(FORMATO_TICKET_TO_STRING,
                ticket.getId(),
                localDateTimeToString(ticket.getFechaCreacion()),
                localDateTimeToString(ticket.getFechaModificacion()),
                ticket.getPrioridad(),
                ticket.getEstado(),
                ticket.getTipo(),
                ticket.getAreaAsignada().getNombre(),
                ticket.getUsuarioAsignado() != null ? ticket.getUsuarioAsignado().getMail() : null,
                ticket.getPedido() != null ? ticket.getPedido().getId() : null,
                ticket.getDescripcion()
        ));
        return objectToStringDTO;
    }
}
