package servicios.dtos;

import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ContratoDTO {

    private int id;
    private String fechaCreacion;
    private String fechaModificacion;
    private String nombreCliente;
    private List<Integer> idsfacturas;
    private List<Integer> idspedidos;
    private String inicioContrato;
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

    public ContratoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public List<Integer> getIdsfacturas() {
        return idsfacturas;
    }

    public void setIdsfacturas(List<Integer> idsfacturas) {
        this.idsfacturas = idsfacturas;
    }

    public List<Integer> getIdspedidos() {
        return idspedidos;
    }

    public void setIdspedidos(List<Integer> idspedidos) {
        this.idspedidos = idspedidos;
    }

    public String getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(String inicioContrato) {
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

}
