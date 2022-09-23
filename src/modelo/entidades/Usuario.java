package modelo.entidades;

import java.time.LocalDateTime;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Usuario extends Persona {

    private String tipo;
    private String contrasenia;

    public Usuario() {
    }

    public Usuario(String tipo, String contrasenia, int id, LocalDateTime fechaCreacion,
            LocalDateTime fechaModificacion, String nombre, String telefono, String mail, String direccion) {

        super(id, fechaCreacion, fechaModificacion, nombre, telefono, mail, direccion);
        this.tipo = tipo;
        this.contrasenia = contrasenia;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return String.format("%s\nTIPO: %s", super.toString(), tipo);
    }
}
