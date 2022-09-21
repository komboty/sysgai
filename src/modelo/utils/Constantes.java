package modelo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public final class Constantes {

    // Pantallas
    public static final String VISTA_TITULO_SISTEMA = "SYSGAI";
    public static final double VISTA_VENTANA_ALTO = 800;
    public static final double VISTA_VENTANA_ANCHO = 1000;
    public static final String VISTA_VENTANA_COLOR_1 = "#997A79";
    public static final String VISTA_VENTANA_COLOR_2 = "#E4E6B5";
    public static final String VISTA_VENTANA_COLOR_3 = "#E5CDCC";
    public static final String VISTA_VENTANA_COLOR_4 = "#B5D0E6";
    public static final String VISTA_VENTANA_COLOR_5 = "#818E99";
    public static final String VISTA_MENU_COLOR_FONDO = VISTA_VENTANA_COLOR_4; 
    public static final String VISTA_MENU_COLOR_MOUSE_ENTRA = VISTA_VENTANA_COLOR_5;
    public static final String VISTA_MENU_COLOR_MOUSE_CLICK = VISTA_VENTANA_COLOR_2; 
    
    
    public static final String VISTA_URL_LOGIN = "/pantallas/login/loginVista.fxml";
    public static final String VISTA_URL_PRINCIPAL = "/pantallas/principal/principalVista.fxml";
//    public static final String VISTA_URL_ALMACENES = "/pantallas/principal/almacenesVista.fxml";
//    public static final String VISTA_URL_CLIENTES = "/pantallas/principal/clientesVista.fxml";
//    public static final String VISTA_URL_CONTRATOS = "/pantallas/principal/contratosVista.fxml";
//    public static final String VISTA_URL_FACTURAS = "/pantallas/principal/facturasVista.fxml";
//    public static final String VISTA_URL_PEDIDOS = "/pantallas/principal/pedidosVista.fxml";
//    public static final String VISTA_URL_TICKETS = "/pantallas/principal/ticketsVista.fxml";
//    public static final String VISTA_URL_USUARIOS = "/pantallas/usuarios/usuariosVista.fxml";
    public static final String VISTA_URL_BOTON_IMAGEN = "/pantallas/utils/botonImagen.fxml";

    public static final String VISTA_ERROR_NO_USUARIO = "No existe el Usuario";

    public static final String VISTA_ICON_LABEL_ALMACENES = "Productos";
    public static final String VISTA_ICON_URL_ALMACENES = "/recursos/iconos/icono_productos.png";
    public static final String VISTA_ICON_LABEL_CLIENTES = "Clientes";
    public static final String VISTA_ICON_URL_CLIENTES = "/recursos/iconos/icono_clientes.png";
    public static final String VISTA_ICON_LABEL_CONTRATOS = "Contratos";
    public static final String VISTA_ICON_URL_CONTRATOS = "/recursos/iconos/icono_contratos.png";
    public static final String VISTA_ICON_LABEL_FACTURAS = "Facturas";
    public static final String VISTA_ICON_URL_FACTURAS = "/recursos/iconos/icono_facturas.png";
    public static final String VISTA_ICON_LABEL_PEDIDOS = "Pedidos";
    public static final String VISTA_ICON_URL_PEDIDOS = "/recursos/iconos/icono_pedidos.png";
    public static final String VISTA_ICON_LABEL_TICKETS = "Tickets";
    public static final String VISTA_ICON_URL_TICKETS = "/recursos/iconos/icono_tickets.png";
    public static final String VISTA_ICON_LABEL_USUARIOS = "Usuarios";
    public static final String VISTA_ICON_URL_USUARIOS = "/recursos/iconos/icono_usuarios.png";
    
    public static final String VISTA_ICON_LABEL_CREAR = "Crear";
    public static final String VISTA_ICON_URL_CREAR = "/recursos/iconos/icono_crear.png";
    public static final String VISTA_ICON_LABEL_VALIDAR = "Validar";
    public static final String VISTA_ICON_URL_VALIDAR = "/recursos/iconos/icono_validar.png";
    public static final String VISTA_ICON_LABEL_VER_TODOS = "Ver Todos";
    public static final String VISTA_ICON_URL_VER_TODOS = "/recursos/iconos/icono_ver_todos.png";
    

    // Tipos
    public static final String TIPO_USUARIO_ARRENDADOR = "Arrendador";
    public static final String TIPO_USUARIO_ABOGADO = "Abogado";
    public static final String TIPO_USUARIO_CONTADOR = "Contador";
    public static final String TIPO_USUARIO_TECNICO = "Técnico";
    public static final String TIPO_USUARIO_MESA = "Mesa de servicio";
    public static final String TIPO_USUARIO_CHOFER = "Chofer";
    public static final String TIPO_USUARIO_ALMACENISTA = "Almacenista";
    public static final String TIPO_USUARIO_ADMINISTRADOR = "Administrador";

    // Base de datos
    public static final String DB_HOST = "localhost";
    public static final String DB_PUERTO = "5432";
    public static final String DB_NOMBRE = "sysgai";
    public static final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PUERTO + "/" + DB_NOMBRE;
    public static final String DB_USUARIO = "odoo";
    public static final String DB_CONTRASENIA = "odoo";

    public static final String DB_N_T_USUARIO = "Usuario";
    public static final String T_USUARIO_C_ID = "id";
    public static final String T_USUARIO_C_ID_TIPO_USUARIO = "idTipoUsuario";
    public static final String T_USUARIO_C_FECHA_CREACION = "fechaCreacion";
    public static final String T_USUARIO_C_FECHA_MODIFICACION = "fechaModificacion";
    public static final String T_USUARIO_C_NOMBRE = "nombre";
    public static final String T_USUARIO_C_TELEFONO = "telefono";
    public static final String T_USUARIO_C_MAIL = "mail";
    public static final String T_USUARIO_C_DIRECCION = "direccion";
    public static final String T_USUARIO_C_CONTRASENIA = "contrasenia";

    public static final String DB_N_T_TIPO_USUARIO = "TipoUsuario";
    public static final String T_TIPO_USUARIO_C_ID = "id";
    public static final String T_TIPO_USUARIO_C_TIPO = "tipo";

    public static Map<String, String> getBotonesSubMenu() {
        Map<String, String> botonesSubMenu = new HashMap<String, String>();
        botonesSubMenu.put(VISTA_ICON_LABEL_CREAR, VISTA_ICON_URL_CREAR);
        botonesSubMenu.put(VISTA_ICON_LABEL_VALIDAR, VISTA_ICON_URL_VALIDAR);
        botonesSubMenu.put(VISTA_ICON_LABEL_VER_TODOS, VISTA_ICON_URL_VER_TODOS);
        return botonesSubMenu;
    }
}
