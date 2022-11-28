package main;

import persistencia.ConexionBD;
import persistencia.ConexionBDImpl;
import persistencia.daos.implementaciones.ClienteDAOImpl;
import persistencia.daos.implementaciones.ContratoDAOImpl;
import persistencia.daos.implementaciones.TicketDAOImpl;
import persistencia.daos.implementaciones.UsuarioDAOImpl;
import persistencia.daos.interfaces.ClienteDAO;
import persistencia.daos.interfaces.ContratoDAO;
import persistencia.daos.interfaces.TicketDAO;
import persistencia.daos.interfaces.UsuarioDAO;
import servicios.implementaciones.ClienteServicioImpl;
import servicios.implementaciones.ContratoServicioImpl;
import servicios.implementaciones.TicketServicioImpl;
import servicios.implementaciones.UsuarioServicioImpl;
import servicios.interfaces.ClienteServicio;
import servicios.interfaces.ContratoServicio;
import servicios.interfaces.TicketServicio;
import servicios.interfaces.UsuarioServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Dependencias {
    // Conexion a la base de datos
    private static ConexionBD conexionBD;
    // DAO's
    private static UsuarioDAO usuarioDAO;
    private static ClienteDAO clienteDAO;
    private static ContratoDAO contratoDAO;
    private static TicketDAO ticketDAO;
    // Servicios
    private static UsuarioServicio usuarioServicio;
    private static ClienteServicio clienteServicio;
    private static ContratoServicio contratoServicio;
    private static TicketServicio ticketServicio;

    public static void Inicializa() {
        Dependencias.conexionBD = new ConexionBDImpl();

        Dependencias.usuarioDAO = new UsuarioDAOImpl(conexionBD);
        Dependencias.clienteDAO = new ClienteDAOImpl(conexionBD);
        Dependencias.contratoDAO = new ContratoDAOImpl(conexionBD);
        Dependencias.ticketDAO = new TicketDAOImpl(conexionBD);

        Dependencias.usuarioServicio = new UsuarioServicioImpl(usuarioDAO);
        Dependencias.clienteServicio = new ClienteServicioImpl(clienteDAO);
        Dependencias.contratoServicio = new ContratoServicioImpl(contratoDAO);
        Dependencias.ticketServicio = new TicketServicioImpl(ticketDAO);
    }

    public static ConexionBD getConexionBD() {
        return conexionBD;
    }

    public static UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public static ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public static ContratoDAO getContratoDAO() {
        return contratoDAO;
    }

    public static UsuarioServicio getUsuarioServicio() {
        return usuarioServicio;
    }

    public static ClienteServicio getClienteServicio() {
        return clienteServicio;
    }

    public static ContratoServicio getContratoServicio() {
        return contratoServicio;
    }

    public static TicketDAO getTicketDAO() {
        return ticketDAO;
    }

    public static TicketServicio getTicketServicio() {
        return ticketServicio;
    }
}
