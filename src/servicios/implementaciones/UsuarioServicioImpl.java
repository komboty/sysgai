package servicios.implementaciones;

import basedatos.daos.interfaces.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Usuario;
import modelo.utils.UtilsModelo;
import servicios.dtos.UsuarioDTO;
import servicios.dtos.UsuarioLogueadoDTO;
import servicios.dtos.ObjectToStringDTO;
import servicios.interfaces.UsuarioServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UsuarioServicioImpl implements UsuarioServicio<ObjectToStringDTO, UsuarioDTO, UsuarioLogueadoDTO> {

    private UsuarioDAO usuarioDAO;

    public UsuarioServicioImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public UsuarioLogueadoDTO iniciarSesion(String mail, String contrasenia) {
        Usuario usuario = (Usuario) usuarioDAO.getPorMailYContrasenia(mail, contrasenia);
        // Si no existe el usuario.
        if (usuario == null) {
            return null;
        }
        //Si existe el usuario.
        UsuarioLogueadoDTO usuarioLogueadoDTO = new UsuarioLogueadoDTO();
        usuarioLogueadoDTO.setIdUsuario(usuario.getId());
        usuarioLogueadoDTO.setNombreArea(usuario.getArea().getNombre());
        return usuarioLogueadoDTO;
    }

    @Override
    public List<ObjectToStringDTO> getTodos(String filtro, String valor) {
        List<Usuario> usuarios = usuarioDAO.getTodos();
        List<ObjectToStringDTO> objectToStringDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            objectToStringDTO.add(UtilsModelo.usuarioToObjectToStringDTO(usuario));
        }
        return objectToStringDTO;
    }

    @Override
    public boolean eliminarPorId(int id) {
        return usuarioDAO.eliminarPorId(id);
    }

    @Override
    public UsuarioDTO crearUsuario(int idArea, String nombre, String telefono, String mail, String direccion, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
