package vistas.principal;

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
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelo.entidades.Usuario;
import static modelo.utils.Constantes.*;
import vistas.utils.BotonImagenControlador;
import vistas.vertodos.TablaInfoControlador;

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

    // Usuario logeado.
    private Usuario usuario;
    private Map<String, String> botonesMenu;
    private Map<String, String> botonesSubMenu;

    public PrincipalVistaControlador(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Se fija el tamanio de los elementos.        
        borderPaneMenu.setMinSize(VISTA_VENTANA_ANCHO, VISTA_VENTANA_ALTO);
        vboxMenu.setMinSize(VISTA_MENU_ANCHO, VISTA_VENTANA_ALTO);
        vboxSubMenu.setMinSize(VISTA_MENU_ANCHO, VISTA_VENTANA_ALTO);
        vboxMenu.setStyle(String.format("-fx-background-color: %s;", VISTA_MENU_COLOR_FONDO));

        // Se obtienen los botones del menu segun el usuario logeado.
        try {
            getPermisosMenu();
            muestraBotonesMenu();
        } catch (IOException ex) {
            System.err.println("vistas.principal.PrincipalVistaControlador.initialize()");
            System.err.println(ex);
        }
    }

    /**
     * Obtiene los botones (BotonImagenControlador) del Menu y los permisos
     * segun el Usuario logeado.
     */
    private void getPermisosMenu() {
        botonesMenu = new HashMap<>();
        botonesSubMenu = new HashMap<>();
        botonesMenu.put(VISTA_ICON_LABEL_TICKETS, VISTA_ICON_URL_TICKETS);
        botonesSubMenu.put(VISTA_ICON_LABEL_TICKETS, VISTA_ICON_LABEL_VER_TODOS);

        switch (usuario.getArea().getNombre()) {
            case AREA_ADMINISTRACION:
                botonesMenu.put(VISTA_ICON_LABEL_USUARIOS, VISTA_ICON_URL_USUARIOS);
                botonesSubMenu.put(VISTA_ICON_LABEL_USUARIOS, String.valueOf(VISTA_ICON_LABEL_CREAR + DELIMITADOR_DIRECCCION + VISTA_ICON_LABEL_VER_TODOS));
                break;

            case AREA_ARRENDAMIENTO:
                botonesMenu.put(VISTA_ICON_LABEL_CLIENTES, VISTA_ICON_URL_CLIENTES);
                botonesSubMenu.put(VISTA_ICON_LABEL_CLIENTES, VISTA_ICON_LABEL_CREAR + DELIMITADOR_DIRECCCION + VISTA_ICON_LABEL_VER_TODOS);
                botonesMenu.put(VISTA_ICON_LABEL_CONTRATOS, VISTA_ICON_URL_CONTRATOS);
                botonesSubMenu.put(VISTA_ICON_LABEL_CONTRATOS, VISTA_ICON_LABEL_CREAR);
                botonesMenu.put(VISTA_ICON_LABEL_PEDIDOS, VISTA_ICON_URL_PEDIDOS);
                botonesSubMenu.put(VISTA_ICON_LABEL_PEDIDOS, VISTA_ICON_LABEL_CREAR + DELIMITADOR_DIRECCCION + VISTA_ICON_LABEL_VER_TODOS);
                break;

            case AREA_ABOGADOS:
                botonesMenu.put(VISTA_ICON_LABEL_CONTRATOS, VISTA_ICON_URL_CONTRATOS);
                botonesSubMenu.put(VISTA_ICON_LABEL_CONTRATOS, VISTA_ICON_LABEL_CREAR + DELIMITADOR_DIRECCCION + VISTA_ICON_LABEL_VER_TODOS);
                break;

            case AREA_CONTADORES:
                botonesMenu.put(VISTA_ICON_LABEL_FACTURAS, VISTA_ICON_URL_FACTURAS);
                botonesSubMenu.put(VISTA_ICON_LABEL_FACTURAS, VISTA_ICON_LABEL_CREAR + DELIMITADOR_DIRECCCION + VISTA_ICON_LABEL_VER_TODOS);
                break;

            case AREA_TECNICOS:
                break;

            case AREA_MESA_DE_SERVICIO:
                botonesSubMenu.put(VISTA_ICON_LABEL_TICKETS, VISTA_ICON_LABEL_CREAR + DELIMITADOR_DIRECCCION + VISTA_ICON_LABEL_VER_TODOS);
                break;

            case AREA_DISTRIBUCION:
                break;

            case AREA_ALMACEN:
                botonesMenu.put(VISTA_ICON_LABEL_ALMACENES, VISTA_ICON_URL_ALMACENES);
                botonesSubMenu.put(VISTA_ICON_LABEL_ALMACENES, VISTA_ICON_LABEL_CREAR + DELIMITADOR_DIRECCCION + VISTA_ICON_LABEL_VER_TODOS);
                break;
        }
    }

    /**
     * Muestra en la vista los botones (BotonImagenControlador) del Menu
     * principal.
     */
    private void muestraBotonesMenu() throws IOException {
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
                    muestraBotonesSubMenu(botonMenu.getKey());
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
     * Muestra en la vista los botones (BotonImagenControlador) del SubMenu.
     */
    private void muestraBotonesSubMenu(String nombreBoton) throws IOException {
        vboxSubMenu.getChildren().clear();
        Map<String, String> urlBotonesSubMenu = getBotonesSubMenu();
        String[] nbotonesSubMenu = botonesSubMenu.get(nombreBoton).split(DELIMITADOR_DIRECCCION);
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
                // Se muestra la pantalla segun el boton (BotonImagenControlador) seleccionado.                
                muestraPanel(nombreBoton, nbotonesSubMenu[iNodo]);
            });

            // Se agregan al menu.                
            vboxSubMenu.getChildren().add(nodos[iNodo]);
        }
    }

    /**
     * Muestra en pantalla la informacion desaea con base al boton
     * (BotonImagenControlador) seleccionado.
     */
    private void muestraPanel(String nombreBoton, String nombreSubBoton) {
        // Se obtiene la ruta de la vista a mostrar.
        switch (nombreSubBoton) {
            case VISTA_ICON_LABEL_CREAR:
                muestraPaneCrear(nombreBoton);
                break;

            case VISTA_ICON_LABEL_VER_TODOS:
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(VISTA_URL_TABLA_INFO));
                fxmlLoader.setControllerFactory(controllerClass -> new TablaInfoControlador(nombreBoton));
                Parent vista = fxmlLoader.load();
                borderPaneSubMenu.setCenter(vista);
            } catch (IOException ex) {
                System.err.println("vistas.principal.PrincipalVistaControlador.muestraPanel()");
                System.err.println(ex);
            }
            break;
        }
    }

    /**
     * Muestra en pantalla la informacion desaea con base al boton
     * (BotonImagenControlador) seleccionado.
     */
    private void muestraPaneCrear(String nombreBoton) {
        String urlPaneCrear = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        // Se obtiene la ruta de la vista a mostrar.
        switch (nombreBoton) {
            case VISTA_ICON_LABEL_USUARIOS:
                urlPaneCrear = VISTA_URL_USUARIOS_CREAR;
                break;

            case VISTA_ICON_LABEL_ALMACENES:
                urlPaneCrear = VISTA_URL_ALMACENES_CREAR;
                break;

            case VISTA_ICON_LABEL_CLIENTES:
                urlPaneCrear = VISTA_URL_CLIENTES_CREAR;
                break;

            case VISTA_ICON_LABEL_CONTRATOS:
                urlPaneCrear = VISTA_URL_CONTRATOS_CREAR;
                break;

            case VISTA_ICON_LABEL_FACTURAS:
                urlPaneCrear = VISTA_URL_FACTURAS_CREAR;
                break;

            case VISTA_ICON_LABEL_PEDIDOS:
                urlPaneCrear = VISTA_URL_PEDIDOS_CREAR;
                break;

            case VISTA_ICON_LABEL_TICKETS:
                urlPaneCrear = VISTA_URL_TICKETS_CREAR;
                break;
        }

        try {
            fxmlLoader.setLocation(getClass().getResource(urlPaneCrear));
            Parent pane = fxmlLoader.load();
            borderPaneSubMenu.setCenter(pane);
        } catch (IOException ex) {
            System.err.println("vistas.principal.PrincipalVistaControlador.muestraPaneCrear()");
            System.err.println(ex);
        }
    }
}
