package controller_telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import Controller.ChamaOutraTela;
import Controller.ClassAlerta;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerLogin{
    private ChamaOutraTela tela = new ChamaOutraTela();
    private ClassAlerta alerta = new ClassAlerta();
    @FXML
    private Button btn_entrar;

    @FXML
    private Button txt_cadastrar;

    @FXML
    private TextField txt_email;

    @FXML
    private Button txt_recsenha;

    @FXML
    private TextField txt_senha;
    
    @FXML
    void btn_cadastrarFUN(ActionEvent event) {
        try {
            tela.chamar("/View/CadastroUsuario.fxml","Cadastro de Usuario");
        } catch (IOException e) {
            e.printStackTrace();
            alerta.erro("Erro", e.getMessage(), "aconteceu um erro");

        }
    }

    @FXML
    void btn_entrarFUN(ActionEvent event) {

    }

    @FXML
    void txt_esquiFUN(ActionEvent event) {

    }
}
