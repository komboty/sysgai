package modelo.entidades;

import java.awt.Image;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Evidencia extends ObjectInit {

    private String comentario;
    private Image evidencia;
    private Usuario usuario;

    public Evidencia() {
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Image getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(Image evidencia) {
        this.evidencia = evidencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

}
