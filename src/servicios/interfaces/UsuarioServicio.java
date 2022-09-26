package servicios.interfaces;


/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface UsuarioServicio<T, K, V> extends GenericServicio<T> {

    /**
     * Identifica si hay un usuario con el mail y contraseña en el sistema.
     *
     * @param mail Correo de usuario a identificar.
     * @param contrasenia Contraseña de usuario a identificar.
     * @return Un Usuario, si es que existe en la base de datos.
     */
    public V iniciarSesion(String mail, String contrasenia);

    public K crearUsuario(int idArea, String nombre, String telefono, String mail,
            String direccion, String contrasenia);
}
