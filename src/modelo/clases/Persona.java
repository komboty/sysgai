package modelo.clases;

import java.time.LocalDateTime;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public abstract class Persona extends ObjectInit {

    protected String nombre;
    protected String telefono;
    protected String mail;
    protected String direccion;

    public Persona(String mail) {
        this.mail = mail;
    }

    public Persona(int id, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion,
            String nombre, String telefono, String mail, String direccion) {
        
        super(id, fechaCreacion, fechaModificacion);
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.direccion = direccion;
    }
}
