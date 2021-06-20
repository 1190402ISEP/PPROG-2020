package com.mycompany.dk_tp3_1190402_1191045;

import controller.SeriarAnuncioController;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainApp extends Application {

    public static final String TITULO_APLICACAO = "Lista Tarefas";
    private static final String TITULO_ALERTA = "Lista de Tarefas";

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JanelaPrincipalScene.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            stage.setTitle(TITULO_APLICACAO);
            stage.setScene(scene);
            
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Alert alerta = criarAlerta(Alert.AlertType.CONFIRMATION, TITULO_ALERTA,
                             "Deseja mesmo encerrar a aplicação?");
                    
                    if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                        event.consume();
                    }
                    else {
                        SeriarAnuncioController appController = ((JanelaPrincipalUI) loader.getController()).getSeriarAnuncioController();
                    }
                }
            });
            stage.show();
        } catch (IOException ex) {
            criarAlerta(Alert.AlertType.ERROR, "Problemas no arranque da aplicação.", ex.getMessage()).show();
        }

    }

    /**
     *
     * @param args argumentos linha de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Cria um Alerta
     */
    private Alert criarAlerta(Alert.AlertType tipoAlerta, String cabecalho,
            String mensagem) {
        Alert alerta = new Alert(tipoAlerta);
        
        alerta.setTitle(cabecalho);
        alerta.setContentText(mensagem);
        
        if (tipoAlerta == Alert.AlertType.CONFIRMATION) {
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.OK)).setText("Sim");
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Não");
        }
        
        return alerta;
    }
}
