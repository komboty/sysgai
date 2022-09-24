package modelo.entidades;

import java.time.LocalDateTime;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public abstract class ObjectInit {

    private int id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private boolean toStringTodos;

    public ObjectInit() {
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

    public boolean isToStringTodos() {
        return toStringTodos;
    }

    public void setToStringTodos(boolean toStringTodos) {
        this.toStringTodos = toStringTodos;
    }

    @Override
    public String toString() {
        String toString;
        if (isToStringTodos()) {
            toString = String.format("ID: %d\nFECHA CREACIÓN: %s\nFECHA MODIFICACIÓN: %s",
                    id, fechaCreacion, fechaModificacion);
        } else {
            toString = "";
        }
        return toString;
    }
}
