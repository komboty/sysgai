package servicios.interfaces;

import modelo.entidades.Usuario;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface UsuarioServicio extends GenericServicio<Usuario> {

    /**
     * Identifica si hay un usuario con el mail y contraseña en el sistema.
     *
     * @param mail Correo de usuario a identificar.
     * @param contrasenia Contraseña de usuario a identificar.
     * @return Un Usuario, si es que existe en la base de datos.
     */
    public Usuario identificar(String mail, String contrasenia);
}
