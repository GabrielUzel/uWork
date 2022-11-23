package controller_telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.SQLException;

import controller.ChamaOutraTela;
import controller.ClassAlerta;
import controller.ControllerVaga;
import model.Vaga;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ControllerExcluirVaga{
    private ControllerVaga controllerVaga = new ControllerVaga();
    private ClassAlerta alerta = new ClassAlerta();
    private Vaga vaga = new Vaga();
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
        txt_salarioExcluir.clear();
    }

    @FXML
    void btn_deletarFUn(ActionEvent event) {
       
            try {
                controllerVaga.deletarVaga(vaga);
                alerta.confirmacao("Erro",vaga.getNomeVaga()+" foi removida do uWork",null);
                txt_ExcluirVagaNome.clear();
                txt_areaExcluir.clear();
                txt_excluirDescricao.clear();
                txt_salarioExcluir.clear();
            } catch (ClassNotFoundException e) {
                alerta.erro("Erro", "Nao foi possivel deletar a vaga "+vaga.getNomeVaga(), e.getMessage());
                e.printStackTrace();
            } catch (SQLException e) {
                alerta.erro("Erro", "Nao foi possivel deletar a vaga "+vaga.getNomeVaga(), e.getMessage());
                e.printStackTrace();
            }
        
    }

    @FXML
    void btn_excluirPesquisarVagaFun(ActionEvent event) {
        try {
            vaga=controllerVaga.pesquisarVaga(txt_ExcluirVagaNome.getText());
            txt_areaExcluir.setText(vaga.getArea());
            txt_excluirDescricao.setText(vaga.getDescricao());
            txt_salarioExcluir.setText((String.valueOf(vaga.getSalario())));
        } catch (ClassNotFoundException e) {
            alerta.erro("Erro", "Nao foi possivel encontrar a vaga "+vaga.getNomeVaga(), e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            alerta.erro("Erro", "Nao foi possivel encontrar a vaga "+vaga.getNomeVaga(), e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
             alerta.erro("Erro", "Nao foi possivel encontrar a vaga "+vaga.getNomeVaga(), e.getMessage());
        }
       

    }


} 