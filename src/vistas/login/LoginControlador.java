package vistas.login;

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
import main.Dependencias;
import main.Main;
import modelo.entidades.Area;
import modelo.entidades.Usuario;
import static modelo.utils.Constantes.*;
import servicios.interfaces.UsuarioServicio;
import vistas.principal.PrincipalVistaControlador;

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

    /**
     * Verrfica si un usuario esta registrado en el sistame.
     *
     * @throws IOException
     */
    public void onIniciarSesion() throws IOException {
//        // Se verifica si el usuario se encuntra registrado.
//        UsuarioServicio usuarioServicio = Dependencias.getUsuarioServicio();
//        Usuario usuario = usuarioServicio.identificar(textMail.getText(), textContrasenia.getText());
//        
//        // Si no se encuentra el usuario se manda error.
//        if (usuario == null) {
//            labelError.setText(VISTA_ERROR_NO_USUARIO);
//            return;
//        }

        // Si se encuentra el usuario se muestra el menu.
        Usuario usuario = new Usuario();
        Area area = new Area();
        area.setNombre(AREA_ADMINISTRACION);
//        area.setNombre(AREA_ARRENDAMIENTO);
//        area.setNombre(AREA_ABOGADOS);
//        area.setNombre(AREA_CONTADORES);
//        area.setNombre(AREA_TECNICOS);
//        area.setNombre(AREA_MESA_DE_SERVICIO);
//        area.setNombre(AREA_DISTRIBUCION);
//        area.setNombre(AREA_ALMACEN);
        usuario.setArea(area);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(VISTA_URL_PRINCIPAL));
        fxmlLoader.setControllerFactory(controllerClass -> new PrincipalVistaControlador(usuario));
        Parent root = fxmlLoader.load();
        Main.getStage().setScene(new Scene(root));
    }

    /**
     * Borra el mensaje de error que se muestra al usuario.
     */
    public void onBorrarError() {
        labelError.setText("");
    }

}
