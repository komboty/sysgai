package servicios.implementaciones;

import basedatos.daos.interfaces.ContratoDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Contrato;
import modelo.utils.UtilsModelo;
import servicios.dtos.ContratoDTO;
import servicios.interfaces.ContratoServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ContratoServicioImpl implements ContratoServicio {

    private ContratoDAO contratoDAO;

    public ContratoServicioImpl(ContratoDAO contratoDAO) {
        this.contratoDAO = contratoDAO;
    }

    @Override
    public List<ContratoDTO> getTodos(String filtro, String valor) {
        List<Contrato> contratos = contratoDAO.getTodos();
        List<ContratoDTO> objectToStringDTO = new ArrayList<>();
        for (Contrato contrato : contratos) {
            objectToStringDTO.add(UtilsModelo.contratoToContratoDTO(contrato));
        }
        return objectToStringDTO;
    }

    @Override
    public boolean eliminarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ContratoDTO crearContratoRentaMensual(int idCliente, int idTipoPago, int idTipoToner, int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato, int diaCorte, int rentaMensual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ContratoDTO crearContratoRentaPorBolsa(int idCliente, int idTipoPago, int idTipoToner, int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato, int diaCorte, int rentaMensual, int bolsaBN, int bolsaColor, double clickBN, double clickColor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ContratoDTO crearContratoCostoPorPaginas(int idCliente, int idTipoPago, int idTipoToner, int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato, int diaCorte, double clickBN, double clickColor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ContratoDTO crearContratoSoporteYMantenimiento(int idCliente, int idTipoPago, int idTipoToner, int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato, int diaCorte, int rentaMensual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
