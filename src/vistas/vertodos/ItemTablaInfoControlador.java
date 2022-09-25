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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelo.entidades.Contrato;
import modelo.entidades.ObjectInit;
import static modelo.utils.Constantes.*;
import servicios.interfaces.GenericServicio;
import vistas.utils.UtilsVista;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ItemTablaInfoControlador implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private Label labelInfo;
    @FXML
    private ImageView imageItem;

    // Objeto a mostrar informacion.
    private ObjectInit objectInit;
    // Servicio que realizara la accion que desea el usuario.
    private GenericServicio genericServicio;
    // Nombre del servicio.
    private String servicio;
    // Variable que al cambiar su estado actualiza la tabla (TablaInfoControlador).
    private final BooleanProperty actualizarTablaInfo = new SimpleBooleanProperty();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * Regresa variable que al cambiar su estado actualiza la tabla
     * (TablaInfoControlador).
     *
     * @return BooleanProperty.
     */
    public BooleanProperty actualizarTablaInfo() {
        return actualizarTablaInfo;
    }

    /**
     * Inician valores fundamentales para el funcionamiento del
     * ItemTablaInfoControlador.
     *
     * @param objectInit ObjectInit con la informacion a mostrar.
     * @param genericServicio Servico que realiza la accion que desea el
     * usuario.
     * @param servicio Nombre del servicio.
     */
    public void setDetalleInfo(ObjectInit objectInit, GenericServicio genericServicio, String servicio) {
        this.objectInit = objectInit;
        this.genericServicio = genericServicio;
        this.servicio = servicio;
        this.labelInfo.setText(objectInit.toString());
        setImageItem();
        addBotones();
    }

    /**
     * Agrega los botones de editar y eliminar a la vistas.
     */
    private void addBotones() {
        try {
            Pane paneEditar = crearBoton(VISTA_ICON_URL_EDITAR, VISTA_ICON_LABEL_EDITAR);
            Pane paneEliminar = crearBoton(VISTA_ICON_URL_ELIMINAR, VISTA_ICON_LABEL_ELIMINAR);
            vbox.getChildren().addAll(paneEditar, paneEliminar);
        } catch (IOException ex) {
            System.err.println("vistas.vertodos.ItemTablaInfoControlador.addBotones()");
            System.err.println(ex);
        }
    }

    
    /**
     * Muestra una imagen en la pantalla segun el servicio.
     */
    private void setImageItem() {
        String urlImageItem = null;
        switch (servicio) {
            case VISTA_ICON_LABEL_USUARIOS:
                urlImageItem = VISTA_IMAGE_URL_USUARIOS;
                break;

            case VISTA_ICON_LABEL_CLIENTES:
                urlImageItem = VISTA_IMAGE_URL_CLIENTES;
                break;

            case VISTA_ICON_LABEL_CONTRATOS:
                urlImageItem = getUrlImageContratos();
                break;
        }

        Image image = new Image(String.valueOf(getClass().getResource(urlImageItem)));
        imageItem.setImage(image);
    }

    /**
     * Si el servicio es de Contratos, se se pone un imagen segun el estado del
     * Contrato.
     *
     * @return Url de la imagen a mostrar en pantalla.
     */
    private String getUrlImageContratos() {
        String urlImageItem = null;
        Contrato contrato = (Contrato) this.objectInit;
        switch (contrato.getEstado()) {
            case ESTADO_CONTRATO_VALIDADO:
                urlImageItem = VISTA_IMAGE_URL_CONTRATOS_ESTADO_VALIDADO;
                break;

            case ESTADO_CONTRATO_RECHAZADO:
                urlImageItem = VISTA_IMAGE_URL_CONTRATOS_ESTADO_RECHAZADO;
                break;

            case ESTADO_CONTRATO_EN_VALIDACION:
                urlImageItem = VISTA_IMAGE_URL_CONTRATOS_ESTADO_OTRO;
                addBotonValidar();
                break;

            default:
                urlImageItem = VISTA_IMAGE_URL_CONTRATOS_ESTADO_OTRO;
                break;
        }
        return urlImageItem;
    }
    
    /**
     * Agrega el boton de validar a la vistas.
     */
    private void addBotonValidar() {
        try {
            Pane paneValidar = crearBoton(VISTA_ICON_URL_VALIDAR, VISTA_ICON_LABEL_VALIDAR);
            vbox.getChildren().add(paneValidar);
        } catch (IOException ex) {
            System.err.println("vistas.vertodos.ItemTablaInfoControlador.addBotonValidar()");
            System.err.println(ex);
        }
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

    /**
     * Dada una accion (Un boton oprimido) se llama un Servicio u otra vista.
     *
     * @param accion
     */
    private void llamarServicio(String accion) {
        switch (accion) {
            case VISTA_ICON_LABEL_EDITAR:
                System.out.println("EDITAR REGISTRO CON ID: " + objectInit.getId());
                break;
                
             case VISTA_ICON_LABEL_VALIDAR:
                System.out.println("VALIDAR REGISTRO CON ID: " + objectInit.getId());
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
