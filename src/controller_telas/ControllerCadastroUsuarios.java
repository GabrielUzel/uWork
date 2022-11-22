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
        String telefone = tfTelefone.getText();
        String pais = tfPais.getText();
        String estado = tfEstado.getText();
        String cep = tfCep.getText();
        String cidade = tfCidade.getText();
        String bairro = tfBairro.getText();
        String logradouro = tfLogradouro.getText();
        String complemento = tfComplemento.getText();
        String numero = tfNumero.getText();

        Usuario u = new Usuario(nome, Email, senha, Long.parseLong(telefone), pais, estado, Long.parseLong(cep), cidade, bairro, logradouro, complemento, Integer.parseInt(numero));
        
        UsuarioDAO ud = new UsuarioDAO();

        ClassAlerta alerta = new ClassAlerta();
        try {
            ud.criarUsuario(u);
            alerta.confirmacao("erro", e.getMessage(), "um erro aconteceu");
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