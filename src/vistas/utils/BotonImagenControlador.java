package vistas.utils;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class BotonImagenControlador implements Initializable {

    @FXML
    private ImageView imageIcono;
    @FXML
    private Label labelTexto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setInfo(String urlImage, String texto) {
        Image image = new Image(String.valueOf(getClass().getResource(urlImage)));
        imageIcono.setImage(image);
        labelTexto.setText(texto);
    }
}
