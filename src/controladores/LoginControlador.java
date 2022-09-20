package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Main;
import modelo.clases.Usuario;
import static modelo.utils.Constantes.*;


/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class LoginControlador implements Initializable {

    @FXML
    private TextField textMail;
    @FXML
    private PasswordField textContrasenia;
    @FXML
    private Label labelError;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void onIdentificar() throws IOException {
        // Se verifica si el usuario se encuntra registrado.
        Usuario usuario = new Usuario(textMail.getText(), textContrasenia.getText());
        usuario = usuario.identificar();
        
        // Si no se encuentra el usuario se manda error.
        if (usuario == null) {
            labelError.setText(VISTA_ERROR_NO_USUARIO);
            return;
        }
        
        // Si se encuentra el usuario se muestra el menu.
        Parent root = FXMLLoader.load(getClass().getResource(VISTA_URL_MENU));
        Main.getStage().setScene(new Scene(root));
    }

    public void onBorrarError() {
        labelError.setText("");
    }

}
