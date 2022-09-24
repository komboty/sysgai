package modelo.entidades;

import java.util.List;
import modelo.utils.Utils;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Cliente extends Persona {
    
    private String nivel;
    private List<Almacen> almacenes;
    private List<Contrato> contratos;
    
    public Cliente() {
    }
    
    public String getNivel() {
        return nivel;
    }
    
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public List<Almacen> getAlmacenes() {
        return almacenes;
    }
    
    public void setAlmacenes(List<Almacen> almacenes) {
        this.almacenes = almacenes;
    }
    
    public List<Contrato> getContratos() {
        return contratos;
    }
    
    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
    
    @Override
    public String toString() {
        String toString;
        if (isToStringTodo()) {
            toString = String.format("%s\nNIVEL: %s\nALMACENES: %s\nCONTRATOS: %s",
                super.toString(), nivel, Utils.getSize(almacenes), Utils.getSize(contratos));
        } else {
            toString = String.format("%s", super.toString());
        }
        return toString;
    }
}
