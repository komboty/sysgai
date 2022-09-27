package servicios.implementaciones;

import basedatos.daos.interfaces.ContratoDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Contrato;
import modelo.utils.UtilsModelo;
import servicios.dtos.FiltroDTO;
import servicios.dtos.ObjectToStringDTO;
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
    public List<ObjectToStringDTO> getTodos(FiltroDTO filtroDTO) {
        List<Contrato> contratos = contratoDAO.getTodos();
        List<ObjectToStringDTO> objectToStringDTO = new ArrayList<>();
        for (Contrato contrato : contratos) {
            objectToStringDTO.add(UtilsModelo.contratoToObjectToStringDTO(contrato));
        }
        return objectToStringDTO;
    }

    @Override
    public boolean eliminarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Contrato crearContratoRentaMensual(int idCliente, int idTipoPago, int idTipoToner, int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato, int diaCorte, int rentaMensual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Contrato crearContratoRentaPorBolsa(int idCliente, int idTipoPago, int idTipoToner, int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato, int diaCorte, int rentaMensual, int bolsaBN, int bolsaColor, double clickBN, double clickColor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Contrato crearContratoCostoPorPaginas(int idCliente, int idTipoPago, int idTipoToner, int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato, int diaCorte, double clickBN, double clickColor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Contrato crearContratoSoporteYMantenimiento(int idCliente, int idTipoPago, int idTipoToner, int idTipoEstadoProducto, LocalDateTime inicioContrato, int mesesContrato, int diaCorte, int rentaMensual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
