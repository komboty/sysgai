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
    public static final double VISTA_STAGE_ANCHO = 1200;
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

    // Mensajes de la vista.
    public static final String VISTA_ELIMINAR_REGISTRO_TITULO = "Eliminar registro";
    public static final String VISTA_ELIMINAR_REGISTRO_MENSAJE_CONFIRMACION = "Esta seguro de eliminar el registro con ID: %s?";
    public static final String VISTA_ELIMINAR_REGISTRO_MENSAJE_ELIMINADO = "El regitro con ID: %s se elimino correctamente.";

    public static final String VISTA_ERROR_NO_USUARIO = "No existe el Usuario";
    public static final String VISTA_ELIMINAR_REGISTRO_MENSAJE_ERROR = "Ocurrio un error al elimiar el registro con ID: %s.\nAsegurese de eliminar antes las referencias del registro.";

    // Formato
    public static final String VISTA_FECHA_FORMATO = "dd/MM/yyyy HH:mm";

    // Etiqueta y su URL de iconos, imagenes de ItemTablaInfo.
    public static final String VISTA_ICON_LABEL_ALMACENES = "Productos";
    public static final String VISTA_ICON_URL_ALMACENES = "/recursos/iconos/icono_productos.png";
    public static final String VISTA_ICON_LABEL_CLIENTES = "Clientes";
    public static final String VISTA_ICON_URL_CLIENTES = "/recursos/iconos/icono_clientes.png";
    public static final String VISTA_IMAGE_URL_CLIENTES = "/recursos/imgItemsTablaInfo/imagen_cliente.png";
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
    public static final String VISTA_IMAGE_URL_USUARIOS = "/recursos/imgItemsTablaInfo/imagen_usuario.png";

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
     * Areas de la Empresa
     * ----------------------------------------------------------------------------------------------
     */
    public static final String AREA_ARRENDAMIENTO = "Arrendamiento";
    public static final String AREA_ABOGADOS = "Abogados";
    public static final String AREA_CONTADORES = "Contadores";
    public static final String AREA_TECNICOS = "Técnicos";
    public static final String AREA_MESA_DE_SERVICIO = "Mesa de servicio";
    public static final String AREA_ALMACEN = "Almacén";
    public static final String AREA_DISTRIBUCION = "Distribución";
    public static final String AREA_ADMINISTRACION = "Administración";

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

    public static final String DELIMITADOR_DIRECCCION = ",";

    // Tablas 
    // (DB_N_T_) Nombre de tabla (T_) Tabla (C_) Columna
    public static final String DB_N_T_AREA = "Area";
    public static final String T_AREA_C_ID = "idArea";
    public static final String T_AREA_C_FECHA_CREACION = "fechaCreacionArea";
    public static final String T_AREA_C_FECHA_MODIFICACION = "fechaModificacionArea";
    public static final String T_AREA_C_NOMBRE = "nombreArea";

    public static final String DB_N_T_USUARIO = "Usuario";
    public static final String T_USUARIO_C_ID = "idUsuario";
    public static final String T_USUARIO_C_ID_AREA = "idArea";
    public static final String T_USUARIO_C_FECHA_CREACION = "fechaCreacionUsuario";
    public static final String T_USUARIO_C_FECHA_MODIFICACION = "fechaModificacionUsuario";
    public static final String T_USUARIO_C_NOMBRE = "nombreUsuario";
    public static final String T_USUARIO_C_TELEFONO = "telefonoUsuario";
    public static final String T_USUARIO_C_MAIL = "mailUsuario";
    public static final String T_USUARIO_C_DIRECCION = "direccionUsuario";
    public static final String T_USUARIO_C_CONTRASENIA = "contraseniaUsuario";

    public static final String DB_N_T_CLIENTE = "Cliente";
    public static final String T_CLIENTE_C_ID = "idCliente";
    public static final String T_CLIENTE_C_ID_TIPO_NIVEL_CLIENTE = "idTipoNivelCliente";
    public static final String T_CLIENTE_C_FECHA_CREACION = "fechaCreacionCliente";
    public static final String T_CLIENTE_C_FECHA_MODIFICACION = "fechaModificacionCliente";
    public static final String T_CLIENTE_C_NOMBRE = "nombreCliente";
    public static final String T_CLIENTE_C_TELEFONO = "telefonoCliente";
    public static final String T_CLIENTE_C_MAIL = "mailCliente";
    public static final String T_CLIENTE_C_DIRECCION = "direccionCliente";

    public static final String DB_N_T_CONTRATO = "Contrato";
    public static final String T_CONTRATO_C_ID = "idContrato";
    public static final String T_CONTRATO_C_ID_CLIENTE = "idCliente";
    public static final String T_CONTRATO_C_ID_TIPO_CONTRATO = "idTipoContrato";
    public static final String T_CONTRATO_C_ID_TIPO_PAGO = "idTipoPago";
    public static final String T_CONTRATO_C_ID_TIPO_TONER = "idTipoToner";
    public static final String T_CONTRATO_C_ID_TIPO_ESTADO_PRODUCTO = "idTipoEstadoProducto";
    public static final String T_CONTRATO_C_ID_TIPO_ESTADO_CONTRATO = "idTipoEstadoContrato";
    public static final String T_CONTRATO_C_FECHA_CREACION = "fechaCreacionContrato";
    public static final String T_CONTRATO_C_FECHA_MODIFICACION = "fechaModificacionContrato";
    public static final String T_CONTRATO_C_INICIO_CONTRATO = "inicioContrato";
    public static final String T_CONTRATO_C_MESES_CONTRATO = "mesesContrato";
    public static final String T_CONTRATO_C_DIA_CORTE = "diaCorteContrato";
    public static final String T_CONTRATO_C_RENTA_MENSUAL = "rentaMensualContrato";
    public static final String T_CONTRATO_C_BOLSA_BN = "bolsaBNContrato";
    public static final String T_CONTRATO_C_BOLSA_COLOR = "bolsaColorContrato";
    public static final String T_CONTRATO_C_CLICK_BN = "clickBNContrato";
    public static final String T_CONTRATO_C_CLICK_COLOR = "clickColorContrato";

    public static final String DB_N_T_FATCURA = "Factura";
    public static final String T_FATCURA_C_ID = "idFactura";
    public static final String T_FATCURA_C_ID_CONTRATO = "idContrato";
    public static final String T_FATCURA_C_ID_TIPO_ESTADO_FACTURA = "idTipoEstadoFactura";
    public static final String T_FATCURA_C_FECHA_CREACION = "fechaCreacionFactura";
    public static final String T_FATCURA_C_FECHA_MODIFICACION = "fechaModificacionFactura";
    public static final String T_FATCURA_C_IMPUESTO = "impuestoFactura";
    public static final String T_FATCURA_C_COBRO = "cobroFactura";

    public static final String DB_N_T_TIPO_NIVEL_CLIENTE = "TipoNivelCliente";
    public static final String T_TIPO_NIVEL_CLIENTE_C_ID = "idTipoNivelCliente";
    public static final String T_TIPO_NIVEL_CLIENTE_C_TIPO = "tipoNivelCliente";

    public static final String DB_N_T_TIPO_CONTRATO = "TipoContrato";
    public static final String T_TIPO_CONTRATO_C_ID = "idTipoContrato";
    public static final String T_TIPO_CONTRATO_C_TIPO = "tipoContrato";

    public static final String DB_N_T_TIPO_PAGO = "TipoPago";
    public static final String T_TIPO_PAGO_C_ID = "idTipoPago";
    public static final String T_TIPO_PAGO_C_TIPO = "tipoPago";

    public static final String DB_N_T_TIPO_TONER = "TipoToner";
    public static final String T_TIPO_TONER_C_ID = "idTipoToner";
    public static final String T_TIPO_TONER_C_TIPO = "tipoToner";

    public static final String DB_N_T_TIPO_ESTADO_PRODUCTO = "TipoEstadoProducto";
    public static final String T_TIPO_ESTADO_PRODUCTO_C_ID = "idTipoEstadoProducto";
    public static final String T_TIPO_ESTADO_PRODUCTO_C_TIPO = "tipoEstadoProducto";

    public static final String DB_N_T_TIPO_ESTADO_CONTRATO = "TipoEstadoContrato";
    public static final String T_TIPO_ESTADO_CONTRATO_C_ID = "idTipoEstadoContrato";
    public static final String T_TIPO_ESTADO_CONTRATO_C_TIPO = "tipoEstadoContrato";

    public static final String DB_N_T_TIPO_ESTADO_FACTURA = "TipoEstadoFactura";
    public static final String T_TIPO_ESTADO_FACTURA_C_ID = "idTipoEstadoFactura";
    public static final String T_TIPO_ESTADO_FACTURA_C_TIPO = "tipoEstadoFactura";

}
