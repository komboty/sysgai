package vistas.vertodos;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.Dependencias;
import static modelo.utils.ConstantesModelo.*;
import servicios.dtos.ClienteDTO;
import servicios.dtos.ContratoDTO;
import servicios.dtos.TicketDTO;
import servicios.dtos.UsuarioDTO;
import servicios.dtos.UsuarioLogueadoDTO;
import servicios.interfaces.GenericServicio;
import static vistas.utils.ConstantesVista.*;
import vistas.utils.UtilsVista;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class TablaInfoControlador implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox vbox;

    private String servicio;
    private String subServicio;
    private GenericServicio genericServicio;
    private UsuarioLogueadoDTO usuarioLogueadoDTO;
    private BorderPane borderPaneSubMenu;

    public TablaInfoControlador(String servicio, String subServicio, 
            UsuarioLogueadoDTO usuarioLogueadoDTO, BorderPane borderPaneSubMenu) {
        this.servicio = servicio;
        this.subServicio = subServicio;
        this.usuarioLogueadoDTO = usuarioLogueadoDTO;
        this.borderPaneSubMenu = borderPaneSubMenu;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scrollPane.setMinSize(SUB_VENTANA_ANCHO, SUB_VENTANA_ALTO);
        generaTablaInfo();
    }

    private void generaTablaInfo() {
        try {
            vbox.getChildren().clear();
            getGenericServicio();
        } catch (IOException ex) {
            System.err.println("vistas.utils.TablaControlador.generaTablaIfo()");
            System.err.println(ex);
        }
    }

    private void getGenericServicio() throws IOException {
        switch (this.servicio) {
            case ICON_LABEL_USUARIOS:
                genericServicio = Dependencias.getUsuarioServicio();
                muestraDatos(UsuarioDTO.class);
                break;

            case ICON_LABEL_CLIENTES:
                genericServicio = Dependencias.getClienteServicio();
                muestraDatos(ClienteDTO.class);
                break;

            case ICON_LABEL_CONTRATOS:
                genericServicio = Dependencias.getContratoServicio();
                muestraDatos(ContratoDTO.class);
                break;

            case ICON_LABEL_TICKETS:
                genericServicio = Dependencias.getTicketServicio();
                muestraDatos(TicketDTO.class);
                break;
        }
    }

    private <T> void muestraDatos(Class<T> clase) throws IOException {
        boolean isServicioAsignados = subServicio.equals(ICON_LABEL_ASIGNADOS);
        String filtro = isServicioAsignados ? FILTRO_ASIGNADOS : "";
        String valor = isServicioAsignados ? String.valueOf(usuarioLogueadoDTO.getIdUsuario()) : "";
        List<T> objectDTOs = genericServicio.getTodos(filtro, valor);
        // Si no hay registros, se termina la funcion.
        if (objectDTOs.isEmpty()) {
            UtilsVista.lanzaAlertaInformacion(NO_HAY_REGISTROS, NO_HAY_REGISTROS);
            return;
        }
        // Si hay registros, se muestran los datos.
        for (T objectDTO : objectDTOs) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(URL_ITEM_TABLA_INFO));
            Pane pane = fxmlLoader.load();
            ItemTablaInfoControlador detalleInfoControlador = fxmlLoader.getController();
            detalleInfoControlador.setDetalleInfo(objectDTO, genericServicio, servicio, 
                    usuarioLogueadoDTO, borderPaneSubMenu);
            detalleInfoControlador.actualizarTablaInfo().addListener((obs, wasDisabled, isNowDisabled) -> {
                generaTablaInfo();
            });
            vbox.getChildren().add(pane);
        }
    }

}
