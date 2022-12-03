package persistencia.daos.interfaces;

import modelo.entidades.Usuario;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface UsuarioDAO extends GenericDAO<Usuario> {

    /**
     * Identifica si hay un usuario con el mail y contraseña en la base de
     * datos.
     *
     * @param mail
     * @param contrasenia
     * @return Un Usuario, si es que existe en la base de datos.
     */
    public Usuario getPorMailYContrasenia(String mail, String contrasenia);

}
