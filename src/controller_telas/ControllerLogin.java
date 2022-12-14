package controller_telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import connection.ConectaBanco;
import controller.RecID;
import javafx.scene.control.PasswordField;
import controller.ChamaOutraTela;
import controller.ClassAlerta;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.CacheUsuario;


public class ControllerLogin {
    private ChamaOutraTela tela = new ChamaOutraTela();
    private ClassAlerta alerta = new ClassAlerta();

    @FXML
    private Button btn_entrar;

    @FXML
    private Button txt_cadastrar;

    @FXML
    private TextField txt_email;

    @FXML
    private Button txt_recsenha;

    @FXML
    private PasswordField txt_senha;
    
    @FXML
    void btn_cadastrarFUN(ActionEvent event) {
        try {
            tela.chamar("/view/CadastroUsuario.fxml","Cadastro de Usuario");
        } catch(IOException e) {
            e.printStackTrace();
            alerta.erro("Erro", e.getMessage(), "aconteceu um erro");
        }
    }

    @FXML
    void btn_entrarFUN(ActionEvent event) {
        CacheUsuario cacheUsuario = new CacheUsuario();
        PreparedStatement stmt;
        Connection conexao;
        ResultSet rs;
        boolean check = false;
        String id = null;

        try {
            String sql = "Select * from uwork.usuario where u_email = '" + txt_email.getText() + "' AND u_senha='" + txt_senha.getText() + "';";
            conexao = new ConectaBanco().conectar();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                check = true;
                System.out.println(rs.getString("u_email"));
                id = rs.getString("u_email");
                RecID.setNome(rs.getString("u_nome"));
                RecID.setEmail(rs.getString("u_email"));
                RecID.setBairro(rs.getString("u_logradouro"));
                RecID.setComplemento(rs.getString("u_complemento"));
                RecID.setNumero(rs.getInt("u_numero"));
                RecID.setCidade(rs.getString("u_cidade"));
                RecID.setPais(rs.getString("u_pais"));
                RecID.setCep(rs.getInt("u_cep"));
                RecID.setTelefone(rs.getInt("u_telefone"));
                RecID.setEstado(rs.getString("u_estado"));
                cacheUsuario.setUsuario(id);
            }
            
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        if(!check) {
            JOptionPane.showMessageDialog(null, "Usu??rio ou senha incorretos!");
        } else {
            try {
                ControllerEscolherUsuario eu = new ControllerEscolherUsuario();
                eu.chamar("/view/EscolherUsuario.fxml", "Escolher Usu??rio", id);
            } catch(IOException e) {
                e.printStackTrace();
                alerta.erro("Erro", e.getMessage(), "aconteceu um erro");
            }
        }
    }

    @FXML
    void txt_esquiFUN(ActionEvent event) {

    }
}
