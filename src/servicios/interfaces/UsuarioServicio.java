package servicios.interfaces;

import servicios.dtos.UsuarioDTO;
import servicios.dtos.UsuarioLogueadoDTO;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface UsuarioServicio extends GenericServicio<UsuarioDTO> {

    /**
     * Identifica si hay un usuario con el mail y contraseña en el sistema.
     *
     * @param mail Correo de usuario a identificar.
     * @param contrasenia Contraseña de usuario a identificar.
     * @return Un Usuario, si es que existe en la base de datos.
     */
    public UsuarioLogueadoDTO iniciarSesion(String mail, String contrasenia);

    public UsuarioDTO crearUsuario(int idArea, String nombre, String telefono, String mail, 
            String direccion, String contrasenia);
}
