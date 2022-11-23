package controller_telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import controller.RecID;

public class ControllerPerfilUsuario implements Initializable{

    @FXML
    private Button btn_criarConta;

    @FXML
    private Button btn_voltar;

    @FXML
    private TextField tfBairro;

    @FXML
    private TextField tfCep;

    @FXML
    private TextField tfCidade;

    @FXML
    private TextField tfComplemento;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfEstado;

    @FXML
    private TextField tfLogradouro;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfNumero;

    @FXML
    private TextField tfPais;

    @FXML
    private TextField tfSenha;

    @FXML
    private TextField tfTelefone;

    @FXML
    void btCadastrar(ActionEvent event) {

    }

    @FXML
    void btn_voltarFUN(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfNome.setText(RecID.getNome());
        tfEmail.setText(RecID.getEmail());
        tfBairro.setText(RecID.getBairro());
        tfLogradouro.setText(RecID.getLogradouro());
        tfEstado.setText(RecID.getEstado());
        tfPais.setText(RecID.getPais());
        tfCep.setText(String.valueOf(RecID.getCep()));
        tfNumero.setText(String.valueOf(RecID.getNumero()));
        tfTelefone.setText(String.valueOf(RecID.getTelefone()));
        tfCidade.setText(String.valueOf(RecID.getCidade()));

    }

}
