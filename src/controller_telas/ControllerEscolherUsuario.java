package controller_telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConectaBanco;
import controller.ChamaOutraTela;
import controller.ClassAlerta;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerEscolherUsuario {
    private ChamaOutraTela tela = new ChamaOutraTela();
    private ClassAlerta alerta = new ClassAlerta();

    private static String id;

    @FXML
    void btn_cadastrarPessoaFisica(ActionEvent event) {
        try {
            tela.chamar("/view/CadastroUsuarioFisica.fxml","Cadastro de Usuario Pessoa Fisica");
        } catch(IOException e) {
            e.printStackTrace();
            alerta.erro("Erro", e.getMessage(), "aconteceu um erro");
        }
    }

    @FXML
    void btn_cadastrarPessoaJuridica(ActionEvent event) {
        try {
            tela.chamar("/view/CadastroUsuarioJuridica.fxml","Cadastro de Usuario Pessoa Juridica");
        } catch(IOException e) {
            e.printStackTrace();
            alerta.erro("Erro", e.getMessage(), "aconteceu um erro");
        }
    }

    @FXML
    void btn_entrarPessoaFisica(ActionEvent event) {
        PreparedStatement stmt;
        Connection conexao;
        ResultSet rs;
        boolean check = false;
        String id2=null;
        try {
            String sql = "Select * from uwork.pf where pf_fk_usuario_email = '"+ id+"';";
            conexao = new ConectaBanco().conectar();
            stmt = conexao.prepareStatement(sql);

            rs = stmt.executeQuery();
            
            while(rs.next()){
                check=true;
                System.out.println(rs.getString("pf_Cpf"));
                id2=rs.getString("pf_fk_usuario_email");
            }
            
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        if(!check){
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
        }else{
            try {
                ControllerHome ch = new ControllerHome();
                ch.chamar("/view/Home.fxml", "Tela inicial", id2);
            } catch(IOException e) {
                e.printStackTrace();
                alerta.erro("Erro", e.getMessage(), "aconteceu um erro");
            }
        }
    }

    @FXML
    void btn_entrarPessoaJuridica(ActionEvent event) {
        PreparedStatement stmt;
        Connection conexao;
        ResultSet rs;
        boolean check = false;
        String id2=null;
        try {
            String sql = "Select * from uwork.pj where pj_fk_usuario_email = '"+ id+"';";
            conexao = new ConectaBanco().conectar();
            stmt = conexao.prepareStatement(sql);

            rs = stmt.executeQuery();
            
            while(rs.next()){
                check=true;
                System.out.println(rs.getString("pj_cnpj"));
                id2=rs.getString("pj_fk_usuario_email");
            }
            
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        if(!check){
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
        }else{
            try {
                ControllerHome ch = new ControllerHome();
                ch.chamar("/view/Home.fxml", "Tela inicial", id2);
            } catch(IOException e) {
                e.printStackTrace();
                alerta.erro("Erro", e.getMessage(), "aconteceu um erro");
            }
        }
    }

    public void chamar(String caminhoTela, String titulo, String pid) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(caminhoTela));
        Scene scene = new Scene(root);
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();
        stage.resizableProperty().setValue(false);
        id=pid;
    }
}
