package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import Model.Formacao;

public class FormacaoDAO {
    public FormacaoDAO(){}
    public void criarFormacao(Formacao can)throws SQLException, ClassNotFoundException{
        
        String sql="insert into formacao () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdCanditado());
        pst.setString(1, can.getCurso());
        pst.setString(3, can.getInstituição());
        pst.setInt(4, can.getTempoDuracao());
        pst.close();
        conexao.close();
        
    }
    public Formacao listarFormacao(int id) throws SQLException, ClassNotFoundException{
        String sql="select * from formacao where id=?";
        PreparedStatement pst;
        ResultSet rs;
        Formacao formacao = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            formacao  = new Formacao();
            formacao.setIdCanditado(rs.getInt(id));
            formacao.setInstituição(rs.getString("instituicao"));
            formacao.setCurso(rs.getString("curso"));
            formacao.setTempoDuracao(rs.getInt("tempoDeDuracao"));
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return formacao;
    }

    public List <Formacao> listarTodasFormacoes()throws SQLException, ClassNotFoundException{
        String sql="select * from formacao";
        PreparedStatement pst;
        List <Formacao> formacoes = null;
        ResultSet rs;
        Formacao formacao = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            formacoes = new ArrayList<Formacao>();
            while(rs.next()){
                formacao  = new Formacao();
                formacao.setIdCanditado(rs.getInt("id"));
                formacao.setInstituição(rs.getString("instituicao"));
                formacao.setCurso(rs.getString("curso"));
                formacao.setTempoDuracao(rs.getInt("tempoDeDuracao"));
                formacoes.add(formacao);
            }
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return formacoes;
    }
    public void atualizarExperiencia(Formacao can)throws SQLException, ClassNotFoundException{
        String sql="update  formacao set () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setInt(0, can.getIdCanditado());
        pst.setString(1, can.getCurso());
        pst.setString(3, can.getInstituição());
        pst.setInt(4, can.getTempoDuracao());
        pst.close();
        conexao.close();
        
        
    }
    public void deletarExperiencia(Formacao can)throws SQLException, ClassNotFoundException{
        String sql="delete from formacao where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdCanditado());
        pst.execute();
        pst.close();
        conexao.close();
    }
    
}
