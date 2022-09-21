package pantallas.utils;

import basedatos.daos.implementacion.UsuarioDAOImpl;
import basedatos.daos.interfaces.UsuarioDAO;
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
import modelo.clases.ObjectInit;
import modelo.clases.Usuario;
import static modelo.utils.Constantes.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class TablaControlador implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox vbox;
    
//    Cambiar por Servicios.
    private static UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    private String nombreBoton;
    
    public TablaControlador(String nombreBoton) {
        this.nombreBoton = nombreBoton;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scrollPane.setMinSize(VISTA_SUB_VENTANA_ANCHO, VISTA_SUB_VENTANA_ALTO);
        
        try {
            List<ObjectInit> listObjectInit = getDatos();
            muestraDatos(listObjectInit);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private List<ObjectInit> getDatos() {
        List<ObjectInit> listObjectInit = new ArrayList<>();
        switch (this.nombreBoton) {
            case VISTA_ICON_LABEL_USUARIOS:
                listObjectInit = (List<ObjectInit>) (List<? extends ObjectInit>) usuarioDAO.getAllUsuario();
                break;            
        }

        return listObjectInit;
    }

    private void muestraDatos(List<ObjectInit> listObjectInit) throws IOException {        
        for (ObjectInit objectInit : listObjectInit) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(VISTA_URL_DETALLE_INFO));
            Pane pane = fxmlLoader.load();
            DetalleInfoControlador detalleInfoControlador = fxmlLoader.getController();
            detalleInfoControlador.setObjectInit(objectInit); 
            vbox.getChildren().add(pane); 
        }
    }

}
