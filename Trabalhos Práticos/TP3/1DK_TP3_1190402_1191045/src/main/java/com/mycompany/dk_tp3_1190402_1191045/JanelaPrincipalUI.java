package com.mycompany.dk_tp3_1190402_1191045;

import controller.SeriarAnuncioController;
import exception.NaoEncontradoException;
import model.Tarefa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author 1190402-1191045
 */
public class JanelaPrincipalUI implements Initializable {

    @FXML
    private Button btnVerCandidaturas;
    @FXML
    private ListView<Tarefa> listTarefas;
    @FXML
    private Button btnTarefasPublicadas;

    private static final String BOTAO_VER_TAREFAS_PUBLICADAS = "Ver Tarefas Publicadas";
    private static final String BOTAO_VER_CANDIDATURAS = "Ver Candidaturas";
    private static final String TITULO_PALCO_SERIAR_CANDIDATURAS = "Seriar Candidatura";

    private static final String TITULO_ALERTA = "Lista de Tarefas";
    private static final String CABECALHO_ERRO_FATAL = "Erro Fatal";

    private SeriarAnuncioController appController;

    private SeriarCandidaturasUI seriarCandidaturasUI;

    private Stage seriarCandidaturasStage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarControlos();

        try {
            appController = new SeriarAnuncioController();

            seriarCandidaturasStage = new Stage();
            seriarCandidaturasStage.initModality(Modality.APPLICATION_MODAL);

            seriarCandidaturasStage.setTitle(TITULO_PALCO_SERIAR_CANDIDATURAS);
            seriarCandidaturasStage.setResizable(false);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SeriarCandidaturasScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            seriarCandidaturasStage.setScene(scene);
            seriarCandidaturasStage.sizeToScene();

            seriarCandidaturasStage.setOnHiding(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    seriarCandidaturasUI.limparGUI();
                }
            });

            seriarCandidaturasUI = loader.getController();
            seriarCandidaturasUI.associarParentUI(this);

        } catch (Exception ex) {
            criarAlerta(Alert.AlertType.ERROR, CABECALHO_ERRO_FATAL, ex.getMessage()).showAndWait();
            Platform.exit();
        }
    }

    /**
     *
     * @return o controlador da aplicação
     */
    public SeriarAnuncioController getSeriarAnuncioController() {
        return appController;
    }

    /**
     * Atualiza as listas de Tarefas
     */
    public void atualizarListaTarefas() {
        listTarefas.getItems().clear();

        listTarefas.getItems().addAll(appController.getListaTarefas());

        btnVerCandidaturas.setDisable(appController.listaVazia());
    }

    @FXML
    private void verCandidaturasAction(ActionEvent event) throws NaoEncontradoException {
        try {
            seriarCandidaturasUI.setTarefa(listTarefas.getSelectionModel().getSelectedItem());
            seriarCandidaturasStage.show();
        } catch (Exception ex) {
            criarAlerta(Alert.AlertType.ERROR, CABECALHO_ERRO_FATAL, ex.getMessage()).showAndWait();
        }
    }

    @FXML
    private void tarefasPublicadasAction(ActionEvent event) {
        atualizarListaTarefas();
    }

    /**
     * Inicia cada controlo da aplicação com o seu texto referente
     */
    private void iniciarControlos() {
        btnTarefasPublicadas.setText(BOTAO_VER_TAREFAS_PUBLICADAS);
        btnVerCandidaturas.setText(BOTAO_VER_CANDIDATURAS);

        btnTarefasPublicadas.setPrefWidth(listTarefas.getPrefWidth());
        btnVerCandidaturas.setPrefWidth(listTarefas.getPrefWidth());
    }

    /**
     * Cria um Alerta
     */
    private Alert criarAlerta(Alert.AlertType tipoAlerta, String cabecalho,
            String mensagem) {
        Alert alerta = new Alert(tipoAlerta);

        alerta.setTitle(TITULO_ALERTA);
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);

        return alerta;
    }
}
