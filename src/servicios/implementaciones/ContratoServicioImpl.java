package servicios.implementaciones;

import basedatos.daos.interfaces.ContratoDAO;
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
    public Contrato editarPorId(Contrato contrato) {        
        return contratoDAO.editarPorId(contrato);
    }
    
    @Override
    public boolean eliminarPorId(int id) {
        return contratoDAO.eliminarPorId(id);
    }
}
