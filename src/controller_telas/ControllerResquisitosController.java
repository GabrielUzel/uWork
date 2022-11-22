package controller_telas;

import controller.ControllerRequisitos;
import controller.ClassAlerta;

import java.io.IOException;
import java.sql.SQLException;

import controller.ChamaOutraTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

public class ControllerResquisitosController {
    private ControllerRequisitos requisitos = new ControllerRequisitos();
    private ClassAlerta alertas = new ClassAlerta();
    private ChamaOutraTela outraTela = new ChamaOutraTela();
    @FXML
    private Button btn_addrequisito;

    @FXML
    private Button btn_deletar;

    @FXML
    private Button btn_voltar;

    @FXML
    private TextField txt_area;

    @FXML
    private TextField txt_descricao;

    @FXML
    private TextField txt_nome;

    @FXML
    private TableView<?> tb_requisitos;

     @FXML
    void btn_adicionarRequisito(ActionEvent event) {
        try {
            requisitos.cadastrarRequisitos(txt_nome.getText(), txt_area.getText(), txt_descricao.getText(), 0);
        } catch (ClassNotFoundException e) {
            alertas.erro("Erro","Não foi possivel adicionar requisitos","procure o adiminstrador do sistema "+e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            alertas.erro("Erro","Não foi possivel adicionar requisitos","erro ao conectar ao banco de dados "+e.getMessage());
            e.printStackTrace();
           
        }

    }

    @FXML
    void btn_deletarRequisito(ActionEvent event) {
        try {
            requisitos.deletarRequisitos(txt_nome.getText());
        } catch (ClassNotFoundException e) {
            alertas.erro("Erro","Não foi possivel excluir requisitos","procure o adiminstrador do sistema "+e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            alertas.erro("Erro","Não foi possivel excluir requisitos","erro ao conectar ao banco de dados "+e.getMessage());
            e.printStackTrace();
           
        }
    }

    @FXML
    void btn_voltarRequisito(ActionEvent event) {
        try {
            outraTela.chamar("/view/BaseTela.fxml", "Inicio");
        } catch (IOException e) {
            alertas.erro("Erro","Não foi possivel chamar a tela base","provavel erro no caminha da pasta"+e.getMessage());
            e.printStackTrace();
        }
    }

}
