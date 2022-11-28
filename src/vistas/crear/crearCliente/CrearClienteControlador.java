package vistas.crear.crearCliente;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import main.Dependencias;
import servicios.dtos.ClienteDTO;
import servicios.interfaces.ClienteServicio;
import static vistas.utils.ConstantesVista.*;
import vistas.utils.UtilsVista;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class CrearClienteControlador implements Initializable {

    @FXML
    private TextField textNombre;
    @FXML
    private TextField textMail;
    @FXML
    private TextField textTelefono;
    @FXML
    private TextField textDireccion;
    @FXML
    private ChoiceBox choiceNivel;
    // Niveles que puede tener un Cliente.
    private Map<String, Integer> idsNiveles;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Se obtienen los niveles que puede tener un Cliente.
        idsNiveles = getNiveles();
        // Se cargan las niveles a la vista
        for (Map.Entry<String, Integer> idNivel : idsNiveles.entrySet()) {
            choiceNivel.getItems().add(idNivel.getKey());
        }
    }

    /**
     * Registra un usuario en la base de datos.
     */
    public void onRegistrar() {
        ClienteServicio clienteServicio = Dependencias.getClienteServicio();
        String nombreNivel;
        // Se obtiene el valor del ChoiceBox.
        try {
            nombreNivel = choiceNivel.getSelectionModel().getSelectedItem().toString();
        } catch (Exception ex) {
            System.err.println("vistas.crear.crearCliente.CrearClienteControlador.onRegistrar()");
            System.err.println(ex);
            String mensajeError = String.format(NO_HAY_SELECCION_MENSAJE, "- Nivel");
            UtilsVista.lanzaAlertaError(NO_HAY_SELECCION_TITULO, mensajeError);
            return;
        }

        // Se registra el Cliente en la base de datos.
        ClienteDTO clienteDTO = clienteServicio.crearCliente(idsNiveles.get(nombreNivel),
                textNombre.getText(), textTelefono.getText(), textMail.getText(),
                textDireccion.getText());

        String msjAlert;
        // Si ocurrio un error al registra el cliente en la base de datos.
        if (clienteDTO == null) {
            msjAlert = String.format(REGISTRAR_MENSAJE_ERROR, "el Cliente");            
        } else {
            // Si se registro correctamente el cliente en la base de datos.
            msjAlert = String.format(REGISTRAR_MENSAJE, "El Cliente", clienteDTO.getId());
        }

        UtilsVista.lanzaAlertaInformacion(ELIMINAR_REGISTRO_TITULO, msjAlert);
    }

    /**
     * Obtiene los niveles que puede tener un Cliente.
     */
    private Map<String, Integer> getNiveles() {
        Map<String, Integer> idsNiveles = new HashMap<>();
        idsNiveles.put("A", 1);
        idsNiveles.put("B", 2);
        idsNiveles.put("C", 3);
        return idsNiveles;
    }

}
