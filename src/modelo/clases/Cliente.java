package modelo.clases;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Cliente extends Persona {

    private String nivel;
    private List<Almacen> almacenes;
    
    public Cliente() {
    }

    public Cliente(Almacen almacen, String nivel, int id, LocalDateTime fechaCreacion,
            LocalDateTime fechaModificacion, String nombre, String telefono,
            String mail, String direccion) {

        super(id, fechaCreacion, fechaModificacion, nombre, telefono, mail, direccion);
        this.nivel = nivel;
        almacenes = new ArrayList<>();
        almacenes.add(almacen);
    }

    @Override
    public String toString() {
        return String.format("%s\nNIVEL: %s\nALMACENES: %d", 
                super.toString(), nivel, almacenes.size());
    }
}
