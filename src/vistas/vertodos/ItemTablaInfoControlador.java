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
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import static vistas.utils.ConstantesVista.*;
import static modelo.utils.ConstantesModelo.*;
import servicios.dtos.ClienteDTO;
import servicios.dtos.ContratoDTO;
import servicios.dtos.TicketDTO;
import servicios.dtos.UsuarioDTO;
import servicios.dtos.UsuarioLogueadoDTO;
import servicios.interfaces.GenericServicio;
import vistas.crear.crearCliente.CrearClienteControlador;
import vistas.crear.crearUsuario.CrearUsuarioControlador;
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
    private Object objectDTO;
    // Servicio que realizara la accion que desea el usuario.
    private GenericServicio genericServicio;
    // Nombre del servicio.
    private String servicio;
    // Pantalla donde se esta mostrando la informacion.
    private BorderPane borderPaneSubMenu;
    // Variable que al cambiar su estado actualiza la tabla (TablaInfoControlador).
    private final BooleanProperty actualizarTablaInfo = new SimpleBooleanProperty();
    private int id;

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
     * @param objectDTO ObjectDTO con la informacion a mostrar.
     * @param genericServicio Servico que realiza la accion que desea el
     * usuario.
     * @param servicio Nombre del servicio.
     * @param usuarioLogueadoDTO Objeto con el nombre del area del usuario
     * logeado.
     * @param borderPaneSubMenu Pantalla donde se esta mostrando la informacion.
     */
    public void setDetalleInfo(Object objectDTO, GenericServicio genericServicio,
            String servicio, UsuarioLogueadoDTO usuarioLogueadoDTO,
            BorderPane borderPaneSubMenu) {

        this.objectDTO = objectDTO;
        this.genericServicio = genericServicio;
        this.servicio = servicio;
        this.borderPaneSubMenu = borderPaneSubMenu;
        setDatosItem();
        // Si el usuario no es de Mesa de Servico. No puede editar los tickets.
        if ((servicio.equals(ICON_LABEL_TICKETS) && !usuarioLogueadoDTO.getNombreArea().equals(AREA_MESA_DE_SERVICIO))
                || servicio.equals(ICON_LABEL_CONTRATOS)) {
            return;
        }
        addBotones();
    }

    /**
     * Agrega los botones de editar y eliminar a la vistas.
     */
    private void addBotones() {
        try {
            Pane paneEditar = crearBoton(ICON_URL_EDITAR, ICON_LABEL_EDITAR);
            Pane paneEliminar = crearBoton(ICON_URL_ELIMINAR, ICON_LABEL_ELIMINAR);
            vbox.getChildren().addAll(paneEditar, paneEliminar);
        } catch (IOException ex) {
            System.err.println("vistas.vertodos.ItemTablaInfoControlador.addBotones()");
            System.err.println(ex);
        }
    }

    /**
     * Muestra una imagen en la pantalla segun el servicio.
     */
    private void setDatosItem() {
        String urlImageItem = "";
        String datos = "";
        switch (servicio) {
            case ICON_LABEL_USUARIOS:
                urlImageItem = IMAGE_URL_USUARIOS;
                UsuarioDTO usuarioDTO = (UsuarioDTO) objectDTO;
                id = usuarioDTO.getId();
                datos = UtilsVista.usuarioDTOToString(usuarioDTO);
                break;

            case ICON_LABEL_CLIENTES:
                urlImageItem = IMAGE_URL_CLIENTES;
                ClienteDTO clienteDTO = (ClienteDTO) objectDTO;
                id = clienteDTO.getId();
                datos = UtilsVista.clienteDTOToString(clienteDTO);
                break;

            case ICON_LABEL_CONTRATOS:
                urlImageItem = getUrlImageContratos();
                ContratoDTO contratoDTO = (ContratoDTO) objectDTO;
                id = contratoDTO.getId();
                datos = UtilsVista.contratoDTOToString(contratoDTO);
                break;

            case ICON_LABEL_TICKETS:
                urlImageItem = IMAGE_URL_TICKETS;
                TicketDTO ticketDTO = (TicketDTO) objectDTO;
                id = ticketDTO.getId();
                datos = UtilsVista.ticketDTOToString(ticketDTO);
                break;
        }

        this.labelInfo.setText(datos);
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
        ContratoDTO contratoDTO = ((ContratoDTO) objectDTO);
        switch (contratoDTO.getEstado()) {
            case ESTADO_CONTRATO_VALIDADO:
                urlImageItem = IMAGE_URL_CONTRATOS_ESTADO_VALIDADO;
                break;

            case ESTADO_CONTRATO_RECHAZADO:
                urlImageItem = IMAGE_URL_CONTRATOS_ESTADO_RECHAZADO;
                addBotones();
                break;

            case ESTADO_CONTRATO_EN_VALIDACION:
                urlImageItem = IMAGE_URL_CONTRATOS_ESTADO_OTRO;
                addBotonValidar();
                addBotones();
                break;

            default:
                urlImageItem = IMAGE_URL_CONTRATOS_ESTADO_OTRO;
                addBotones();
                break;
        }
        return urlImageItem;
    }

    /**
     * Agrega el boton de validar a la vistas.
     */
    private void addBotonValidar() {
        try {
            Pane paneValidar = crearBoton(ICON_URL_VALIDAR, ICON_LABEL_VALIDAR);
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
        fXMLLoader.setLocation(getClass().getResource(URL_BOTON_IMAGEN));
        Pane pane = fXMLLoader.load();
        BotonImagenControlador botonEditar = fXMLLoader.getController();
        botonEditar.setInfo(urlImagenBoton, textoBoton.toUpperCase());
        pane.setOnMousePressed(event -> llamarServicio(textoBoton));
        pane.setOnMouseEntered(event -> {
            pane.setStyle(String.format("-fx-background-color: %s;", MENU_COLOR_MOUSE_ENTRA));
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
            case ICON_LABEL_EDITAR:
                try {
                    muestraVistaEditar();
                } catch (IOException ex) {
                    System.err.println("vistas.vertodos.ItemTablaInfoControlador.llamarServicio()");
                    System.err.println(ex);
                }
                break;

            case ICON_LABEL_VALIDAR:
                System.out.println("VALIDAR REGISTRO CON ID: " + id);
                break;

            case ICON_LABEL_ELIMINAR:
                // Se lanza Alerta para asegurarse que se quiere eliminar.
                String mensajeEliminar = String.format(ELIMINAR_REGISTRO_MENSAJE_CONFIRMACION, id);
                boolean isEliminar = UtilsVista.lanzaAlertaCancelYAceptar(ELIMINAR_REGISTRO_TITULO, mensajeEliminar);
                // Si no se dio en Aceptar, no se hace nada.
                if (!isEliminar) {
                    return;
                }
                // Si se dio en Aceptar, se elimina.
                boolean isEliminado = genericServicio.eliminarPorId(id);
                // Si ocurrio un error, se notifica al usuario.
                if (!isEliminado) {
                    mensajeEliminar = String.format(ELIMINAR_REGISTRO_MENSAJE_ERROR, id);
                    UtilsVista.lanzaAlertaError(ELIMINAR_REGISTRO_TITULO, mensajeEliminar);
                    return;
                }
                // Si se elimino correctamente, se notifica al usuario.
                mensajeEliminar = String.format(ELIMINAR_REGISTRO_MENSAJE_ELIMINADO, id);
                UtilsVista.lanzaAlertaInformacion(ELIMINAR_REGISTRO_TITULO, mensajeEliminar);
                actualizarTablaInfo.set(!actualizarTablaInfo.get());
                break;
        }
    }

    private void muestraVistaEditar() throws IOException {
        FXMLLoader fxmlLoader = null;
        Parent vista = null;
        switch (servicio) {
            case ICON_LABEL_USUARIOS:
                UsuarioDTO usuarioDTO = (UsuarioDTO) objectDTO;
                fxmlLoader = new FXMLLoader(getClass().getResource(URL_USUARIOS_CREAR));
                vista = fxmlLoader.load();
                CrearUsuarioControlador crearUsuarioControlador = fxmlLoader.getController();
                crearUsuarioControlador.setInfo(usuarioDTO.getNombreArea(), 
                        usuarioDTO.getNombre(), usuarioDTO.getTelefono(), 
                        usuarioDTO.getMail(), usuarioDTO.getDireccion());
                break;

            case ICON_LABEL_CLIENTES:
                ClienteDTO clienteDTO = (ClienteDTO) objectDTO;
                fxmlLoader = new FXMLLoader(getClass().getResource(URL_CLIENTES_CREAR));
                vista = fxmlLoader.load();
                CrearClienteControlador crearClienteControlador = fxmlLoader.getController();
                crearClienteControlador.setInfo(clienteDTO.getNivel(), 
                        clienteDTO.getNombre(), clienteDTO.getTelefono(), 
                        clienteDTO.getMail(), clienteDTO.getDireccion());
                break;
        }

        borderPaneSubMenu.setCenter(vista);

    }
}
