package modelo.clases;

import modelo.constantes.TipoEstadoTicket;
import modelo.constantes.TipoTicket;
import modelo.constantes.TipoPrioridad;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Ticket extends ObjectInit {

    /**
     * Default constructor
     */
    public Ticket() {
    }

    /**
     *
     */
    private TipoTicket tipo;

    /**
     *
     */
    private TipoPrioridad prioridad;

    /**
     *
     */
    private TipoEstadoTicket estado;

}
