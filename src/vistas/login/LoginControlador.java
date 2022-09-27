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
import static modelo.utils.ConstantesModelo.*;
import static vistas.utils.ConstantesVista.*;
import servicios.dtos.UsuarioLogueadoDTO;
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
//        UsuarioLogueadoDTO usuarioLogueadoDTO = usuarioServicio.iniciarSesion(textMail.getText(), textContrasenia.getText());
//        
//        // Si no se encuentra el usuario se manda error.
//        if (usuarioLogueadoDTO == null) {
//            labelError.setText(ERROR_NO_USUARIO);
//            return;
//        }

        // Si se encuentra el usuario se muestra el menu.
        UsuarioLogueadoDTO usuarioLogueadoDTO = new UsuarioLogueadoDTO();
//        usuarioLogueadoDTO.setNombreArea(AREA_ADMINISTRACION);
//        usuarioLogueadoDTO.setNombreArea(AREA_ARRENDAMIENTO);
        usuarioLogueadoDTO.setNombreArea(AREA_ABOGADOS);
//        usuarioLogueadoDTO.setNombreArea(AREA_CONTADORES);
//        usuarioLogueadoDTO.setNombreArea(AREA_TECNICOS);
//        usuarioLogueadoDTO.setNombreArea(AREA_MESA_DE_SERVICIO);
//        usuarioLogueadoDTO.setNombreArea(AREA_DISTRIBUCION);
//        usuarioLogueadoDTO.setNombreArea(AREA_ALMACEN);
        usuarioLogueadoDTO.setIdUsuario(6);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(URL_PRINCIPAL));
        fxmlLoader.setControllerFactory(controllerClass -> new PrincipalVistaControlador(usuarioLogueadoDTO));
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
