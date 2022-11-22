package controller_telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import DAO.VagaDAO;
import controller.ChamaOutraTela;
import controller.ClassAlerta;
import controller.ControllerVaga;
import model.Vaga;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ControllerExcluirVaga{
    private ControllerVaga controllerVaga = new ControllerVaga();
    private ClassAlerta alerta = new ClassAlerta();
    private Vaga vaga;
    public ControllerExcluirVaga(){}
     @FXML
    private Button btn_cancelar;

    @FXML
    private Button btn_deletar;

    @FXML
    private Button btn_excluirPesquisarVaga;

    @FXML
    private ChoiceBox<?> cb_excluirVaga;

    @FXML
    private TextField txt_ExcluirVagaNome;

    @FXML
    private TextField txt_areaExcluir;

    @FXML
    private TextField txt_excluirDescricao;

    @FXML
    private TextField txt_salarioExcluir;

    @FXML
    void btn_cancelarFun(ActionEvent event) {
        txt_ExcluirVagaNome.clear();
        txt_areaExcluir.clear();
        txt_excluirDescricao.clear();
        txt_salario.clear();
    }

    @FXML
    void btn_deletarFUn(ActionEvent event) {
        controllerVaga.deletarVaga(vaga);
    }

    @FXML
    void btn_excluirPesquisarVagaFun(ActionEvent event) {
        vaga=controllerVaga.pesquisarVaga(txt_ExcluirVagaNome.getText());
        txt_area.getText(vaga.getArea());
        txt_excluirDescricao.getText(vaga.getDescricao());
        txt_salario.getText(vaga.getSalario());

    }


} 