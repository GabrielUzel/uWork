package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import model.Requisitos;

public class RequisitosDAO {
    public RequisitosDAO() {}

    public void criarRequisitos(Requisitos requisitos) throws SQLException, ClassNotFoundException {
        String sql = "insert into requisitos () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setString(1, requisitos.getNomeRequisito());
        pst.setString(2, requisitos.getAreaAtuacao());
        pst.setInt(3, requisitos.getIdVaga());

        pst.close();
        conexao.close();
    }

    public Requisitos pesquisarRequisitos(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from formacao where id=?";
        PreparedStatement pst;
        ResultSet rs;
        Requisitos requisito = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            requisito = new Requisitos();
            requisito.setIdVaga(rs.getInt(id));
            requisito.setNomeRequisito(rs.getString("nome_requisito"));
            requisito.setAreaAtuacao(rs.getString("AreaAtuacao"));
            requisito.setDescricao(rs.getString("descricao"));
        }

        rs.close();
        pst.close();
        conexao.close();

        return requisito;
    }

    public List<Requisitos> listarTodosRequisitos() throws SQLException, ClassNotFoundException {
        String sql = "select * from formacao";
        PreparedStatement pst;
        List<Requisitos> requisitosList = null;
        ResultSet rs;
        Requisitos formacao = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            requisitosList = new ArrayList<Requisitos>();

            while(rs.next()) {
                formacao = new Requisitos();
                formacao.setIdVaga(rs.getInt("id"));
                formacao.setNomeRequisito(rs.getString("nome_requisito"));
                formacao.setAreaAtuacao(rs.getString("AreaAtuacao"));
                formacao.setDescricao(rs.getString("descricao"));
                requisitosList.add(formacao);
            }
        }

        rs.close();
        pst.close();
        conexao.close();

        return requisitosList;
    }

    public void atualizarRequisitos(Requisitos requisitos) throws SQLException, ClassNotFoundException {
        String sql = "update  requitos set () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setString(1, requisitos.getNomeRequisito());
        pst.setString(2, requisitos.getAreaAtuacao());
        pst.setInt(3, requisitos.getIdVaga());

        pst.close();
        conexao.close();
    }

    public void deletarRequisitos(Requisitos requisitos) throws SQLException, ClassNotFoundException {
        String sql = "delete from requisitos where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, requisitos.getIdVaga());
        pst.execute();
        pst.close();
        conexao.close();
    }
}
