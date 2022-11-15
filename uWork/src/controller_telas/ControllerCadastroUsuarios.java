package controller_telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerCadastroUsuarios {

    @FXML
    private Button btn_voltar;

    @FXML
    private Button btn_criarConta;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;

    @FXML
    private TextField tfPais;

    @FXML
    private TextField tfCep;

    @FXML
    private TextField tfCidade;

    @FXML
    private TextField tfBairro;

    @FXML
    private TextField tfLogradouro;

    @FXML
    private TextField tfNumero;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfComplemento;
    
    @FXML
    private TextField tfEstado;

    @FXML
    void btCadastrar(ActionEvent event) {
        String nome = tfNome.getText();
        String Email = tfEmail.getText();
        String senha = tfSenha.getText();
        String telefone = tfTelefone.getText();
        String pais = tfPais.getText();
        String estado = tfEstado.getText();
        String cep = tfCep.getText();
        String cidade = tfCidade.getText();
        String bairro = tfBairro.getText();
        String logradouro = tfLogradouro.getText();
        String complemento = tfComplemento.getText();
        String numero = tfNumero.getText();

        
    }

    @FXML
    void btn_voltarFUN(ActionEvent event) {

    }

}