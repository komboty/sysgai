package vistas.crear.crearCliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class CrearClienteControlador implements Initializable {

    @FXML
    private TextField nombre;
    @FXML
    private ComboBox<String> nivel;
    @FXML
    private TextField correo;
    @FXML
    private TextField telefono;
    @FXML
    private TextField direccion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
