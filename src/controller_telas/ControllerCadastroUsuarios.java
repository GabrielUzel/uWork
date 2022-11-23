package controller_telas;

import java.sql.SQLException;

import DAO.UsuarioDAO;
import controller.ClassAlerta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Usuario;

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
        Long telefone = (long) 0;
        if(!tfTelefone.getText().isEmpty()){
            telefone = Long.parseLong(tfTelefone.getText());
        }        
        String pais = tfPais.getText();
        String estado = tfEstado.getText();
        Long cep = (long) 0;
        if(!tfCep.getText().isEmpty()){
            cep = Long.parseLong(tfCep.getText());
        }   
        String cidade = tfCidade.getText();
        String bairro = tfBairro.getText();
        String logradouro = tfLogradouro.getText();
        String complemento = tfComplemento.getText();
        int numero = 0;
        if(!tfNumero.getText().isEmpty()){
            numero = Integer.parseInt(tfNumero.getText());
        }

        Usuario u = new Usuario(nome, Email, senha, telefone, pais, estado, cep, cidade, bairro, logradouro, complemento, numero);
        
        UsuarioDAO ud = new UsuarioDAO();

        ClassAlerta alerta = new ClassAlerta();
        try {
            ud.criarUsuario(u);
            alerta.confirmacao("Concluido", "O usuário foi cadastrado com sucesso", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            alerta.erro("erro", e.getMessage(), "um erro aconteceu");
        } catch (SQLException e) {
            e.printStackTrace();
            alerta.erro("erro", e.getMessage(), "um erro aconteceu");
        }    
    }

    @FXML
    void btn_voltarFUN(ActionEvent event) {

    }
}