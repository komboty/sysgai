package basedatos.utils;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public final class ConstantesBD {

    // Configuracion
    public static final String HOST = "localhost";
    public static final String PUERTO = "5432";
    public static final String NOMBRE = "sysgai";
    public static final String URL = "jdbc:postgresql://" + HOST + ":" + PUERTO + "/" + NOMBRE;
    public static final String USUARIO = "odoo";
    public static final String CONTRASENIA = "odoo";

    // Tablas 
    // (N_T_) Nombre de tabla (T_) Tabla (C_) Columna
    public static final String N_T_AREA = "Area";
    public static final String T_AREA_C_ID = "idArea";
    public static final String T_AREA_C_FECHA_CREACION = "fechaCreacionArea";
    public static final String T_AREA_C_FECHA_MODIFICACION = "fechaModificacionArea";
    public static final String T_AREA_C_NOMBRE = "nombreArea";

    public static final String N_T_USUARIO = "Usuario";
    public static final String T_USUARIO_C_ID = "idUsuario";
    public static final String T_USUARIO_C_ID_AREA = "idArea";
    public static final String T_USUARIO_C_FECHA_CREACION = "fechaCreacionUsuario";
    public static final String T_USUARIO_C_FECHA_MODIFICACION = "fechaModificacionUsuario";
    public static final String T_USUARIO_C_NOMBRE = "nombreUsuario";
    public static final String T_USUARIO_C_TELEFONO = "telefonoUsuario";
    public static final String T_USUARIO_C_MAIL = "mailUsuario";
    public static final String T_USUARIO_C_DIRECCION = "direccionUsuario";
    public static final String T_USUARIO_C_CONTRASENIA = "contraseniaUsuario";

    public static final String N_T_CLIENTE = "Cliente";
    public static final String T_CLIENTE_C_ID = "idCliente";
    public static final String T_CLIENTE_C_ID_TIPO_NIVEL_CLIENTE = "idTipoNivelCliente";
    public static final String T_CLIENTE_C_FECHA_CREACION = "fechaCreacionCliente";
    public static final String T_CLIENTE_C_FECHA_MODIFICACION = "fechaModificacionCliente";
    public static final String T_CLIENTE_C_NOMBRE = "nombreCliente";
    public static final String T_CLIENTE_C_TELEFONO = "telefonoCliente";
    public static final String T_CLIENTE_C_MAIL = "mailCliente";
    public static final String T_CLIENTE_C_DIRECCION = "direccionCliente";

    public static final String N_T_CONTRATO = "Contrato";
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

    public static final String N_T_PEDIDO = "Pedido";
    public static final String T_PEDIDO_C_ID = "idPedido";
    public static final String T_PEDIDO_C_ID_USUARIO = "idUsuario";
    public static final String T_PEDIDO_C_ID_CONTRATO = "idContrato";
    public static final String T_PEDIDO_C_ID_TIPO_ESTADO_PEDIDO = "idTipoEstadoPedido";
    public static final String T_PEDIDO_C_FECHA_CREACION = "fechaCreacionPedido";
    public static final String T_PEDIDO_C_FECHA_MODIFICACION = "fechaModificacionPedido";

    public static final String N_T_TICKET = "Ticket";
    public static final String T_TICKET_C_ID = "idTicket";
    public static final String T_TICKET_C_ID_TIPO_PRIORIDAD = "idTipoPrioridad";
    public static final String T_TICKET_C_ID_TIPO_ESTADO_TICKET = "idTipoEstadoTicket";
    public static final String T_TICKET_C_ID_TIPO_TICKET = "idTipoTicket";
    public static final String T_TICKET_C_ID_AREA = "idArea";
    public static final String T_TICKET_C_ID_USUARIO = "idUsuario";
    public static final String T_TICKET_C_ID_PEDIDO = "idPedido";
    public static final String T_TICKET_C_FECHA_CREACION = "fechaCreacionTicket";
    public static final String T_TICKET_C_FECHA_MODIFICACION = "fechaModificacionTicket";
    public static final String T_TICKET_C_DESCRIPCION = "descripcionTicket";

    public static final String N_T_FATCURA = "Factura";
    public static final String T_FATCURA_C_ID = "idFactura";
    public static final String T_FATCURA_C_ID_CONTRATO = "idContrato";
    public static final String T_FATCURA_C_ID_TIPO_ESTADO_FACTURA = "idTipoEstadoFactura";
    public static final String T_FATCURA_C_FECHA_CREACION = "fechaCreacionFactura";
    public static final String T_FATCURA_C_FECHA_MODIFICACION = "fechaModificacionFactura";
    public static final String T_FATCURA_C_IMPUESTO = "impuestoFactura";
    public static final String T_FATCURA_C_COBRO = "cobroFactura";

    public static final String N_T_TIPO_NIVEL_CLIENTE = "TipoNivelCliente";
    public static final String T_TIPO_NIVEL_CLIENTE_C_ID = "idTipoNivelCliente";
    public static final String T_TIPO_NIVEL_CLIENTE_C_TIPO = "tipoNivelCliente";

    public static final String N_T_TIPO_CONTRATO = "TipoContrato";
    public static final String T_TIPO_CONTRATO_C_ID = "idTipoContrato";
    public static final String T_TIPO_CONTRATO_C_TIPO = "tipoContrato";

    public static final String N_T_TIPO_PAGO = "TipoPago";
    public static final String T_TIPO_PAGO_C_ID = "idTipoPago";
    public static final String T_TIPO_PAGO_C_TIPO = "tipoPago";

    public static final String N_T_TIPO_TONER = "TipoToner";
    public static final String T_TIPO_TONER_C_ID = "idTipoToner";
    public static final String T_TIPO_TONER_C_TIPO = "tipoToner";

    public static final String N_T_TIPO_ESTADO_PRODUCTO = "TipoEstadoProducto";
    public static final String T_TIPO_ESTADO_PRODUCTO_C_ID = "idTipoEstadoProducto";
    public static final String T_TIPO_ESTADO_PRODUCTO_C_TIPO = "tipoEstadoProducto";

    public static final String N_T_TIPO_ESTADO_CONTRATO = "TipoEstadoContrato";
    public static final String T_TIPO_ESTADO_CONTRATO_C_ID = "idTipoEstadoContrato";
    public static final String T_TIPO_ESTADO_CONTRATO_C_TIPO = "tipoEstadoContrato";

    public static final String N_T_TIPO_ESTADO_FACTURA = "TipoEstadoFactura";
    public static final String T_TIPO_ESTADO_FACTURA_C_ID = "idTipoEstadoFactura";
    public static final String T_TIPO_ESTADO_FACTURA_C_TIPO = "tipoEstadoFactura";
    
    public static final String N_T_TIPO_PRIORIDAD = "TipoPrioridad";
    public static final String T_TIPO_PRIORIDAD_C_ID = "idTipoPrioridad";
    public static final String T_TIPO_PRIORIDAD_C_TIPO = "tipoPrioridad";
    
    public static final String N_T_TIPO_ESTADO_TICKET = "TipoEstadoTicket";
    public static final String T_TIPO_ESTADO_TICKET_C_ID = "idTipoEstadoTicket";
    public static final String T_TIPO_ESTADO_TICKET_C_TIPO = "tipoEstadoTicket";
    
    public static final String N_T_TIPO_TICKET = "TipoTicket";
    public static final String T_TIPO_TICKET_C_ID = "idTipoTicket";
    public static final String T_TIPO_TICKET_C_TIPO = "tipoTicket";
}
