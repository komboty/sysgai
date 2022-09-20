package modelo.clases;

import basedatos.daos.implementacion.UsuarioDAOImpl;
import basedatos.daos.interfaces.UsuarioDAO;
import java.time.LocalDateTime;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Usuario extends Persona {

    private static UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    
    private String tipo;
    private String contrasenia;

    public Usuario(String mail, String contrasenia) {
        super(mail);
        this.contrasenia = contrasenia;
    }

    public Usuario(String tipo, String contrasenia, int id, LocalDateTime fechaCreacion,
            LocalDateTime fechaModificacion, String nombre, String telefono, String mail, String direccion) {

        super(id, fechaCreacion, fechaModificacion, nombre, telefono, mail, direccion);
        this.tipo = tipo;
        this.contrasenia = contrasenia;
    }

    public Usuario identificar() {
        return usuarioDAO.getUsuario(mail, contrasenia);
    }

    public String getTipo() {
        return tipo;
    }
}
