package modelo.entidades;

import static modelo.utils.Constantes.DELIMITADOR_DIRECCCION;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public abstract class Persona extends ObjectInit {

    private String nombre;
    private String telefono;
    private String mail;
    private String direccion;

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        String toString;
        if (isToStringTodos()) {
            toString = String.format("%s\nNOMBRE: %s\nTELEFONO: %s\nCORREO: %s\n-----------------\nDIRECCION:\n%s\n-----------------",
                    super.toString(), nombre, telefono, mail, direccion.replaceAll(DELIMITADOR_DIRECCCION, "\n"));
        } else {
            toString = String.format("%s\nNOMBRE: %s", super.toString(), nombre);
        }
        return toString;
    }
}
