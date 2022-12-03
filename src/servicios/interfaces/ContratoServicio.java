package servicios.interfaces;

import java.time.LocalDateTime;
import servicios.dtos.ContratoDTO;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface ContratoServicio extends GenericServicio<ContratoDTO> {

//    public ContratoDTO crearContrato(int idCliente, int idTipoContrato, int idTipoPago, int idTipoToner,
//            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
//            int diaCorte, int rentaMensual, int bolsaBN, int bolsaColor, double clickBN, double clickColor);
    public ContratoDTO crearContratoRentaMensual(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, int rentaMensual);

    public ContratoDTO crearContratoRentaPorBolsa(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, int rentaMensual, int bolsaBN, int bolsaColor, double clickBN, double clickColor);

    public ContratoDTO crearContratoCostoPorPaginas(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, double clickBN, double clickColor);

    public ContratoDTO crearContratoSoporteYMantenimiento(int idCliente, int idTipoPago, int idTipoToner,
            int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato,
            int diaCorte, int rentaMensual);
}
