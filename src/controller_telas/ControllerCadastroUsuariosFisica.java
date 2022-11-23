package controller_telas;

import java.sql.SQLException;

import DAO.PessoaFisicaDAO;
import controller.ClassAlerta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.PessoaFisica;

public class ControllerCadastroUsuariosFisica {
    ClassAlerta classAlerta = new ClassAlerta();

    @FXML
    private Button btn_voltar;

    @FXML
    private TextField tfCpf;

    PessoaFisicaDAO pessoaFisicaDao = new PessoaFisicaDAO();

    @FXML
    void btn_cadastrarPessoaFisica(ActionEvent event){
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCPF(tfCpf.getText());
        //pessoaFisica.setCategoriaServico(categoriaServico);
        try {
            pessoaFisicaDao.criarPessoaFisica(pessoaFisica);
            classAlerta.confirmacao("Sucesso", "Sucesso ao cadastrar pessoa fisica", null);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void btn_voltarFUN(ActionEvent event){

    }
}