package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static vistas.utils.ConstantesVista.*;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource(URL_LOGIN));
        stage.setTitle(TITULO_SISTEMA);
        stage.setHeight(STAGE_ALTO);
        stage.setWidth(STAGE_ANCHO);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        // Se inicializan las dependencias.
        Dependencias.Inicializa();
        // Lanza la ventana de inicio.
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }
}
