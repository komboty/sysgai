package pantallas.utils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import modelo.clases.ObjectInit;
import static modelo.utils.Constantes.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class DetalleInfoControlador implements Initializable {

    @FXML
    private HBox hbox;
    @FXML
    private Label labelInfo;
    
    private ObjectInit objectInit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            addBotones();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void setObjectInit(ObjectInit objectInit) {
        this.objectInit = objectInit;
        this.labelInfo.setText(objectInit.toString());
    }

    private void addBotones() throws IOException {
        FXMLLoader loaderEditar = new FXMLLoader();
        loaderEditar.setLocation(getClass().getResource(VISTA_URL_BOTON_IMAGEN));
        Pane paneEditar = loaderEditar.load();
        BotonImagenControlador botonEditar = loaderEditar.getController();
        botonEditar.setInfo(VISTA_ICON_URL_EDITAR, VISTA_ICON_LABEL_EDITAR);
        paneEditar.setOnMousePressed(event -> {
            System.out.println("EDITAR: " + objectInit.getId());
        });

        FXMLLoader loaderEliminar = new FXMLLoader();
        loaderEliminar.setLocation(getClass().getResource(VISTA_URL_BOTON_IMAGEN));
        Pane paneEliminar = loaderEliminar.load();
        BotonImagenControlador botonEliminar = loaderEliminar.getController();
        botonEliminar.setInfo(VISTA_ICON_URL_ELIMINAR, VISTA_ICON_LABEL_ELIMINAR);
        paneEliminar.setOnMousePressed(event -> {
            System.out.println("ELIMINAR: " + objectInit.getId());
        });

        hbox.getChildren().addAll(paneEditar, paneEliminar);
    }

}
