package modelo.entidades;

import java.time.LocalDateTime;
import modelo.utils.Utils;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public abstract class ObjectInit {

    private int id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    // Variable que define si se regresa toda la informacion en toString().
    private boolean toStringTodo;

    public ObjectInit() {
        toStringTodo = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public boolean isToStringTodo() {
        return toStringTodo;
    }

    public void setToStringTodo(boolean toStringTodos) {
        this.toStringTodo = toStringTodos;
    }

    @Override
    public String toString() {
        String toString;
        if (isToStringTodo()) {
            toString = String.format("ID: %s\nFECHA CREACIÓN: %s\nFECHA MODIFICACIÓN: %s",
                    id, Utils.localDateTimeToString(fechaCreacion), Utils.localDateTimeToString(fechaModificacion));
        } else {
            toString = "";
        }
        return toString;
    }
}
