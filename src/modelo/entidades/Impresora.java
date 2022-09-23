package modelo.entidades;

import modelo.constantes.TipoEstadoImpresora;
import modelo.constantes.TipoImpresion;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Impresora extends Producto {

    /**
     * Default constructor
     */
    public Impresora() {
    }

    /**
     *
     */
    private TipoEstadoImpresora estado;

    /**
     *
     */
    private TipoImpresion tipoImpresion;

    /**
     *
     */
    private int contador;

}
