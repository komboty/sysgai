package vistas.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public final class ConstantesVista {

    // Configuracion
    public static final String TITULO_SISTEMA = "SYSGAI";
    public static final double STAGE_ALTO = 600;
    public static final double STAGE_ANCHO = 1200;
    public static final double VENTANA_ALTO_AJUSTE = 36;
    public static final double VENTANA_ANCHO_AJUSTE = 10;
    public static final double VENTANA_ALTO = STAGE_ALTO - VENTANA_ALTO_AJUSTE;
    public static final double VENTANA_ANCHO = STAGE_ANCHO - VENTANA_ANCHO_AJUSTE;
    public static final double MENU_ANCHO = 120;
    public static final double SUB_VENTANA_ANCHO = VENTANA_ANCHO - (MENU_ANCHO * 2);
    public static final double SUB_VENTANA_ALTO = VENTANA_ALTO;
    public static final String VENTANA_COLOR_1 = "#997A79";
    public static final String VENTANA_COLOR_2 = "#E4E6B5";
    public static final String VENTANA_COLOR_3 = "#E5CDCC";
    public static final String VENTANA_COLOR_4 = "#B5D0E6";
    public static final String VENTANA_COLOR_5 = "#818E99";
    public static final String MENU_COLOR_FONDO = VENTANA_COLOR_4;
    public static final String MENU_COLOR_MOUSE_ENTRA = VENTANA_COLOR_5;
    public static final String MENU_COLOR_MOUSE_CLICK = VENTANA_COLOR_2;

    // URL de FXML de vistas
    public static final String URL_LOGIN = "/vistas/login/loginVista.fxml";
    public static final String URL_PRINCIPAL = "/vistas/principal/principalVista.fxml";
    public static final String URL_BOTON_IMAGEN = "/vistas/utils/botonImagen.fxml";
    public static final String URL_ITEM_TABLA_INFO = "/vistas/vertodos/itemTablaInfo.fxml";
    public static final String URL_TABLA_INFO = "/vistas/vertodos/tablaInfo.fxml";
    public static final String URL_ALMACENES_CREAR = "/vistas/.fxml";
    public static final String URL_CLIENTES_CREAR = "/vistas/.fxml";
    public static final String URL_CONTRATOS_CREAR = "/vistas/.fxml";
    public static final String URL_FACTURAS_CREAR = "/vistas/.fxml";
    public static final String URL_PEDIDOS_CREAR = "/vistas/.fxml";
    public static final String URL_TICKETS_CREAR = "/vistas/.fxml";
    public static final String URL_USUARIOS_CREAR = "/vistas/.fxml";

    // Mensajes de la vista.
    public static final String NO_HAY_REGISTROS = "No se encontro ningun registro";
    public static final String ELIMINAR_REGISTRO_TITULO = "Eliminar registro";
    public static final String ELIMINAR_REGISTRO_MENSAJE_CONFIRMACION = "Esta seguro de eliminar el registro con ID: %s?";
    public static final String ELIMINAR_REGISTRO_MENSAJE_ELIMINADO = "El regitro con ID: %s se elimino correctamente.";

    public static final String ERROR_NO_USUARIO = "No existe el Usuario";
    public static final String ELIMINAR_REGISTRO_MENSAJE_ERROR = "Ocurrio un error al elimiar el registro con ID: %s.\nAsegurese de eliminar antes las referencias del registro.";

    // Etiqueta y su URL de iconos, imagenes de ItemTablaInfo.
    public static final String ICON_LABEL_ALMACENES = "Productos";
    public static final String ICON_URL_ALMACENES = "/recursos/iconos/icono_productos.png";
    public static final String ICON_LABEL_CLIENTES = "Clientes";
    public static final String ICON_URL_CLIENTES = "/recursos/iconos/icono_clientes.png";
    public static final String IMAGE_URL_CLIENTES = "/recursos/imgItemsTablaInfo/imagen_cliente.png";
    public static final String ICON_LABEL_CONTRATOS = "Contratos";
    public static final String ICON_URL_CONTRATOS = "/recursos/iconos/icono_contratos.png";
    public static final String IMAGE_URL_CONTRATOS_ESTADO_VALIDADO = "/recursos/imgItemsTablaInfo/imagen_contrato_validado.png";
    public static final String IMAGE_URL_CONTRATOS_ESTADO_RECHAZADO = "/recursos/imgItemsTablaInfo/imagen_contrato_rechazado.png";
    public static final String IMAGE_URL_CONTRATOS_ESTADO_OTRO = "/recursos/imgItemsTablaInfo/imagen_contrato_otro.png";
    public static final String ICON_LABEL_FACTURAS = "Facturas";
    public static final String ICON_URL_FACTURAS = "/recursos/iconos/icono_facturas.png";
    public static final String ICON_LABEL_PEDIDOS = "Pedidos";
    public static final String ICON_URL_PEDIDOS = "/recursos/iconos/icono_pedidos.png";
    public static final String ICON_LABEL_TICKETS = "Tickets";
    public static final String ICON_URL_TICKETS = "/recursos/iconos/icono_tickets.png";
    public static final String IMAGE_URL_TICKETS = "/recursos/imgItemsTablaInfo/imagen_ticket.png";
    public static final String ICON_LABEL_USUARIOS = "Usuarios";
    public static final String ICON_URL_USUARIOS = "/recursos/iconos/icono_usuarios.png";
    public static final String IMAGE_URL_USUARIOS = "/recursos/imgItemsTablaInfo/imagen_usuario.png";

    public static final String ICON_LABEL_CREAR = "Crear";
    public static final String ICON_URL_CREAR = "/recursos/iconos/icono_crear.png";
    public static final String ICON_LABEL_GUARDAR = "Guardar";
    public static final String ICON_URL_GUARDAR = "/recursos/iconos/icono_guardar.png";
    public static final String ICON_LABEL_EDITAR = "Editar";
    public static final String ICON_URL_EDITAR = "/recursos/iconos/icono_editar.png";
    public static final String ICON_LABEL_ELIMINAR = "Eliminar";
    public static final String ICON_URL_ELIMINAR = "/recursos/iconos/icono_eliminar.png";
    public static final String ICON_LABEL_VALIDAR = "Validar";
    public static final String ICON_URL_VALIDAR = "/recursos/iconos/icono_validar.png";
    public static final String ICON_LABEL_VER_TODOS = "Ver Todos";
    public static final String ICON_URL_VER_TODOS = "/recursos/iconos/icono_ver_todos.png";
    public static final String ICON_LABEL_ASIGNADOS = "Asignados";
    public static final String ICON_URL_ASIGNADOS = "/recursos/iconos/icono_asignados.png";
    
    public static final String DELIMITADOR_DIRECCCION = ",";

    public static Map<String, String> getBotonesSubMenu() {
        Map<String, String> botonesSubMenu = new HashMap<>();
        botonesSubMenu.put(ICON_LABEL_ASIGNADOS, ICON_URL_ASIGNADOS);
        botonesSubMenu.put(ICON_LABEL_CREAR, ICON_URL_CREAR);
        botonesSubMenu.put(ICON_LABEL_VALIDAR, ICON_URL_VALIDAR);
        botonesSubMenu.put(ICON_LABEL_VER_TODOS, ICON_URL_VER_TODOS);
        return botonesSubMenu;
    }
    
    // Formato para mostrar en TablaInfo
    public static final String FORMATO_USUARIO_TO_STRING = ""
            + "ID: %s\n"
            + "FECHA CREACIÓN: %s\n"
            + "FECHA MODIFICACIÓN: %s\n"
            + "NOMBRE: %s\n"
            + "TELEFONO: %s\n"
            + "CORREO: %s\n"
            + "AREA: %s\n"
            + "-----------------\n"
            + "DIRECCION:\n"
            + "%s\n"
            + "-----------------";
    
    public static final String FORMATO_CONTRATO_TO_STRING = ""
            + "ID: %s\n"
            + "FECHA CREACIÓN: %s\n"
            + "FECHA MODIFICACIÓN: %s\n"
            + "CLIENTE: %s\n"
            + "INICIO: %s\n"
            + "TIPO: %s\n"
            + "ESTADO: %s\n"
            + "MESES: %s\n"
            + "DIA DE CORTE: %s\n"
            + "FORMA DE PAGO: %s\n"
            + "TIPO DE IMPRESORAS: %s\n"
            + "TIPO DE TONERS: %s\n"
            + "RENTA MENSUAL: %s\n"
            + "BOLSA B/N: %s\n"
            + "BOLSA COLOR: %s\n"
            + "CLICK BN: %.2f\n"
            + "CLICK COLOR: %.2f";
    
    public static final String FORMATO_CLIENTE_TO_STRING = ""
            + "ID: %s\n"
            + "FECHA CREACIÓN: %s\n"
            + "FECHA MODIFICACIÓN: %s\n"
            + "NOMBRE: %s\n"
            + "TELEFONO: %s\n"
            + "CORREO: %s\n"
            + "NIVEL: %s\n"
            + "-----------------\n"
            + "DIRECCION:\n"
            + "%s\n"
            + "-----------------";
    
    public static final String FORMATO_TICKET_TO_STRING = ""
            + "ID: %s\n"
            + "FECHA CREACIÓN: %s\n"
            + "FECHA MODIFICACIÓN: %s\n"
            + "PRIORIDAD: %s\n"
            + "ESTADO: %s\n"
            + "TIPO: %s\n"
            + "AREA ASIGNADA: %s\n"
            + "USUARIO ASIGNADO: %s\n"
            + "PEDIDO CON ID: %s\n"
            + "DESCRIPCIÓN: %s";
}
