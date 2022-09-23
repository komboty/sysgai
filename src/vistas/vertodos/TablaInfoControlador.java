package vistas.vertodos;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.Dependencias;
import modelo.entidades.ObjectInit;
import servicios.interfaces.GenericServicio;
import static modelo.utils.Constantes.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class TablaInfoControlador implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox vbox;

    private String servicio;

    public TablaInfoControlador(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scrollPane.setMinSize(VISTA_SUB_VENTANA_ANCHO, VISTA_SUB_VENTANA_ALTO);

        try {
            List<ObjectInit> listObjectInit = getDatos();
            muestraDatos(listObjectInit);
        } catch (IOException ex) {
            System.err.println("vistas.utils.TablaControlador.initialize()");
            System.err.println(ex);
        }
    }

    private List<ObjectInit> getDatos() {
        List<ObjectInit> listObjectInit = new ArrayList<>();
        GenericServicio genericServicio = null;
        switch (this.servicio) {
            case VISTA_ICON_LABEL_USUARIOS:
                genericServicio = Dependencias.getUsuarioServicio();
                break;

            case VISTA_ICON_LABEL_CLIENTES:
                genericServicio = Dependencias.getClienteServicio();
                break;

            case VISTA_ICON_LABEL_CONTRATOS:
                genericServicio = Dependencias.getContratoServicio();
                break;
        }

        return (List<ObjectInit>) (List<? extends ObjectInit>) genericServicio.getTodos();
    }

    private void muestraDatos(List<ObjectInit> listObjectInit) throws IOException {
        for (ObjectInit objectInit : listObjectInit) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(VISTA_URL_ITEM_TABLA_INFO));
            Pane pane = fxmlLoader.load();
            ItemTablaInfoControlador detalleInfoControlador = fxmlLoader.getController();
            detalleInfoControlador.setObjectInit(objectInit);
            vbox.getChildren().add(pane);
        }
    }

}
