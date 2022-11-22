package controller_telas;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import DAO.VagaDAO;
import controller.ChamaOutraTela;
import controller.ClassAlerta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Vaga;

public class ControllerListarVagasCandidato implements Initializable {
    ChamaOutraTela outraTela = new ChamaOutraTela();
    ClassAlerta alerta = new ClassAlerta();
    private List<Vaga> vagas;
    private int indexVagaListada;
    private int idVagaAtual;

    @FXML
    private Button btn_voltar;

    @FXML
    private Label tfNomeEmpresa;

    @FXML
    private TextArea taDescricao;

    @FXML
    private TextField tfNomeVaga;

    @FXML
    private TextField tfArea;

    @FXML
    private TextField tfSalario;

    @FXML
    private TextField tfRegime;

    @FXML
    void btCandidatar(ActionEvent event) {
    }
    
    @FXML
    void btProximaVaga(ActionEvent event) {
        apresentarVaga();
    }

    @FXML
    void btn_voltarFUN(ActionEvent event) {
    }

    public void apresentarVaga(){
        if(indexVagaListada>=vagas.size()){
            alerta.erro("Erro", "Não Foi possivel listar a proxima vaga", "Todas as vagas ja foram listadas");
        }else{
            idVagaAtual = vagas.get(indexVagaListada).getIdVaga();
            tfNomeVaga.setText(vagas.get(indexVagaListada).getNomeVaga());
            tfArea.setText(vagas.get(indexVagaListada).getArea());
            tfSalario.setText(""+vagas.get(indexVagaListada).getSalario());
            tfRegime.setText(vagas.get(indexVagaListada).getRegime());
            taDescricao.setText(vagas.get(indexVagaListada).getDescricao());
            indexVagaListada++;
        }
    }
    
    public void listaVagas(){
        VagaDAO vd = new VagaDAO();
        try {
            vagas = vd.listarTodasVagas();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        indexVagaListada = 0;
        listaVagas();
        apresentarVaga();
    }
}
