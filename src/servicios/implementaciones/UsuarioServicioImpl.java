package servicios.implementaciones;

import persistencia.daos.interfaces.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Area;
import modelo.entidades.Usuario;
import modelo.utils.UtilsModelo;
import servicios.dtos.UsuarioDTO;
import servicios.dtos.UsuarioLogueadoDTO;
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
    public UsuarioLogueadoDTO iniciarSesion(String mail, String contrasenia) {
        Usuario usuario = usuarioDAO.getPorMailYContrasenia(mail, contrasenia);
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
    public List<UsuarioDTO> getTodos(String filtro, String valor) {
        List<Usuario> usuarios = usuarioDAO.getTodos();
        List<UsuarioDTO> usuarioDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioDTO.add(UtilsModelo.usuarioToUsuarioDTO(usuario));
        }
        return usuarioDTO;
    }

    @Override
    public boolean eliminarPorId(int id) {
        return usuarioDAO.eliminarPorId(id);
    }

    @Override
    public UsuarioDTO crearUsuario(int idArea, String nombre, String telefono, 
            String mail, String direccion, String contrasenia) {
        
        Area area = new Area();
        area.setId(idArea);
        Usuario usuario = new Usuario();        
        usuario.setArea(area);
        usuario.setNombre(nombre);
        usuario.setTelefono(telefono);
        usuario.setMail(mail);
        usuario.setDireccion(direccion);
        usuario.setContrasenia(contrasenia);        
        
        // Se registra en la base de datos.
        usuario = usuarioDAO.registrar(usuario);        
        // Si no se registro el usuario.
        if (usuario == null) {
            return null;
        }        
        //Si se registro el usuario.        
        return UtilsModelo.usuarioToUsuarioDTO(usuario);
    }
}
