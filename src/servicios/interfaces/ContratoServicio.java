package servicios.interfaces;

import java.time.LocalDateTime;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface ContratoServicio<T, K> extends GenericServicio<T> {

//    public Contrato crearContrato(int idCliente, int idTipoContrato, int idTipoPago, int idTipoToner,
//            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
//            int diaCorte, int rentaMensual, int bolsaBN, int bolsaColor, double clickBN, double clickColor);
    public K crearContratoRentaMensual(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, int rentaMensual);

    public K crearContratoRentaPorBolsa(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, int rentaMensual, int bolsaBN, int bolsaColor, double clickBN, double clickColor);

    public K crearContratoCostoPorPaginas(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, double clickBN, double clickColor);

    public K crearContratoSoporteYMantenimiento(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, int rentaMensual);
}
