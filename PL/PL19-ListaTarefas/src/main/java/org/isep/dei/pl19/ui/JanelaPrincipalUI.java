/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isep.dei.pl19.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.isep.dei.pl19.controller.AplicacaoController;
import org.isep.dei.pl19.model.ListaTarefas;

/**
 * FXML Controller class
 *
 * @author anton
 */
public class JanelaPrincipalUI implements Initializable {

    @FXML
    private Menu mnuFicheiro;
    @FXML
    private MenuItem mnuFicheiroGuardarTexto;
    @FXML
    private MenuItem mnuFicheiroGuardarBinario;
    @FXML
    private MenuItem mnuFicheiroSair;
    @FXML
    private Menu mnuTarefa;
    @FXML
    private MenuItem mnuTarefaAdicionar;
    @FXML
    private Menu mnuTarefaRemover;
    @FXML
    private MenuItem mnuTarefaRemoverSeleccionada;
    @FXML
    private MenuItem mnuTarefaRemoverTodas;
    @FXML
    private ListView<?> lstViewTarefas;
    private static final String MENU_FICHEIRO = "Ficheiro";
    private static final String MENU_FICHEIRO_GUARDAR_TEXTO = "Guardar como Texto";
    private static final String MENU_FICHEIRO_GUARDAR_BINARIO = "Guardar Como Binário";
    private static final String MENU_FICHEIRO_SAIR = "Sair";
    private static final String MENU_TAREFA = "Tarefa";
    private static final String MENU_TAREFA_ADICIONAR = "Adicionar";
    private static final String MENU_TAREFA_MENU_REMOVER = "Remover";
    private static final String MENU_TAREFA_MENU_REMOVER_SELECIONADA = "Selecionada";
    private static final String MENU_TAREFA_MENU_REMOVER_TODAS = "TODAS";
    private static final String CABECALHO_ERRO_FATAL = "Erro Fatal";
    private static final String CABECALHO_ERRO_FUNCAO = "Erro Função";
    private static final String TITULO_ALERTA_LISTA_TAREFAS = "Lista De Tarefas";
    private static final String TITULO_PALCO_NOVA_TAREFA = "Nova Tarefa";
    private static final String MENSAGEM_LISTA_VAZIA = "Lista de Tarefas Vazia";
    private static final String CABECALHO_REMOVER_TAREFA = "Remover Tarefa";
    private static final String CONTEXTO_REMOVER_TAREFA = "Confirma a remoção da seguinte Tarefa?";
    private static final String CABECALHO_GUARDAR_FICHEIRO_TEXTO = "Guardar Lista num ficheiro de Texto";
    private static final String CONTEXTO_CONFIRMAR_GUARDAR_FICHEIRO_TEXTO = "Deseja Guardar a Lista num Ficheiro de Texto";
    private static final String CONTEXTO_SUCESSO_GUARDAR_FICHEIRO_TEXTO = "Ficheiro de Texto Gravado com Sucesso";
    private static final String CONTEXTO_INSUCESSO_GUARDAR_FICHEIRO_TEXTO = "Não foi possível gravar o ficheiro de texto";
    private static final String CABECALHO_GUARDAR_FICHEIRO_BINARIO = "Guardar Lista num ficheiro Binário";
    private static final String CONTEXTO_CONFIRMAR_GUARDAR_FICHEIRO_BINARIO = "Deseja Guardar a Lista num Ficheiro Binário";
    private static final String CONTEXTO_SUCESSO_GUARDAR_FICHEIRO_BINARIO = "Ficheiro Binário Gravado com Sucesso";
    private static final String CONTEXTO_INSUCESSO_GUARDAR_FICHEIRO_BINARIO = "Não foi possível gravar o ficheiro Binário";
    private AplicacaoController appController;
    private AdicionarTarefaUI adicionarTarefaUI;
    private Stage novaTarefaStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarControlos();
        try {
            appController = new AplicacaoController();
            novaTarefaStage = new Stage();
            novaTarefaStage.initModality(Modality.APPLICATION_MODAL);

            novaTarefaStage.setTitle(TITULO_PALCO_NOVA_TAREFA);
            novaTarefaStage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarTarefaScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            novaTarefaStage.setScene(scene);
            novaTarefaStage.sizeToScene();

            novaTarefaStage.setOnHiding(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent event) {
                    adicionarTarefaUI.limparGUI();
                }
            });

            adicionarTarefaUI = loader.getController();
            adicionarTarefaUI.associarParentUI(this);

        } catch (Exception ex) {
            criarAlerta(Alert.AlertType.ERROR, CABECALHO_ERRO_FATAL, ex.getLocalizedMessage()).showAndWait();
            Platform.exit();

        }
    }
   public AplicacaoController getAplicacaoController(){
       lstViewTarefas.getItems().setAll(appController.getArrayListTarefas());
   } 
    


    @FXML
    private void mnuFicheiroGuardarTextoAction(ActionEvent event) {
    }

    @FXML
    private void mnuFicheiroGuardarBinarioAction(ActionEvent event) {
    }

    @FXML
    private void mnuFicheiroSairAction(ActionEvent event) {
    }

    @FXML
    private void mnuFicheiroShowing(Event event) {
    }

    @FXML
    private void mnuTarefaAdicionarAction(ActionEvent event) {
    }

    @FXML
    private void mnuTarefaRemoverSeleccionadaAction(ActionEvent event) {
    }

    @FXML
    private void mnuTarefaRemoverTodasAction(ActionEvent event) {
    }

    @FXML
    private void mnuTarefaRemoverShowing(Event event) {
    }

    @FXML
    private void mnuTarefaShowing(Event event) {
    }

    @FXML
    private void teclaRatoLibertadaAction(MouseEvent event) {
    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {
    }

    private void iniciarControlos() {
        mnuFicheiro.setText(MENU_FICHEIRO);
        mnuFicheiroGuardarTexto.setText(MENU_FICHEIRO_GUARDAR_TEXTO);
        mnuFicheiroGuardarBinario.setText(MENU_FICHEIRO_GUARDAR_BINARIO);
        mnuFicheiroSair.setText(MENU_FICHEIRO_SAIR);

        mnuTarefa.setText(MENU_TAREFA);
        mnuTarefaAdicionar.setText(MENU_TAREFA_ADICIONAR);
        mnuTarefaRemover.setText(MENU_TAREFA_MENU_REMOVER);
        mnuTarefaRemoverSeleccionada.setText(MENU_TAREFA_MENU_REMOVER_SELECIONADA);
        mnuTarefaRemoverTodas.setText(MENU_TAREFA_MENU_REMOVER_TODAS);

    }
private void atualizarListaTarefas(ListaTarefas.ORDENACAO ordem){
    lstViewTarefas.getItems().setAll(ordem== ListaTarefas.ORDENACAO.INSERCAO ? appController.getArrayListTarefas() : appController.getArrayListTarefasPorPrioridade());
}
}
