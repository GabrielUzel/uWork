package controller_telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import java.sql.SQLException;
import Controller.ChamaOutraTela;
import Controller.ClassAlerta;
import Controller.ControllerVaga;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ControllerCadastroVaga {
    private ChamaOutraTela chama = new ChamaOutraTela();
    private ControllerVaga conVaga = new ControllerVaga();
    private ClassAlerta alerta = new ClassAlerta();
    @FXML
    private Button btn_requisitos;

    @FXML
    private ChoiceBox<?> cb_regime;

    @FXML
    private TextField txt_area;

    @FXML
    private Button txt_cadastrar;

    @FXML
    private Button txt_cancelar;

    @FXML
    private TextField txt_descricao;

    @FXML
    private TextField txt_nomeVaga;

    @FXML
    private TextField txt_salario;
    
    @FXML
    void btn_cadastrarFUN(ActionEvent event) {
        try {
            conVaga.cadastraVaga(txt_nomeVaga.getText(), txt_area.getText(), txt_descricao.getText(), 0, 0.0);
            alerta.informacao("Atenção", " Vaga cadastrada com sucesso", "uWork bom de mais");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            alerta.erro("erro", e.getMessage(), "um erro aconteceu");
        } catch (SQLException e) {
            alerta.erro("erro", e.getMessage(), "um erro aconteceu");
            e.printStackTrace();
        }

    }

    @FXML
    void btn_cancelarFUN(ActionEvent event) {
        txt_area.clear();
        txt_nomeVaga.clear();
        txt_descricao.clear();
        txt_salario.clear();
    }

    @FXML
    void btn_requisitosFun(ActionEvent event) {
        try {
            chama.chamar("/View/BaseTela.fxml","Requisitos");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
