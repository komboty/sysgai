package modelo.entidades;

import java.time.LocalDateTime;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public abstract class ObjectInit {

    protected int id;
    protected LocalDateTime fechaCreacion;
    protected LocalDateTime fechaModificacion;

    public ObjectInit() {
    }

    public ObjectInit(int id, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nFECHA CREACIÓN: %s\nFECHA MODIFICACIÓN: %s",
                id, fechaCreacion, fechaModificacion);
    }
}
