package controller_telas;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import DAO.CandidaturaDAO;
import DAO.PessoaJuridicaDAO;
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
import model.CacheUsuario;
import model.PessoaJuridica;
import model.Vaga;

public class ControllerListarVagasCandidato implements Initializable {
    ChamaOutraTela outraTela = new ChamaOutraTela();
    ClassAlerta alerta = new ClassAlerta();
    private List<Vaga> vagas;
    private int indexVagaListada;
    private int idVagaAtual;
    CacheUsuario cacheUsuario = new CacheUsuario();

    @FXML
    private Button btn_voltar;

    @FXML
    private TextField tfNomeEmpresa;

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
        LocalDate dataAtual = LocalDate.now();
        Date dta = Date.valueOf(dataAtual);

        CandidaturaDAO cd = new CandidaturaDAO();

        try {
            cd.criarCanditadura("Ativo", dta, idVagaAtual, cacheUsuario.getUsuario());
            alerta.confirmacao("Sucesso", "Vaga candidatada com sucesso", null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
            PessoaJuridicaDAO ud = new PessoaJuridicaDAO();
            
            /*try {
                PessoaJuridica usu = ud.pesquisarPessoaJuridica(vagas.get(indexVagaListada).getEmail());
                tfNomeEmpresa.setText(usu.getRazaoSocial());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } */          
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
