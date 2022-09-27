package vistas.utils;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import servicios.dtos.ClienteDTO;
import servicios.dtos.ContratoDTO;
import servicios.dtos.TicketDTO;
import servicios.dtos.UsuarioDTO;
import static vistas.utils.ConstantesVista.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UtilsVista {

    /**
     * Lanza alerta de Confirmacion. Botones Cancelar y Aceptar.
     * 
     * @param titulo Titulo de la Alerta.
     * @param mensaje Mensaje de la Alerta.
     * @return Verdadero si se oprimio el boton de Aceptar, de lo contrario falso.
     */
    public static boolean lanzaAlertaCancelYAceptar(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        Optional<ButtonType> result = alert.showAndWait();
        return (result.isPresent()) && (result.get() == ButtonType.OK);
    }
    
    /**
     * Lanza alerta de Error. Boton Aceptar.
     * 
     * @param titulo Titulo de la Alerta.
     * @param mensaje Mensaje de la Alerta.
     */
    public static void lanzaAlertaError(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    /**
     * Lanza alerta de Informacion. Boton Aceptar.
     * 
     * @param titulo Titulo de la Alerta.
     * @param mensaje Mensaje de la Alerta.
     */
    public static void lanzaAlertaInformacion(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
      public static String usuarioDTOToString(UsuarioDTO usuarioDTO) {
        return String.format(FORMATO_USUARIO_TO_STRING,
                usuarioDTO.getId(),
                usuarioDTO.getFechaCreacion(),
                usuarioDTO.getFechaModificacion(),
                usuarioDTO.getNombre(),
                usuarioDTO.getTelefono(),
                usuarioDTO.getMail(),
                usuarioDTO.getNombreArea(),
                usuarioDTO.getDireccion()
        );
    }

    public static String contratoDTOToString(ContratoDTO contratoDTO) {
        return String.format(FORMATO_CONTRATO_TO_STRING,
                contratoDTO.getId(),
                contratoDTO.getFechaCreacion(),
                contratoDTO.getFechaModificacion(),
                contratoDTO.getNombreCliente(),
                contratoDTO.getInicioContrato(),
                contratoDTO.getTipoContrato(),
                contratoDTO.getEstado(),
                contratoDTO.getMesesContrato(),
                contratoDTO.getDiaCorte(),
                contratoDTO.getFormaPago(),
                contratoDTO.getTipoImpresora(),
                contratoDTO.getTipoToner(),
                contratoDTO.getRentaMensual(),
                contratoDTO.getBolsaBN(),
                contratoDTO.getBolsaColor(),
                contratoDTO.getClickBN(),
                contratoDTO.getClickColor()
        );
    }

    public static String clienteDTOToString(ClienteDTO clienteDTO) {
        return String.format(FORMATO_CLIENTE_TO_STRING,
                clienteDTO.getId(),
                clienteDTO.getFechaCreacion(),
                clienteDTO.getFechaModificacion(),
                clienteDTO.getNombre(),
                clienteDTO.getTelefono(),
                clienteDTO.getMail(),
                clienteDTO.getNivel(),
                clienteDTO.getDireccion()
        );
    }

    public static String ticketDTOToString(TicketDTO ticketDTO) {
        return String.format(FORMATO_TICKET_TO_STRING,
                ticketDTO.getId(),
                ticketDTO.getFechaCreacion(),
                ticketDTO.getFechaModificacion(),
                ticketDTO.getPrioridad(),
                ticketDTO.getEstado(),
                ticketDTO.getTipo(),
                ticketDTO.getNombreAreaAsignada(),
                ticketDTO.getMailUsuarioAsignado(),
                ticketDTO.getIdPedido(),
                ticketDTO.getDescripcion()
        );
    }
}
