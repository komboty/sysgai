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
import static modelo.utils.ConstantesModelo.*;
import servicios.dtos.FiltroDTO;
import servicios.dtos.ObjectToStringDTO;
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

    public TablaInfoControlador(String servicio, String subServicio, UsuarioLogueadoDTO usuarioLogueadoDTO) {
        this.servicio = servicio;
        this.subServicio = subServicio;
        this.usuarioLogueadoDTO = usuarioLogueadoDTO;
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
            muestraDatos();
        } catch (IOException ex) {
            System.err.println("vistas.utils.TablaControlador.generaTablaIfo()");
            System.err.println(ex);
        }
    }

    private void getGenericServicio() {
        switch (this.servicio) {
            case ICON_LABEL_USUARIOS:
                genericServicio = Dependencias.getUsuarioServicio();
                break;

            case ICON_LABEL_CLIENTES:
                genericServicio = Dependencias.getClienteServicio();
                break;

            case ICON_LABEL_CONTRATOS:
                genericServicio = Dependencias.getContratoServicio();
                break;

            case ICON_LABEL_TICKETS:
                genericServicio = Dependencias.getTicketServicio();
                break;
        }
    }

    private void muestraDatos() throws IOException {
        FiltroDTO filtroDTO = new FiltroDTO();
        if (subServicio.equals(ICON_LABEL_ASIGNADOS)) {
            filtroDTO.setNombre(FILTRO_ASIGNADOS);
            filtroDTO.setValor(String.valueOf(usuarioLogueadoDTO.getIdUsuario()));
        }
        
        List<ObjectToStringDTO> objectDTOs = genericServicio.getTodos(filtroDTO);
        
        if (objectDTOs.isEmpty()) {            
            UtilsVista.lanzaAlertaInformacion(NO_HAY_REGISTROS, NO_HAY_REGISTROS);
            return;
        }

        for (ObjectToStringDTO objectToStringDTO : objectDTOs) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(URL_ITEM_TABLA_INFO));
            Pane pane = fxmlLoader.load();
            ItemTablaInfoControlador detalleInfoControlador = fxmlLoader.getController();
            detalleInfoControlador.setDetalleInfo(objectToStringDTO, genericServicio, servicio, usuarioLogueadoDTO);
            detalleInfoControlador.actualizarTablaInfo().addListener((obs, wasDisabled, isNowDisabled) -> {
                generaTablaInfo();
            });
            vbox.getChildren().add(pane);
        }
    }

}
