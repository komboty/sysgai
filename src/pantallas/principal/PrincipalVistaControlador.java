package pantallas.principal;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelo.clases.Usuario;
import static modelo.utils.Constantes.*;
import pantallas.utils.BotonImagenControlador;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class PrincipalVistaControlador implements Initializable {

    @FXML
    private VBox vboxMenu;
    @FXML
    private VBox vboxSubMenu;
    @FXML
    private BorderPane borderPaneMenu;
    @FXML
    private BorderPane borderPaneSubMenu;

    private Usuario usuario;
    private Map<String, String> botonesMenu;
    private Map<String, String> botonesSubMenu;
    private String delimitador = ",";

    public PrincipalVistaControlador(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        borderPaneMenu.setMinHeight(VISTA_VENTANA_ALTO);
        borderPaneMenu.setMinWidth(VISTA_VENTANA_ANCHO);
        vboxMenu.setMinHeight(VISTA_VENTANA_ALTO);
        vboxSubMenu.setMinHeight(VISTA_VENTANA_ALTO);
        vboxMenu.setStyle(String.format("-fx-background-color: %s;", VISTA_MENU_COLOR_FONDO));

        try {
            // Se obtienen los botones del menu segun el usuario logeado.
            getPermisosMenu();
            setBotonesMenu();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * Obtiene los botones (BotonImagenControlador) del menu segun el tipo del
     * Usuario.
     */
    private void getPermisosMenu() {
        botonesMenu = new HashMap<>();
        botonesSubMenu = new HashMap<>();
        botonesMenu.put(VISTA_ICON_LABEL_TICKETS, VISTA_ICON_URL_TICKETS);
        botonesSubMenu.put(VISTA_ICON_LABEL_TICKETS, VISTA_ICON_LABEL_VER_TODOS);

        switch (usuario.getTipo()) {
            case TIPO_USUARIO_ADMINISTRADOR:
                botonesMenu.put(VISTA_ICON_LABEL_USUARIOS, VISTA_ICON_URL_USUARIOS);
                botonesSubMenu.put(VISTA_ICON_LABEL_USUARIOS, VISTA_ICON_LABEL_CREAR+","+VISTA_ICON_LABEL_VER_TODOS);
                break;

            case TIPO_USUARIO_ARRENDADOR:
                botonesMenu.put(VISTA_ICON_LABEL_CLIENTES, VISTA_ICON_URL_CLIENTES);
                botonesSubMenu.put(VISTA_ICON_LABEL_CLIENTES, VISTA_ICON_LABEL_CREAR+","+VISTA_ICON_LABEL_VER_TODOS);
                botonesMenu.put(VISTA_ICON_LABEL_CONTRATOS, VISTA_ICON_URL_CONTRATOS);
                botonesSubMenu.put(VISTA_ICON_LABEL_CONTRATOS, VISTA_ICON_LABEL_CREAR);
                botonesMenu.put(VISTA_ICON_LABEL_PEDIDOS, VISTA_ICON_URL_PEDIDOS);
                botonesSubMenu.put(VISTA_ICON_LABEL_PEDIDOS, VISTA_ICON_LABEL_CREAR+","+VISTA_ICON_LABEL_VER_TODOS+","+VISTA_ICON_LABEL_VALIDAR);
                break;

            case TIPO_USUARIO_ABOGADO:
                botonesMenu.put(VISTA_ICON_LABEL_CONTRATOS, VISTA_ICON_URL_CONTRATOS);
                botonesSubMenu.put(VISTA_ICON_LABEL_CONTRATOS, VISTA_ICON_LABEL_CREAR+","+VISTA_ICON_LABEL_VER_TODOS+","+VISTA_ICON_LABEL_VALIDAR);
                break;

            case TIPO_USUARIO_CONTADOR:
                botonesMenu.put(VISTA_ICON_LABEL_FACTURAS, VISTA_ICON_URL_FACTURAS);
                botonesSubMenu.put(VISTA_ICON_LABEL_FACTURAS, VISTA_ICON_LABEL_CREAR+","+VISTA_ICON_LABEL_VER_TODOS+","+VISTA_ICON_LABEL_VALIDAR);
                break;

            case TIPO_USUARIO_TECNICO:
                break;

            case TIPO_USUARIO_MESA:
                botonesSubMenu.put(VISTA_ICON_LABEL_TICKETS, VISTA_ICON_LABEL_CREAR+","+VISTA_ICON_LABEL_VER_TODOS);
                break;

            case TIPO_USUARIO_CHOFER:
                break;

            case TIPO_USUARIO_ALMACENISTA:
                botonesMenu.put(VISTA_ICON_LABEL_ALMACENES, VISTA_ICON_URL_ALMACENES);
                botonesSubMenu.put(VISTA_ICON_LABEL_ALMACENES, VISTA_ICON_LABEL_CREAR+","+VISTA_ICON_LABEL_VER_TODOS);
                break;
        }
    }

    /**
     * Muestra en la vista los botones (BotonImagenControlador).
     */
    public void setBotonesMenu() throws IOException {
        int sizeBotonesMenu = botonesMenu.size();
        boolean[] isSeleccionado = new boolean[sizeBotonesMenu];
        Node[] nodos = new Node[sizeBotonesMenu];
        int i = 0;

        for (Map.Entry<String, String> botonMenu : botonesMenu.entrySet()) {
            final int iNodo = i;
            // Se carga la vista de cada boton (BotonImagenControlador).
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(VISTA_URL_BOTON_IMAGEN));
            nodos[iNodo] = fxmlLoader.load(); 
            BotonImagenControlador botonImagenControlador = fxmlLoader.getController();
            botonImagenControlador.setInfo(botonMenu.getValue(), botonMenu.getKey());

            // Se pone animacion a cada boton (BotonImagenControlador).
            nodos[iNodo].setOnMouseEntered(event -> {
                if (!isSeleccionado[iNodo]) {
                    nodos[iNodo].setStyle(String.format("-fx-background-color: %s;", VISTA_MENU_COLOR_MOUSE_ENTRA));
                }
            });

            nodos[iNodo].setOnMouseExited(event -> {
                String color = !isSeleccionado[iNodo] ? VISTA_MENU_COLOR_FONDO : VISTA_MENU_COLOR_MOUSE_CLICK;
                nodos[iNodo].setStyle(String.format("-fx-background-color: %s;", color));
            });

            nodos[iNodo].setOnMousePressed(event -> {
                // Se restaura el color de todos los botones (BotonImagenControlador).
                Arrays.fill(isSeleccionado, false);
                for (Node nodo : nodos) {
                    nodo.setStyle(String.format("-fx-background-color: %s;", VISTA_MENU_COLOR_FONDO));
                }
                // Se selecciona el boton (BotonImagenControlador) que se dio click.
                isSeleccionado[iNodo] = true;
                nodos[iNodo].setStyle(String.format("-fx-background-color: %s;", VISTA_MENU_COLOR_MOUSE_CLICK));
                try {
                    // Se pone el subMenus segun el boton presionado.
                    vboxSubMenu.setStyle(String.format("-fx-background-color: %s;", VISTA_MENU_COLOR_FONDO));
                    setBotonesSubMenu(botonMenu.getKey());
                } catch (IOException ex) {
                    System.err.println();
                }
            });
            i++;

            // Se agregan al menu.                
            vboxMenu.getChildren().add(nodos[iNodo]);
        }
    }

    /**
     * Muestra en la vista los botones (BotonImagenControlador).
     */
    public void setBotonesSubMenu(String nombreBoton) throws IOException {
        vboxSubMenu.getChildren().clear();
        Map<String, String> urlBotonesSubMenu = getBotonesSubMenu();
        String[] nbotonesSubMenu = botonesSubMenu.get(nombreBoton).split(delimitador);
        boolean[] isSeleccionado = new boolean[nbotonesSubMenu.length];
        Node[] nodos = new Node[nbotonesSubMenu.length];
        
        for (int i = 0; i < nbotonesSubMenu.length; i++) {
            final int iNodo = i;
            // Se carga la vista de cada boton (BotonImagenControlador).
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(VISTA_URL_BOTON_IMAGEN));
            nodos[iNodo] = fxmlLoader.load();
            BotonImagenControlador botonImagenControlador = fxmlLoader.getController();
            String urlIcono = urlBotonesSubMenu.get(nbotonesSubMenu[iNodo]);
            botonImagenControlador.setInfo(urlIcono, nbotonesSubMenu[iNodo]);

            // Se pone animacion a cada boton (BotonImagenControlador).
            nodos[iNodo].setOnMouseEntered(event -> {
                if (!isSeleccionado[iNodo]) {
                    nodos[iNodo].setStyle(String.format("-fx-background-color: %s;", VISTA_MENU_COLOR_MOUSE_ENTRA));
                }
            });

            nodos[iNodo].setOnMouseExited(event -> {
                String color = !isSeleccionado[iNodo] ? VISTA_MENU_COLOR_FONDO : VISTA_MENU_COLOR_MOUSE_CLICK;
                nodos[iNodo].setStyle(String.format("-fx-background-color: %s;", color));
            });

            nodos[iNodo].setOnMousePressed(event -> {
                // Se restaura el color de todos los botones (BotonImagenControlador).
                Arrays.fill(isSeleccionado, false);
                for (Node nodo : nodos) {
                    nodo.setStyle(String.format("-fx-background-color: %s;", VISTA_MENU_COLOR_FONDO));
                }
                // Se selecciona el boton (BotonImagenControlador) que se dio click.
                isSeleccionado[iNodo] = true;
                nodos[iNodo].setStyle(String.format("-fx-background-color: %s;", VISTA_MENU_COLOR_MOUSE_CLICK));
//                String urlPanel = urlbotonesMenu.get(botonMenu.getKey());
//                System.out.println(urlPanel);
//                try {
//                    FXMLLoader fxmlLoaderPanel = new FXMLLoader(getClass().getResource(urlPanel));
//                    Pane vista = fxmlLoaderPanel.load();
//                    borderPane.setCenter(vista);
//                } catch (IOException e) {
//                    System.err.println(e);
//                }
            });
            
            // Se agregan al menu.                
            vboxSubMenu.getChildren().add(nodos[iNodo]);
        }
    }
}
