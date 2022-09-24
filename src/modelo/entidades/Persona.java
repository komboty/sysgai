package modelo.entidades;

import java.time.LocalDateTime;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public abstract class Persona extends ObjectInit {

    protected String nombre;
    protected String telefono;
    protected String mail;
    protected String direccion;

    public Persona() {
    }

    public Persona(int id, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion,
            String nombre, String telefono, String mail, String direccion) {

        super(id, fechaCreacion, fechaModificacion);
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return String.format("%s\nNOMBRE: %s\nTELEFONO: %s\nCORREO: %s\nDIRECCION: %s",
                super.toString(), nombre, telefono, mail, direccion);
    }
}
