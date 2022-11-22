package controller_telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import DAO.VagaDAO;
import controller.ChamaOutraTela;
import controller.ClassAlerta;
import controller.ControllerVaga;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.CacheUsuario;
import model.Vaga;

public class ControllerCadastroVaga implements Initializable{
    private ChamaOutraTela chama = new ChamaOutraTela();
    private ControllerVaga controllerVaga = new ControllerVaga();
    private ClassAlerta alerta = new ClassAlerta();
    private String[] regimes = {"pj","clt"};

    @FXML
    private Button btn_cadastrar;

    @FXML
    private Button btn_cancelar;

    @FXML
    private TextField txt_nomeVaga;

    @FXML
    private ChoiceBox<String> cb_regime;

    @FXML
    private TextField txt_salario;

    @FXML
    private TextField txt_area;

    @FXML
    private TextField txt_descricao;

    @FXML
    private DatePicker dt_DataLimite;

    @FXML
    void btProximo(ActionEvent event) {
        int idVaga = -1;
        CacheUsuario ca = new CacheUsuario();

        String nomeVaga = txt_nomeVaga.getText();
        String regime = cb_regime.getValue();
        double salario = Double.parseDouble(txt_salario.getText());
        String area = txt_area.getText();
        String descricao = txt_descricao.getText();
        String status = "ativo";
        String gmail = ca.getUsuario();

        LocalDate limiteDate = dt_DataLimite.getValue();
        int dataLimiteDia = limiteDate.getDayOfMonth();
        int dataLimiteMes = limiteDate.getMonthValue();
        int dataLimiteAno = limiteDate.getYear();
        String dataLimite = ""+dataLimiteDia+"-"+dataLimiteMes+"-"+dataLimiteAno+"";
        Date dl = Date.valueOf(limiteDate);

        LocalDate dataAtual = LocalDate.now(); 
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int dataAtualDia = dataAtual.getDayOfMonth();
        int dataAtualMes = dataAtual.getMonthValue();
        int dataAtualAno = dataAtual.getYear();
        String dataAtualString = ""+dataAtualDia+"-"+dataAtualMes+"-"+dataAtualAno+"";
        Date dta = Date.valueOf(dataAtual);

        Vaga vaga = new Vaga(nomeVaga,regime,salario,area,descricao,status,dta,dl,gmail);

        VagaDAO vagaDAO = new VagaDAO();
        try {
            idVaga = vagaDAO.criarVaga(vaga);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        vaga.setIdVaga(idVaga);
        System.out.println("1- "+vaga.getIdVaga());
        System.out.println("2- "+idVaga);
        /*
        try {
            controllerVaga.cadastraVaga(txt_nomeVaga.getText(), txt_area.getText(), txt_descricao.getText(), 0, 0.0);
            alerta.informacao("Atenção", " Vaga cadastrada com sucesso", "uWork bom de mais");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            alerta.erro("erro", e.getMessage(), "um erro aconteceu");
        } catch (SQLException e) {
            alerta.erro("erro", e.getMessage(), "um erro aconteceu");
            e.printStackTrace();
        }

        try {
            chama.chamar("/view/BaseTela.fxml","Requisitos");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
    
    @FXML
    void btn_cancelarFUN(ActionEvent event) {
        txt_area.clear();
        txt_nomeVaga.clear();
        txt_descricao.clear();
        txt_salario.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cb_regime.getItems().addAll(regimes);
    }
}
