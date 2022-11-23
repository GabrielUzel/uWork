package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import model.Formacao;

public class FormacaoDAO {
    public FormacaoDAO() {}

    public void criarFormacao(Formacao formacao) throws SQLException, ClassNotFoundException {
        String sql = "insert into formacao () values(?,?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setInt(1, formacao.getIdCanditado());
        pst.setString(2, formacao.getCurso());
        pst.setString(3, formacao.getInstituição());
        pst.setInt(4, formacao.getTempoDuracao());
        
        pst.close();
        conexao.close();
    }

    public Formacao pesquisarFormacao(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from formacao where id=?";
        PreparedStatement pst;
        ResultSet rs;
        Formacao formacao = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            formacao = new Formacao();
            formacao.setIdCandidato(rs.getInt(id));
            formacao.setInstituição(rs.getString("instituicao"));
            formacao.setCurso(rs.getString("curso"));
            formacao.setTempoDuracao(rs.getInt("tempoDeDuracao"));
        }

        rs.close();
        pst.close();
        conexao.close();

        return formacao;
    }

    public List<Formacao> listarTodasFormacoes() throws SQLException, ClassNotFoundException {
        String sql = "select * from formacao";
        PreparedStatement pst;
        List<Formacao> formacoesList = null;
        ResultSet rs;
        Formacao formacao = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            formacoesList = new ArrayList<Formacao>();

            while(rs.next()) {
                formacao = new Formacao();
                formacao.setIdCandidato(rs.getInt("id"));
                formacao.setInstituição(rs.getString("instituicao"));
                formacao.setCurso(rs.getString("curso"));
                formacao.setTempoDuracao(rs.getInt("tempoDeDuracao"));
                formacoesList.add(formacao);
            }
        }

        rs.close();
        pst.close();
        conexao.close();

        return formacoesList;
    }

    public void atualizarFormacao(Formacao formacao) throws SQLException, ClassNotFoundException {
        String sql = "update  formacao set () values(?,?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setInt(1, formacao.getIdCanditado());
        pst.setString(2, formacao.getCurso());
        pst.setString(3, formacao.getInstituição());
        pst.setInt(4, formacao.getTempoDuracao());
        
        pst.close();
        conexao.close();
    }

    public void deletarFormacao(Formacao formacao) throws SQLException, ClassNotFoundException {
        String sql = "delete from formacao where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setInt(1, formacao.getIdCanditado());
        pst.execute();
        pst.close();
        conexao.close();
    }
}
