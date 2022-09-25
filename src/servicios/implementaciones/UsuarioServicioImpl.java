package servicios.implementaciones;

import basedatos.daos.interfaces.UsuarioDAO;
import java.util.List;
import modelo.entidades.Usuario;
import servicios.interfaces.UsuarioServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioDAO usuarioDAO;

    public UsuarioServicioImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public Usuario iniciarSesion(String mail, String contrasenia) {
        return usuarioDAO.getPorMailYContrasenia(mail, contrasenia);
    }

    @Override
    public List<Usuario> getTodos() {
        return usuarioDAO.getTodos();
    }

    @Override
    public boolean eliminarPorId(int id) {
        return usuarioDAO.eliminarPorId(id);
    }

    @Override
    public Usuario crearUsuario(int idArea, String nombre, String telefono, String mail, String direccion, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
