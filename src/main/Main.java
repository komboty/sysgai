package main;

import basedatos.ConexionBD;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static modelo.utils.Constantes.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource(VISTA_URL_LOGIN));
        stage.setTitle(VISTA_TITULO_SISTEMA);
        stage.setHeight(VISTA_STAGE_ALTO);
        stage.setWidth(VISTA_STAGE_ANCHO);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        // Conexion a base de datos.
        ConexionBD conexionBD = ConexionBD.getInstancia();
        // Lanza la ventana de inicio.
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }
}
