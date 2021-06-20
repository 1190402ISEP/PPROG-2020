package com.mycompany.dk_tp3_1190402_1191045;

import controller.SeriarAnuncioController;
import exception.NaoEncontradoException;
import model.Processo;
import model.Tarefa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 *
 * @author 1190402-1191045
 */
public class SeriarCandidaturasUI implements Initializable {

    @FXML
    private ComboBox<Processo> cmbProcessos;
    @FXML
    private TextArea txtCandidaturas;
    @FXML
    private Button btnSeriar;
    @FXML
    private Button btnVoltar;

    private static final String BOTAO_SERIAR = "Seriar";
    private static final String BOTAO_VOLTAR = "Voltar";
    private static final String TITULO_ALERTA = "Lista de Tarefas";
    private static final String CABECALHO_VALORES_INVALIDOS = "Valores Inválidos";

    private SeriarAnuncioController appController;

    private JanelaPrincipalUI janelaPrincipalUI;

    private Tarefa tarefa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarControlos();
    }

    /**
     *
     * @param janelaPrincipalUI janela principal da aplicação
     */
    public void associarParentUI(JanelaPrincipalUI janelaPrincipalUI) {
        this.janelaPrincipalUI = janelaPrincipalUI;
        appController = this.janelaPrincipalUI.getSeriarAnuncioController();

        preencherProcessos();
    }

    /**
     * Limpar a cmbProcessos
     */
    public void limparGUI() {
        txtCandidaturas.setText("");
        cmbProcessos.getSelectionModel().selectFirst();
    }

    @FXML
    private void seriarAction(ActionEvent event) throws NaoEncontradoException {
        try {
            if (cmbProcessos.getValue().equals(Processo.PROCESSO1)) {
                updateTexto(appController.despoletarProcessoDeSeriacao1(appController.getListaCandidaturas(tarefa)));
            } else if (cmbProcessos.getValue().equals(Processo.PROCESSO2)) {
                updateTexto(appController.despoletarProcessoDeSeriacao2(appController.getListaCandidaturas(tarefa)));
            }
        } catch (IllegalArgumentException iae) {
            criarAlerta(Alert.AlertType.ERROR, CABECALHO_VALORES_INVALIDOS, iae.getMessage()).show();
        }
    }

    @FXML
    private void voltarAction(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    /**
     * Inicia cada controlo da aplicação com o seu texto referente
     */
    private void iniciarControlos() {
        btnSeriar.setText(BOTAO_SERIAR);
        btnVoltar.setText(BOTAO_VOLTAR);
    }

    /**
     * Preenche os processos
     */
    private void preencherProcessos() {
        cmbProcessos.getItems().setAll(appController.getProcessos());
        cmbProcessos.getSelectionModel().selectFirst();
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

    public void updateTexto(String texto) {
        txtCandidaturas.setText(texto);
    }

    /**
     * Alterar o texto para mostrar a lista de Candidaturas associadas à tarefa
     * com a referência recebida por parâmetro
     *
     * @throws NaoEncontradoException nenhuma candidatura associada à tarefa
     */
    public void getListaCandidaturas() throws NaoEncontradoException {
        updateTexto(appController.getListaCandidaturas(tarefa).toString());
    }

    public void setTarefa(Tarefa tarefa) throws NaoEncontradoException {
        this.tarefa = tarefa;
        getListaCandidaturas();
    }
}
