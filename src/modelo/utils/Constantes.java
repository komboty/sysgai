package modelo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public final class Constantes {

    /**
     * ----------------------------------------------------------------------------------------------
     * Vistas
     * ----------------------------------------------------------------------------------------------
     */
    // Configuracion
    public static final String VISTA_TITULO_SISTEMA = "SYSGAI";
    public static final double VISTA_STAGE_ALTO = 600;
    public static final double VISTA_STAGE_ANCHO = 800;
    public static final double VISTA_VENTANA_ALTO_AJUSTE = 36;
    public static final double VISTA_VENTANA_ANCHO_AJUSTE = 10;
    public static final double VISTA_VENTANA_ALTO = VISTA_STAGE_ALTO - VISTA_VENTANA_ALTO_AJUSTE;
    public static final double VISTA_VENTANA_ANCHO = VISTA_STAGE_ANCHO - VISTA_VENTANA_ANCHO_AJUSTE;
    public static final double VISTA_MENU_ANCHO = 120;
    public static final double VISTA_SUB_VENTANA_ANCHO = VISTA_VENTANA_ANCHO - (VISTA_MENU_ANCHO * 2);
    public static final double VISTA_SUB_VENTANA_ALTO = VISTA_VENTANA_ALTO;
    public static final String VISTA_VENTANA_COLOR_1 = "#997A79";
    public static final String VISTA_VENTANA_COLOR_2 = "#E4E6B5";
    public static final String VISTA_VENTANA_COLOR_3 = "#E5CDCC";
    public static final String VISTA_VENTANA_COLOR_4 = "#B5D0E6";
    public static final String VISTA_VENTANA_COLOR_5 = "#818E99";
    public static final String VISTA_MENU_COLOR_FONDO = VISTA_VENTANA_COLOR_4;
    public static final String VISTA_MENU_COLOR_MOUSE_ENTRA = VISTA_VENTANA_COLOR_5;
    public static final String VISTA_MENU_COLOR_MOUSE_CLICK = VISTA_VENTANA_COLOR_2;

    // URL de FXML de vistas
    public static final String VISTA_URL_LOGIN = "/vistas/login/loginVista.fxml";
    public static final String VISTA_URL_PRINCIPAL = "/vistas/principal/principalVista.fxml";
//    public static final String VISTA_URL_ALMACENES = "/vistas/principal/almacenesVista.fxml";
//    public static final String VISTA_URL_CLIENTES = "/vistas/principal/clientesVista.fxml";
//    public static final String VISTA_URL_CONTRATOS = "/vistas/principal/contratosVista.fxml";
//    public static final String VISTA_URL_FACTURAS = "/vistas/principal/facturasVista.fxml";
//    public static final String VISTA_URL_PEDIDOS = "/vistas/principal/pedidosVista.fxml";
//    public static final String VISTA_URL_TICKETS = "/vistas/principal/ticketsVista.fxml";
//    public static final String VISTA_URL_USUARIOS = "/vistas/usuarios/usuariosVista.fxml";
    public static final String VISTA_URL_BOTON_IMAGEN = "/vistas/utils/botonImagen.fxml";
    public static final String VISTA_URL_ITEM_TABLA_INFO = "/vistas/vertodos/itemTablaInfo.fxml";
    public static final String VISTA_URL_TABLA_INFO = "/vistas/vertodos/tablaInfo.fxml";

    // Mensajes de error
    public static final String VISTA_ERROR_NO_USUARIO = "No existe el Usuario";

    // URL de iconos y su etiqueta.
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
    public static final String VISTA_ICON_LABEL_GUARDAR = "Guardar";
    public static final String VISTA_ICON_URL_GUARDAR = "/recursos/iconos/icono_guardar.png";
    public static final String VISTA_ICON_LABEL_EDITAR = "Editar";
    public static final String VISTA_ICON_URL_EDITAR = "/recursos/iconos/icono_editar.png";
    public static final String VISTA_ICON_LABEL_ELIMINAR = "Eliminar";
    public static final String VISTA_ICON_URL_ELIMINAR = "/recursos/iconos/icono_eliminar.png";
    public static final String VISTA_ICON_LABEL_VALIDAR = "Validar";
    public static final String VISTA_ICON_URL_VALIDAR = "/recursos/iconos/icono_validar.png";
    public static final String VISTA_ICON_LABEL_VER_TODOS = "Ver Todos";
    public static final String VISTA_ICON_URL_VER_TODOS = "/recursos/iconos/icono_ver_todos.png";

    public static Map<String, String> getBotonesSubMenu() {
        Map<String, String> botonesSubMenu = new HashMap<String, String>();
        botonesSubMenu.put(VISTA_ICON_LABEL_CREAR, VISTA_ICON_URL_CREAR);
        botonesSubMenu.put(VISTA_ICON_LABEL_VALIDAR, VISTA_ICON_URL_VALIDAR);
        botonesSubMenu.put(VISTA_ICON_LABEL_VER_TODOS, VISTA_ICON_URL_VER_TODOS);
        return botonesSubMenu;
    }

    /**
     * ----------------------------------------------------------------------------------------------
     * Tipos de Usuario
     * ----------------------------------------------------------------------------------------------
     */
    public static final String TIPO_USUARIO_ARRENDADOR = "Arrendador";
    public static final String TIPO_USUARIO_ABOGADO = "Abogado";
    public static final String TIPO_USUARIO_CONTADOR = "Contador";
    public static final String TIPO_USUARIO_TECNICO = "Técnico";
    public static final String TIPO_USUARIO_MESA = "Mesa de servicio";
    public static final String TIPO_USUARIO_CHOFER = "Chofer";
    public static final String TIPO_USUARIO_ALMACENISTA = "Almacenista";
    public static final String TIPO_USUARIO_ADMINISTRADOR = "Administrador";

    /**
     * ----------------------------------------------------------------------------------------------
     * Base de datos
     * ----------------------------------------------------------------------------------------------
     */
    // Configuracion
    public static final String DB_HOST = "localhost";
    public static final String DB_PUERTO = "5432";
    public static final String DB_NOMBRE = "sysgai";
    public static final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PUERTO + "/" + DB_NOMBRE;
    public static final String DB_USUARIO = "odoo";
    public static final String DB_CONTRASENIA = "odoo";

    // Tablas 
    // (DB_N_T_) Nombre de tabla (T_) Tabla (C_) Columna
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

    public static final String DB_N_T_CLIENTE = "Cliente";
    public static final String T_CLIENTE_C_ID = "id";
    public static final String T_CLIENTE_C_ID_TIPO_NIVEL_CLIENTE = "idTipoNivelCliente";
    public static final String T_CLIENTE_C_FECHA_CREACION = "fechaCreacion";
    public static final String T_CLIENTE_C_FECHA_MODIFICACION = "fechaModificacion";
    public static final String T_CLIENTE_C_NOMBRE = "nombre";
    public static final String T_CLIENTE_C_TELEFONO = "telefono";
    public static final String T_CLIENTE_C_MAIL = "mail";
    public static final String T_CLIENTE_C_DIRECCION = "direccion";

    public static final String DB_N_T_CONTRATO = "Contrato";
    public static final String T_CONTRATO_C_ID = "id";
    public static final String T_CONTRATO_C_ID_CLIENTE = "idCliente";
    public static final String T_CONTRATO_C_ID_TIPO_CONTRATO = "idTipoContrato";
    public static final String T_CONTRATO_C_ID_TIPO_PAGO = "idTipoPago";
    public static final String T_CONTRATO_C_ID_TIPO_TONER = "idTipoToner";
    public static final String T_CONTRATO_C_ID_TIPO_ESTADO_IMPRESORA = "idTipoEstadoImpresora";
    public static final String T_CONTRATO_C_ID_TIPO_ESTADO_CONTRATO = "idTipoEstadoContrato";
    public static final String T_CONTRATO_C_FECHA_CREACION = "fechaCreacion";
    public static final String T_CONTRATO_C_FECHA_MODIFICACION = "fechaModificacion";
    public static final String T_CONTRATO_C_INICIO_CONTRATO = "inicioContrato";
    public static final String T_CONTRATO_C_MESES_CONTRATO = "mesesContrato";
    public static final String T_CONTRATO_C_DIA_CORTE = "diaCorte";
    public static final String T_CONTRATO_C_RENTA_MENSUAL = "rentaMensual";
    public static final String T_CONTRATO_C_BOLSA_BN = "bolsaBN";
    public static final String T_CONTRATO_C_BOLSA_COLOR = "bolsaColor";
    public static final String T_CONTRATO_C_CLICK_BN = "clickBN";
    public static final String T_CONTRATO_C_CLICK_COLOR = "clickColor";
    
    public static final String DB_N_T_FATCURA = "Factura";
    public static final String T_FATCURA_C_ID = "id";
    public static final String T_FATCURA_C_FECHA_CREACION = "fechaCreacion";
    public static final String T_FATCURA_C_FECHA_MODIFICACION = "fechaModificacion";

    public static final String DB_N_T_TIPO_USUARIO = "TipoUsuario";
    public static final String T_TIPO_USUARIO_C_ID = "id";
    public static final String T_TIPO_USUARIO_C_TIPO = "tipo";

    public static final String DB_N_T_TIPO_NIVEL_CLIENTE = "TipoNivelCliente";
    public static final String T_TIPO_NIVEL_CLIENTE_C_ID = "id";
    public static final String T_TIPO_NIVEL_CLIENTE_C_TIPO = "tipo";

    public static final String DB_N_T_TIPO_CONTRATO = "TipoContrato";
    public static final String T_TIPO_CONTRATO_C_ID = "id";
    public static final String T_TIPO_CONTRATO_C_TIPO = "tipo";

    public static final String DB_N_T_TIPO_PAGO = "TipoPago";
    public static final String T_TIPO_PAGO_C_ID = "id";
    public static final String T_TIPO_PAGO_C_TIPO = "tipo";

    public static final String DB_N_T_TIPO_TONER = "TipoToner";
    public static final String T_TIPO_TONER_C_ID = "id";
    public static final String T_TIPO_TONER_C_TIPO = "tipo";

    public static final String DB_N_T_TIPO_ESTADO_IMPRESORA = "TipoEstadoImpresora";
    public static final String T_TIPO_ESTADO_IMPRESORA_C_ID = "id";
    public static final String T_TIPO_ESTADO_IMPRESORA_C_TIPO = "tipo";
    
    public static final String DB_N_T_TIPO_ESTADO_CONTRATO = "TipoEstadoContrato";
    public static final String T_TIPO_ESTADO_CONTRATO_C_ID = "id";
    public static final String T_TIPO_ESTADO_CONTRATO_C_TIPO = "tipo";

}
