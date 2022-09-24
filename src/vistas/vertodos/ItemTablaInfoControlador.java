package vistas.vertodos;

import vistas.utils.BotonImagenControlador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import modelo.entidades.ObjectInit;
import static modelo.utils.Constantes.*;
import servicios.interfaces.GenericServicio;
import vistas.utils.UtilsVista;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ItemTablaInfoControlador implements Initializable {

    @FXML
    private HBox hbox;
    @FXML
    private Label labelInfo;
    @FXML
    private ImageView imageItem;

    // Objeto a mostrar informacion.
    private ObjectInit objectInit;
    // Servicio que realizara la accion que desea el usuario.
    private GenericServicio genericServicio;
    // Variable que al cambiar su estado actualiza la tabla (TablaInfoControlador).
    private final BooleanProperty actualizarTablaInfo = new SimpleBooleanProperty();

    public BooleanProperty actualizarTablaInfo() {
        return actualizarTablaInfo;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            addBotones();
        } catch (IOException ex) {
            System.err.println("vistas.utils.DetalleInfoControlador.initialize()");
            System.err.println(ex);
        }
    }

    /**
     * Inician valores fundamentales para su funcionamiento.
     *
     * @param objectInit ObjectInit con la informacion a mostrar.
     * @param urlImageItem Url de la imgen que se mostrara junto a la
     * informacion del ObjectInit.
     * @param genericServicio Servico que realiza la accion que desea el
     * usuario.
     */
    public void setDetalleInfo(ObjectInit objectInit, String urlImageItem, GenericServicio genericServicio) {
        this.objectInit = objectInit;
        this.genericServicio = genericServicio;

        Image image = new Image(String.valueOf(getClass().getResource(urlImageItem)));
        imageItem.setImage(image);
        this.labelInfo.setText(objectInit.toString());
    }

    /**
     * Agrega los botones de editra y eliminar a la vistas.
     *
     * @throws IOException
     */
    private void addBotones() throws IOException {
        Pane paneEditar = crearBoton(VISTA_ICON_URL_EDITAR, VISTA_ICON_LABEL_EDITAR);
        Pane paneEliminar = crearBoton(VISTA_ICON_URL_ELIMINAR, VISTA_ICON_LABEL_ELIMINAR);
        hbox.getChildren().addAll(paneEditar, paneEliminar);
    }

    /**
     * Crea un boton (BotonImagenControlador) con una icono y un texto dado.
     *
     * @param urlImagenBoton Ruta del Icono a mostrar en el boton.
     * @param textoBoton Texto a mostrar en el boton.
     * @return Pane con el boton.
     * @throws IOException
     */
    private Pane crearBoton(String urlImagenBoton, String textoBoton) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource(VISTA_URL_BOTON_IMAGEN));
        Pane pane = fXMLLoader.load();
        BotonImagenControlador botonEditar = fXMLLoader.getController();
        botonEditar.setInfo(urlImagenBoton, textoBoton.toUpperCase());
        pane.setOnMousePressed(event -> llamarServicio(textoBoton));
        pane.setOnMouseEntered(event -> {
            pane.setStyle(String.format("-fx-background-color: %s;", VISTA_MENU_COLOR_MOUSE_ENTRA));
        });
        pane.setOnMouseExited(event -> {
            pane.setStyle("-fx-background-color: transparent;");
        });
        return pane;
    }

    private void llamarServicio(String accion) {
        switch (accion) {
            case VISTA_ICON_LABEL_EDITAR:
                System.out.println("EDITAR REGISTRO CON ID: " + objectInit.getId());
                break;

            case VISTA_ICON_LABEL_ELIMINAR:                
                // Se lanza Alerta para asegurarse que se quiere eliminar.
                String mensajeEliminar = String.format(VISTA_ELIMINAR_REGISTRO_MENSAJE_CONFIRMACION, objectInit.getId());
                boolean isEliminar = UtilsVista.lanzaAlertaCancelYAceptar(VISTA_ELIMINAR_REGISTRO_TITULO, mensajeEliminar);
                // Si no se dio en Aceptar, no se hace nada.
                if (!isEliminar) {
                    return;
                }
                // Si se dio en Aceptar, se elimina.
                boolean isEliminado = genericServicio.eliminarPorId(objectInit.getId());
                // Si ocurrio un error, se notifica al usuario.
                if (!isEliminado) {
                    mensajeEliminar = String.format(VISTA_ELIMINAR_REGISTRO_MENSAJE_ERROR, objectInit.getId());
                    UtilsVista.lanzaAlertaError(VISTA_ELIMINAR_REGISTRO_TITULO, mensajeEliminar);
                    return;
                }
                // Si se elimino correctamente, se notifica al usuario.
                mensajeEliminar = String.format(VISTA_ELIMINAR_REGISTRO_MENSAJE_ELIMINADO, objectInit.getId());
                UtilsVista.lanzaAlertaInformacion(VISTA_ELIMINAR_REGISTRO_TITULO, mensajeEliminar);
                actualizarTablaInfo.set(!actualizarTablaInfo.get());
                break;
        }
    }
}
