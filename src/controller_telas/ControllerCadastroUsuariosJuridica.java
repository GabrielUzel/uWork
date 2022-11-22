package controller_telas;

import java.sql.SQLException;

import DAO.PessoaJuridicaDAO;
import controller.ClassAlerta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.PessoaJuridica;

public class ControllerCadastroUsuariosJuridica {
    ClassAlerta alerta = new ClassAlerta();

    @FXML
    private Button btn_voltar;

    @FXML
    private TextField tfCnpj;

    @FXML
    private TextField tfRazaoSicial;

    @FXML
    void btn_cadastrarPessoaJuridica(ActionEvent event) {
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCNPJ(Long.parseLong(tfCnpj.getText()));
        pj.setRazaoSocial(tfRazaoSicial.getText());
        PessoaJuridicaDAO pjd = new PessoaJuridicaDAO();
        try {
            pjd.criarPessoaJuridica(pj);
            alerta.confirmacao("sucesso", "Usuário jurídico cadastrado com sucesso", null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btn_voltarFUN(ActionEvent event) {

    }

}