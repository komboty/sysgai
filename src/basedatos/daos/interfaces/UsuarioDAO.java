package basedatos.daos.interfaces;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface UsuarioDAO<T> extends GenericDAO<T> {

    /**
     * Identifica si hay un usuario con el mail y contraseña en la base de
     * datos.
     *
     * @param mail
     * @param contrasenia
     * @return Un Usuario, si es que existe en la base de datos.
     */
    public T getPorMailYContrasenia(String mail, String contrasenia);

}
