package vistas.vertodos;

import java.io.IOException;
import java.net.URL;
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
    private GenericServicio genericServicio;

    public TablaInfoControlador(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scrollPane.setMinSize(VISTA_SUB_VENTANA_ANCHO, VISTA_SUB_VENTANA_ALTO);
        generaTablaInfo();

    }

    private void generaTablaInfo() {
        try {
            vbox.getChildren().clear();
            getGenericServicio();
            muestraDatos();
        } catch (IOException ex) {
            System.err.println("vistas.utils.TablaControlador.generaTablaIfo()");
            System.err.println(ex);
        }
    }

    private void getGenericServicio() {
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
    }

    private void muestraDatos() throws IOException {
        for (ObjectInit objectInit : (List<ObjectInit>) genericServicio.getTodos()) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(VISTA_URL_ITEM_TABLA_INFO));
            Pane pane = fxmlLoader.load();
            ItemTablaInfoControlador detalleInfoControlador = fxmlLoader.getController();
            detalleInfoControlador.setDetalleInfo(objectInit, genericServicio, servicio);
            detalleInfoControlador.actualizarTablaInfo().addListener((obs, wasDisabled, isNowDisabled) -> {
                generaTablaInfo();
            });
            vbox.getChildren().add(pane);
        }
    }

}
