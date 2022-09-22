package servicios.implementaciones;

import basedatos.daos.implementaciones.ContratoDAOImpl;
import basedatos.daos.interfaces.ContratoDAO;
import java.util.List;
import modelo.clases.Contrato;
import servicios.interfaces.ContratoServicio;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ContratoServicioImpl implements ContratoServicio {

    private static ContratoDAO contratoDAO = new ContratoDAOImpl();

    public ContratoServicioImpl() {
    }

    @Override
    public List<Contrato> getTodos() {
        return contratoDAO.getTodos();
    }
}
