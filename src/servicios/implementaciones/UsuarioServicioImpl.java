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
    public Usuario identificar(String mail, String contrasenia) {
        return usuarioDAO.getPorMailYContrasenia(mail, contrasenia);
    }

    @Override
    public List<Usuario> getTodos() {
        return usuarioDAO.getTodos();
    }

}
