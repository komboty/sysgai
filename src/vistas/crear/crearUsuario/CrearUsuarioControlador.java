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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Map<Integer, String> idsArea = new HashMap<>();
        idsArea.put(1, "Arrendamiento");
        idsArea.put(2, "Abogados");
        idsArea.put(3, "Contadores");
        idsArea.put(4, "Técnicos");
        idsArea.put(5, "Mesa de servicio");
        idsArea.put(6, "Almacén");
        idsArea.put(7, "Distribución");
        idsArea.put(8, "Administración");

        for (Map.Entry<Integer, String> idArea : idsArea.entrySet()) {
            choiceArea.getItems().add(idArea.getValue());
        }
    }

    public void onRegistrar() {
        System.out.println(textNombre.getText());
        System.out.println(textMail.getText());
        System.out.println(textContrasenia.getText());
        System.out.println(textTelefono.getText());
        System.out.println(textDireccion.getText());
        System.out.println(choiceArea.getSelectionModel().getSelectedItem());
    }
}
