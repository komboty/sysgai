package vistas.crear.crearUsuario;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Dependencias;
import servicios.dtos.UsuarioDTO;
import servicios.interfaces.UsuarioServicio;
import static vistas.utils.ConstantesVista.*;
import vistas.utils.UtilsVista;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class CrearUsuarioControlador implements Initializable {

    @FXML
    private TextField textNombre;
    @FXML
    private TextField textMail;
    @FXML
    private PasswordField textContrasenia;
    @FXML
    private TextField textTelefono;
    @FXML
    private TextField textDireccion;
    @FXML
    private ChoiceBox choiceArea;
    // Areas de trabajo.
    private Map<String, Integer> idsAreas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Se obtienen las areas de trabajo
        idsAreas = getAreas();
        // Se cargan las areas de trabajo a la vista
        for (Map.Entry<String, Integer> idArea : idsAreas.entrySet()) {
            choiceArea.getItems().add(idArea.getKey());
        }
    }

    /**
     * Registra un usuario en la base de datos.
     */
    public void onRegistrar() {
        UsuarioServicio usuarioServicio = Dependencias.getUsuarioServicio();
        String nombreArea;
        // Se obtiene el valor del ChoiceBox.
        try {
            nombreArea = choiceArea.getSelectionModel().getSelectedItem().toString();
        } catch (Exception ex) {
            System.err.println("vistas.crear.crearUsuario.CrearUsuarioControlador.onRegistrar()");
            System.err.println(ex);
            String mensajeError = String.format(NO_HAY_SELECCION_MENSAJE, "- Área");
            UtilsVista.lanzaAlertaError(NO_HAY_SELECCION_TITULO, mensajeError);
            return;
        }

        // Se registra el usuario en la base de datos.
        UsuarioDTO usuarioDTO = usuarioServicio.crearUsuario(idsAreas.get(nombreArea),
                textNombre.getText(), textTelefono.getText(), textMail.getText(),
                textDireccion.getText(), textContrasenia.getText());

        String msjAlert;
        // Si ocurrio un error al registra el usuario en la base de datos.
        if (usuarioDTO == null) {
            msjAlert = String.format(REGISTRAR_MENSAJE_ERROR, "el Usuario");
        } else {
            // Si se registro correctamente el usuario en la base de datos.
            msjAlert = String.format(REGISTRAR_MENSAJE, "El Usuario", usuarioDTO.getId());
        }

        UtilsVista.lanzaAlertaInformacion(ELIMINAR_REGISTRO_TITULO, msjAlert);
    }

    /**
     * Obtiene las areas de trabajo.
     */
    public Map<String, Integer> getAreas() {
        Map<String, Integer> idsAreas = new HashMap<>();
        idsAreas.put("Arrendamiento", 1);
        idsAreas.put("Abogados", 2);
        idsAreas.put("Contadores", 3);
        idsAreas.put("Técnicos", 4);
        idsAreas.put("Mesa de servicio", 5);
        idsAreas.put("Almacén", 6);
        idsAreas.put("Distribución", 7);
        idsAreas.put("Administración", 8);
        return idsAreas;
    }
}
