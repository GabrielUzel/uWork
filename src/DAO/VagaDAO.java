package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import model.Vaga;

public class VagaDAO {
    public VagaDAO() {}

    public void criarVaga(Vaga vaga) throws SQLException, ClassNotFoundException {
        String sql = "insert into vaga () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setInt(0, vaga.getIdVaga());
        pst.setString(1, vaga.getNome());
        pst.setString(3, vaga.getDescricao());
        pst.setString(4, vaga.getTipoRegime());
        pst.setDouble(5, vaga.getSalario());
        pst.setString(6, vaga.getAreaAtuacao());

        pst.close();
        conexao.close();
    }

    public Vaga pesquisarVaga(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from vaga where id=?";
        PreparedStatement pst;
        ResultSet rs;
        Vaga vaga = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            vaga = new Vaga();
            vaga.setIdVaga(rs.getInt(id));
            vaga.setNome(rs.getString("cargo"));
            vaga.setAreaAtuacao(rs.getString("areaDeAtuacao"));
            vaga.setDescricao(rs.getString("empresa"));
            vaga.setSalario(rs.getDouble("tempoDeServico"));
        }

        rs.close();
        pst.close();
        conexao.close();

        return vaga;
    }

    public List<Vaga> listarTodasVagas() throws SQLException, ClassNotFoundException {
        String sql = "select * from vaga";
        PreparedStatement pst;
        List<Vaga> vagasList = null;
        ResultSet rs;
        Vaga vaga = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            vagasList = new ArrayList<Vaga>();

            while(rs.next()){
                vaga = new Vaga();
                vaga.setIdVaga(rs.getInt("id"));
                vaga.setNome(rs.getString("cargo"));
                vaga.setAreaAtuacao(rs.getString("areaDeAtuacao"));
                vaga.setDescricao(rs.getString("empresa"));
                vaga.setSalario(rs.getDouble("tempoDeServico"));
                vagasList.add(vaga);
            }
        }

        rs.close();
        pst.close();
        conexao.close();

        return vagasList;
    }

    public void atualizarVaga(Vaga vaga) throws SQLException, ClassNotFoundException {
        String sql = "update  vaga set () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setInt(0, vaga.getIdVaga());
        pst.setString(1, vaga.getNome());
        pst.setString(3, vaga.getDescricao());
        pst.setString(4, vaga.getTipoRegime());
        pst.setDouble(5, vaga.getSalario());
        pst.setString(6, vaga.getAreaAtuacao());

        pst.close();
        conexao.close();
    }

    public void deletarVaga(Vaga vaga) throws SQLException, ClassNotFoundException {
        String sql = "delete from vaga where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, vaga.getIdVaga());
        pst.execute();
        pst.close();
        conexao.close();
    }
}
