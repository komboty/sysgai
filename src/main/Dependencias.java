package main;

import basedatos.ConexionBD;
import basedatos.ConexionBDImpl;
import basedatos.daos.implementaciones.ClienteDAOImpl;
import basedatos.daos.implementaciones.ContratoDAOImpl;
import basedatos.daos.implementaciones.UsuarioDAOImpl;
import basedatos.daos.interfaces.ClienteDAO;
import basedatos.daos.interfaces.ContratoDAO;
import basedatos.daos.interfaces.UsuarioDAO;
import servicios.implementaciones.ClienteServicioImpl;
import servicios.implementaciones.ContratoServicioImpl;
import servicios.implementaciones.UsuarioServicioImpl;
import servicios.interfaces.ClienteServicio;
import servicios.interfaces.ContratoServicio;
import servicios.interfaces.UsuarioServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Dependencias {

    private static ConexionBD conexionBD;
    private static UsuarioDAO usuarioDAO;
    private static ClienteDAO clienteDAO;
    private static ContratoDAO contratoDAO;
    private static UsuarioServicio usuarioServicio;
    private static ClienteServicio clienteServicio;
    private static ContratoServicio contratoServicio;

    public static void Inicializa() {
        Dependencias.conexionBD = new ConexionBDImpl();
        Dependencias.usuarioDAO = new UsuarioDAOImpl(conexionBD);
        Dependencias.clienteDAO = new ClienteDAOImpl(conexionBD);
        Dependencias.contratoDAO = new ContratoDAOImpl(conexionBD);
        Dependencias.usuarioServicio = new UsuarioServicioImpl(usuarioDAO);
        Dependencias.clienteServicio = new ClienteServicioImpl(clienteDAO);
        Dependencias.contratoServicio = new ContratoServicioImpl(contratoDAO);
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

}
