package vistas.utils;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

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
}
