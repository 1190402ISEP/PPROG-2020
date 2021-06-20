package com.mycompany.pl17;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
       
    @FXML
    private TextField txtNumero;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnEsquerda;
    @FXML
    private Label lblTexto;
    @FXML
    private Button btnDireita;

    private static String[] Letras;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void trataNumero(ActionEvent event) {
        try {
            int nLetras = Integer.parseInt(txtNumero.getText());

            if (nLetras > 2 && nLetras < 8) {
                criarVetorialInicial(nLetras);
                
                lblTexto.setText(criarString());

                Stage stg = (Stage) lblTexto.getScene().getWindow();

                stg.sizeToScene();
            } else {
                criarAlerta(Alert.AlertType.ERROR, "Quantidade de Letras", "Valor introduzido",
                        "Deve ser introduzido um numero entre 3 e 7!").show();
                
                limparCaixaTexto();
            }
        } catch (NumberFormatException nfe) {
            criarAlerta(Alert.AlertType.ERROR, "Quantidade de Letras", "Valor introduzido", 
                    "Deve ser introduzido um valor inteiro!").show();
            
            limparCaixaTexto();
        }
    }

    @FXML
    private void trataTexto(ActionEvent event) {
        Object obj = event.getSource();
        if (obj == btnEsquerda) {
            String primeiro = Letras[0];
            
            for (int i = 0; i < Letras.length; i++) {
                Letras[i-1] = Letras[i];
            }
            
            Letras[Letras.length-1] = primeiro;
            lblTexto.setText(criarString());
        } else if (obj == btnDireita) {
            String ultimo = Letras[Letras.length-1];
            
            for (int i = Letras.length-1; i > 0; i--) {
                Letras[i] = Letras[i-1];
            }
            
            Letras[0] = ultimo;
            lblTexto.setText(criarString());
        }
    }
    
     private Alert criarAlerta(Alert.AlertType alertType, String titulo, String cabecalho, String mensagem) {
        Alert alert = new Alert(alertType);

        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(mensagem);

        return alert;
    }   
     
    private void criarVetorialInicial(int nLetras){
        Letras = new String[nLetras];
        
        for (int i = 0; i < Letras.length; i++) {
            Letras[i] = Character.toString((char) (i+65));
        }
    }

    private String criarString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Letras.length - 1; i++) {
            sb.append(Letras[i]);
            sb.append(" ");
        }

        sb.append(Letras[Letras.length - 1]);

        return sb.toString();
    }

    private void limparCaixaTexto() {
        txtNumero.setText("");

        txtNumero.requestFocus();
    }
}
