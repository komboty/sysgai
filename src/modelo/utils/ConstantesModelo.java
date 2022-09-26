package modelo.utils;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public final class ConstantesModelo {

    // Areas de la Empresa
    public static final String AREA_ARRENDAMIENTO = "Arrendamiento";
    public static final String AREA_ABOGADOS = "Abogados";
    public static final String AREA_CONTADORES = "Contadores";
    public static final String AREA_TECNICOS = "Técnicos";
    public static final String AREA_MESA_DE_SERVICIO = "Mesa de servicio";
    public static final String AREA_ALMACEN = "Almacén";
    public static final String AREA_DISTRIBUCION = "Distribución";
    public static final String AREA_ADMINISTRACION = "Administración";

    // Estados de un Contrato
    public static final String ESTADO_CONTRATO_EN_VALIDACION = "En validación";
    public static final String ESTADO_CONTRATO_VALIDADO = "Validado";
    public static final String ESTADO_CONTRATO_RECHAZADO = "Rechazado";
    
    // Filtros
    public static final String FILTRO_ASIGNADOS = "Asignados";

    // Formato
    public static final String FORMATO_VISTA_FECHA = "dd/MM/yyyy HH:mm";
    
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
