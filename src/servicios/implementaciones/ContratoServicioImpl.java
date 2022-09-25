package servicios.implementaciones;

import basedatos.daos.interfaces.ContratoDAO;
import java.time.LocalDateTime;
import java.util.List;
import modelo.entidades.Contrato;
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
    public List<Contrato> getTodos() {
        return contratoDAO.getTodos();
    }
    
    @Override
    public boolean eliminarPorId(int id) {
        return contratoDAO.eliminarPorId(id);
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
