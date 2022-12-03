package servicios.dtos;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UsuarioLogueadoDTO {

    private int idUsuario;
    private String nombreArea;

    public UsuarioLogueadoDTO() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

}
