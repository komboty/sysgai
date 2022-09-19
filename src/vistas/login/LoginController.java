package vistas.login;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class LoginController {

    @FXML
    private TextField mail;
    @FXML
    private PasswordField contrasenia;

    public void initialize() {
    }

    public void onEntrar() {
        System.out.println(mail.getText());
        System.out.println(contrasenia.getText());
    }
}
