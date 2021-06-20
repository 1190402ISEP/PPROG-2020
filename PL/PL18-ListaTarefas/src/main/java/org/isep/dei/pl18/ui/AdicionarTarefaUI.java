package org.isep.dei.pl18.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.isep.dei.pl18.controller.AplicacaoController;
import org.isep.dei.pl18.model.Prioridade;

/**
 * FXML Controller class
 *
 * @author anton
 */
public class AdicionarTarefaUI implements Initializable {

 private static final String LABEL_PRIORIDADE = "Prioridade";
    private static final String LABEL_TAREFA = "Tarefa";
    private static final String BOTAO_ADICIONAR_TAREFA = "Adicionar Tarefa";
    private static final String BOTAO_CANCELAR = "Cancelar";
    private static final String TITULO_ALERTA = "Lista de Tarefas";
    private static final String CABECALHO_VALORES_INVALIDOS = "Valores Inválidos";
    private static final String CABECALHO_ADICIONAR_TAREFA = "Adicionar Tarefa";
    private static final String MENSAGEM_TAREFA_ADICIONADA = "Tarefa adicionada com sucesso!";
    private static final String MENSAGEM_TAREFA_NAO_ADICIONADA = "Não foi possível adicionar a tarefa!";

    private static AplicacaoController appController;
    private static JanelaPrincipalUI janelaPrincipalUI;

    @FXML
    private Button btnCriarTarefa;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblTarefa;
    @FXML
    private Label lblPrioridade;
    @FXML
    private TextField txtTarefa;
    @FXML
    private ComboBox<Prioridade> cmbPrioridade;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void criarTarefaAction(ActionEvent event) {

       try {
            boolean adicionou = appController.adicionarTarefa(txtTarefa.getText().trim(), cmbPrioridade.getValue());
           
            if (adicionou) {
                janelaPrincipalUI.atualizarListaTarefas();
            }
            criarAlerta(Alert.AlertType.INFORMATION, CABECALHO_ADICIONAR_TAREFA,
                    adicionou ? MENSAGEM_TAREFA_ADICIONADA
                            : MENSAGEM_TAREFA_NAO_ADICIONADA).show();
           
            cancelarAction(event);
           
        } catch (IllegalArgumentException iae) {
            criarAlerta(Alert.AlertType.ERROR, CABECALHO_VALORES_INVALIDOS, iae.getMessage()).show();
        }
    }

    @FXML
    private void cancelarAction(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    public void limparGUI() {
        txtTarefa.clear();
        cmbPrioridade.getSelectionModel().selectFirst();
    }

    public void associarParentUI(JanelaPrincipalUI janelaPrincipalUI) {
        this.janelaPrincipalUI = janelaPrincipalUI;
        appController = this.janelaPrincipalUI.getAplicacaoController();
        preencherPrioridades();
    }

    private Alert criarAlerta(Alert.AlertType alertType, String CABECALHO_ERRO_FATAL, String localizedMessage) {
        Alert alert = new Alert(alertType);
        alert.setTitle(TITULO_ALERTA);
        alert.setHeaderText(CABECALHO_ERRO_FATAL);
        alert.setContentText(localizedMessage);

        return alert;
    }

    private void preencherPrioridades() {
        cmbPrioridade.getItems().setAll(appController.getPrioridades());
        cmbPrioridade.getSelectionModel().selectFirst();
    }
}
