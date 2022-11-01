package controller_telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import controller.ControllerCandidato;
import java.sql.SQLException;
import controller.ClassAlerta;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerCadastroUsuarios {
    private ControllerCandidato candidato = new ControllerCandidato();
    private ClassAlerta alerta = new ClassAlerta();

    @FXML
    private Button btn_criarConta;

    @FXML
    private Button btn_id;

    @FXML
    private TextField txt_cpf;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_endereco;

    @FXML
    private TextField txt_nome;

    @FXML
    private TextField txt_senha;

    @FXML
    private TextField txt_telefone;

    @FXML
    private TextField txt_telefone2;

    @FXML
    void btn_criarContaFUn(ActionEvent event) {
        try {
            // TO-DO: mudar o cadastra candidato de controller candidato para admitir email e senha
            candidato.cadastraCandidato(txt_nome.getText(), txt_nome.getText(), txt_cpf.getText(), txt_telefone.getText(), txt_senha.getText());
            alerta.informacao("Atenção", "Usuario cadastrado com sucesso", "uWork bom de mais");
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
