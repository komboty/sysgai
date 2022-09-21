package pantallas.login;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
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
import pantallas.principal.PrincipalVistaControlador;

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
//        // Se verifica si el usuario se encuntra registrado.
//        Usuario usuario = new Usuario(textMail.getText(), textContrasenia.getText());
//        usuario = usuario.identificar();
//        
//        // Si no se encuentra el usuario se manda error.
//        if (usuario == null) {
//            labelError.setText(VISTA_ERROR_NO_USUARIO);
//            return;
//        }

        // Si se encuentra el usuario se muestra el menu.
        Usuario usuario = new Usuario(TIPO_USUARIO_ADMINISTRADOR, "", 1, LocalDateTime.MIN, LocalDateTime.MIN, "Admin", "", "", "");
//        Usuario usuario = new Usuario(TIPO_USUARIO_ARRENDADOR, "", 1, LocalDateTime.MIN, LocalDateTime.MIN, "Admin", "", "", "");
//        Usuario usuario = new Usuario(TIPO_USUARIO_ABOGADO, "", 1, LocalDateTime.MIN, LocalDateTime.MIN, "Admin", "", "", "");
//        Usuario usuario = new Usuario(TIPO_USUARIO_CONTADOR, "", 1, LocalDateTime.MIN, LocalDateTime.MIN, "Admin", "", "", "");
//        Usuario usuario = new Usuario(TIPO_USUARIO_TECNICO, "", 1, LocalDateTime.MIN, LocalDateTime.MIN, "Admin", "", "", "");
//        Usuario usuario = new Usuario(TIPO_USUARIO_MESA, "", 1, LocalDateTime.MIN, LocalDateTime.MIN, "Admin", "", "", "");
//        Usuario usuario = new Usuario(TIPO_USUARIO_CHOFER, "", 1, LocalDateTime.MIN, LocalDateTime.MIN, "Admin", "", "", "");
//        Usuario usuario = new Usuario(TIPO_USUARIO_ALMACENISTA, "", 1, LocalDateTime.MIN, LocalDateTime.MIN, "Admin", "", "", "");

//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource(VISTA_URL_PRINCIPAL));
//        Parent root = fxmlLoader.load();
//        PrincipalVistaControlador principalVistaControlador = fxmlLoader.getController();
//        principalVistaControlador.setUsuario(usuario);
//        Main.getStage().setScene(new Scene(root));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(VISTA_URL_PRINCIPAL));
        fxmlLoader.setControllerFactory(controllerClass -> new PrincipalVistaControlador(usuario));
        Parent root = fxmlLoader.load();
        Main.getStage().setScene(new Scene(root));
    }

    public void onBorrarError() {
        labelError.setText("");
    }

}
