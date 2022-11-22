package controller_telas;

import java.io.IOException;

import controller.ChamaOutraTela;
import controller.ClassAlerta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerHome {
    ClassAlerta alerta = new ClassAlerta();

    @FXML
    private Button adicionaVagas;

    @FXML
    private Button minhasVagas;

    @FXML
    private Button removeVagas;

    @FXML
    private Button perfil;

    @FXML
    private Button btn_voltar;

    @FXML
    private Button candidatarVagas;

    @FXML
    private Button descandidatarVagas;

    @FXML
    void btCandidataVagas(ActionEvent event) {
        try {
            ChamaOutraTela cot = new ChamaOutraTela();
            cot.chamar("/view/ListarVagasCandidato.fxml", "Candidatar vagas");
        } catch(IOException e) {
            alerta.erro("Erro", "aconteceu um erro",e.getMessage());
        }
    }

    @FXML
    void btDescandidataVagas(ActionEvent event) {
        
    }

    @FXML
    void btAdicionaVagas(ActionEvent event) {
        try {
            ChamaOutraTela cot = new ChamaOutraTela();
            cot.chamar("/view/CadastroVaga.fxml", "Cadastro vagas");
        } catch(IOException e) {
            e.printStackTrace();
            alerta.erro("Erro", e.getMessage(), "aconteceu um erro");
        }
    }

    @FXML
    void btBuscaVagas(ActionEvent event) {

    }

    @FXML
    void btPerfil(ActionEvent event) {

    }

    @FXML
    void btRemoveVagas(ActionEvent event) {

    }

    @FXML
    void btn_voltarFUN(ActionEvent event) {

    }
}