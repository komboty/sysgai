package servicios.implementaciones;

import basedatos.daos.implementaciones.UsuarioDAOImpl;
import basedatos.daos.interfaces.UsuarioDAO;
import java.util.List;
import modelo.clases.Usuario;
import servicios.interfaces.UsuarioServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UsuarioServicioImpl implements UsuarioServicio {

    private static UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    public UsuarioServicioImpl() {}    

    @Override
    public Usuario identificar(String mail, String contrasenia) {
        return usuarioDAO.getPorMailYContrasenia(mail, contrasenia);
    }

    @Override
    public List<Usuario> getTodos() {
        return usuarioDAO.getTodos();
    }

}
