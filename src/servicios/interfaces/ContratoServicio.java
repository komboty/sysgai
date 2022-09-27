package servicios.interfaces;

import java.time.LocalDateTime;
import modelo.entidades.Contrato;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface ContratoServicio extends GenericServicio<Contrato> {

//    public Contrato crearContrato(int idCliente, int idTipoContrato, int idTipoPago, int idTipoToner,
//            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
//            int diaCorte, int rentaMensual, int bolsaBN, int bolsaColor, double clickBN, double clickColor);
    public Contrato crearContratoRentaMensual(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, int rentaMensual);

    public Contrato crearContratoRentaPorBolsa(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, int rentaMensual, int bolsaBN, int bolsaColor, double clickBN, double clickColor);

    public Contrato crearContratoCostoPorPaginas(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, double clickBN, double clickColor);

    public Contrato crearContratoSoporteYMantenimiento(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, int rentaMensual);
}
