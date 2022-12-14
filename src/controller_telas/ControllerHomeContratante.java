package controller_telas;

import java.io.IOException;

import controller.ChamaOutraTela;
import controller.ClassAlerta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControllerHomeContratante {
    ClassAlerta alerta = new ClassAlerta();

    @FXML
    void btAdicionaVaga(ActionEvent event) {
        try {
            ChamaOutraTela cot = new ChamaOutraTela();
            cot.chamar("/view/CadastroVaga.fxml", "Cadastro vagas");
        } catch(IOException e) {
            e.printStackTrace();
            alerta.erro("Erro", e.getMessage(), "aconteceu um erro");
        }
    }

    @FXML
    void btListaVagas(ActionEvent event) {
        try {
            ChamaOutraTela cot = new ChamaOutraTela();
            cot.chamar("/view/ListarVagasPJ.fxml", "Listar Vagas");
        } catch(IOException e) {
            e.printStackTrace();
            alerta.erro("Erro", e.getMessage(), "aconteceu um erro");
        }
    }

    @FXML
    void btPerfil(ActionEvent event) {
         try {
            ChamaOutraTela cot = new ChamaOutraTela();
            cot.chamar("/view/PerfilUsuario.fxml", "Perfil do Usuario");
        } catch(IOException e) {
            e.printStackTrace();
            alerta.erro("Erro", e.getMessage(), "aconteceu um erro");
        }

    }

    @FXML
    void btRemoveVaga(ActionEvent event) {
         try {
            ChamaOutraTela cot = new ChamaOutraTela();
            cot.chamar("/view/ExcluirVaga.fxml", "Excluir Vaga");
        } catch(IOException e) {
            e.printStackTrace();
            alerta.erro("Erro", e.getMessage(), "aconteceu um erro");
        }

    }

    @FXML
    void btn_voltarFUN(ActionEvent event) {

    }
}