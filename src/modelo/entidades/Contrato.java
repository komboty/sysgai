package modelo.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Contrato extends ObjectInit {

    private Cliente cliente;
    private List<Factura> facturas;
    private LocalDateTime inicioContrato;
    private String tipoContrato;
    private int mesesContrato;
    private int diaCorte;
    private String formaPago;
    private String tipoImpresora;
    private String tipoToner;
    private String estado;
    private int rentaMensual;
    private int bolsaBN;
    private int bolsaColor;
    private int clickBN;
    private int clickColor;

    public Contrato(Cliente cliente, LocalDateTime inicioContrato, String tipoContrato, int mesesContrato,
            int diaCorte, String formaPago, String tipoImpresora, String tipoToner,
            String estado, int rentaMensual, int bolsaBN, int bolsaColor, int clickBN,
            int clickColor, int id, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {

        super(id, fechaCreacion, fechaModificacion);
        this.cliente = cliente;
        this.inicioContrato = inicioContrato;
        this.tipoContrato = tipoContrato;
        this.mesesContrato = mesesContrato;
        this.diaCorte = diaCorte;
        this.formaPago = formaPago;
        this.tipoImpresora = tipoImpresora;
        this.tipoToner = tipoToner;
        this.estado = estado;
        this.rentaMensual = rentaMensual;
        this.bolsaBN = bolsaBN;
        this.bolsaColor = bolsaColor;
        this.clickBN = clickBN;
        this.clickColor = clickColor;
        this.facturas = new ArrayList<>();
    }

    public void validar() {
    }

    @Override
    public String toString() {
        return String.format("%s\nCLIENTE: %s\nFACTURAS: %d\nINICIO: %s\nTIPO: %s\nMESES: %s\nDIA DE CORTE: %s\nFORMA DE PAGO: %s\nTIPO DE IMPRESORAS: %s\nTIPO DE TONERS: %s\nESTADO: %s\nRENTA MENSUAL: %s\nBOLSA B/N: %s\nBOLSA COLOR: %s\nCLICK BN: %s\nCLICK COLOR: %s",
                super.toString(), cliente.getNombre(), facturas.size(),inicioContrato, tipoContrato, mesesContrato, diaCorte, formaPago, tipoImpresora, tipoToner, estado, rentaMensual, bolsaBN, bolsaColor, clickBN, clickColor);
    }

}
