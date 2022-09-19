package modelo.clases;

import java.time.LocalDateTime;
import modelo.constantes.TipoContrato;
import modelo.constantes.TipoEstadoImpresora;
import modelo.constantes.TipoPago;
import modelo.constantes.TipoEstadoContrato;
import modelo.constantes.TipoToner;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Contrato extends ObjectInit {

    /**
     * Default constructor
     */
    public Contrato() {
    }

    /**
     *
     */
    private LocalDateTime inicioContrato;

    /**
     *
     */
    private TipoContrato tipoContrato;

    /**
     *
     */
    private int mesesContrato;

    /**
     *
     */
    private int diaCorte;

    /**
     *
     */
    private TipoPago formaPago;

    /**
     *
     */
    private TipoEstadoImpresora tipoImpresora;

    /**
     *
     */
    private TipoToner tipoToner;

    /**
     *
     */
    private TipoEstadoContrato estado;

    /**
     *
     */
    private int rentaMensual;

    /**
     *
     */
    private int bolsaBN;

    /**
     *
     */
    private int bolsaColor;

    /**
     *
     */
    private int clickBN;

    /**
     *
     */
    private int clickColor;

    /**
     *
     */
    public void validar() {
        // TODO implement here
    }

}
