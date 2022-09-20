package modelo.utils;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public final class Constantes {

    // Vista
    public static final String VISTA_TITULO_SISTEMA = "SYSGAI";
    public static final String VISTA_URL_LOGIN = "/vistas/loginVista.fxml";
    public static final String VISTA_URL_MENU = "/vistas/menuVista.fxml";
    
    public static final String VISTA_ERROR_NO_USUARIO = "No existe el Usuario";
    
    
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
}
