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

    private static Stage primaryStage;
    
    public static Stage getStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource(VISTA_URL_LOGIN));
        primaryStage.setTitle(VISTA_TITULO_SISTEMA);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Conexion a base de datos.
        ConexionBD conexionBD = ConexionBD.getInstancia();
        // Lanza la ventana de inicio.
        launch(args);
    }
}
