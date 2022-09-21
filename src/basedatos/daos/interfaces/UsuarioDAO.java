package basedatos.daos.interfaces;

import basedatos.ConexionBD;
import java.util.List;
import modelo.clases.Usuario;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface UsuarioDAO {

    /**
     * Identifica si hay un usuario con el mail y contraseña en la base de
     * datos.
     *
     * @param mail Correo de usuario a identificar.
     * @param contrasenia Contraseña de usuario a identificar.
     * @return Un Usuario, si es que existe en la base de datos.
     */
    public Usuario getUsuario(String mail, String contrasenia);
    
    public List<Usuario> getAllUsuario();
}
