package modelo.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.utils.Utils;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Contrato extends ObjectInit {

    private Cliente cliente;
    private List<Factura> facturas;
    private List<Pedido> pedidos;
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
    private double clickBN;
    private double clickColor;

    public Contrato() {
    }

    public void validar() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public LocalDateTime getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(LocalDateTime inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public int getMesesContrato() {
        return mesesContrato;
    }

    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    public int getDiaCorte() {
        return diaCorte;
    }

    public void setDiaCorte(int diaCorte) {
        this.diaCorte = diaCorte;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getTipoImpresora() {
        return tipoImpresora;
    }

    public void setTipoImpresora(String tipoImpresora) {
        this.tipoImpresora = tipoImpresora;
    }

    public String getTipoToner() {
        return tipoToner;
    }

    public void setTipoToner(String tipoToner) {
        this.tipoToner = tipoToner;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getRentaMensual() {
        return rentaMensual;
    }

    public void setRentaMensual(int rentaMensual) {
        this.rentaMensual = rentaMensual;
    }

    public int getBolsaBN() {
        return bolsaBN;
    }

    public void setBolsaBN(int bolsaBN) {
        this.bolsaBN = bolsaBN;
    }

    public int getBolsaColor() {
        return bolsaColor;
    }

    public void setBolsaColor(int bolsaColor) {
        this.bolsaColor = bolsaColor;
    }

    public double getClickBN() {
        return clickBN;
    }

    public void setClickBN(double clickBN) {
        this.clickBN = clickBN;
    }

    public double getClickColor() {
        return clickColor;
    }

    public void setClickColor(double clickColor) {
        this.clickColor = clickColor;
    }

    @Override
    public String toString() {
        String toString;
        if (isToStringTodo()) {
            toString = String.format("%s\nCLIENTE: %s\nINICIO: %s\nTIPO: %s\nESTADO: %s\nMESES: %s\nDIA DE CORTE: %s\nFORMA DE PAGO: %s\nTIPO DE IMPRESORAS: %s\nTIPO DE TONERS: %s\nRENTA MENSUAL: %s\nBOLSA B/N: %s\nBOLSA COLOR: %s\nCLICK BN: %.2f\nCLICK COLOR: %.2f\nFACTURAS: %s\nPEDIDOS: %s",
                super.toString(), cliente.getNombre(), Utils.localDateTimeToString(inicioContrato), tipoContrato, estado, mesesContrato, diaCorte, formaPago, tipoImpresora, tipoToner, rentaMensual, bolsaBN, bolsaColor, clickBN, clickColor, Utils.getSize(facturas), Utils.getSize(pedidos));
        } else {
            toString = String.format("%s\nESTADO: %s", super.toString(), estado);
        }
        return toString;
    }

}
