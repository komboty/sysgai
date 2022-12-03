package modelo.entidades;

import java.time.LocalDateTime;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public abstract class ObjectInit {

    private int id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

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
}
