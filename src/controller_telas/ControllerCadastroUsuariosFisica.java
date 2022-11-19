package controller_telas;

import java.sql.SQLException;

import DAO.PessoaFisicaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.PessoaFisica;

public class ControllerCadastroUsuariosFisica {

    @FXML
    private Button btn_voltar;

    @FXML
    private TextField tfCpf;

    PessoaFisicaDAO pessoaFisicaDao = new PessoaFisicaDAO();

    @FXML
    void btn_cadastrarPessoaFisica(ActionEvent event) throws ClassNotFoundException, SQLException {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCPF(tfCpf.getText());
        //pessoaFisica.setCategoriaServico(categoriaServico);
        pessoaFisicaDao.criarPessoaFisica(pessoaFisica);
    }

    @FXML
    void btn_voltarFUN(ActionEvent event){

    }
}