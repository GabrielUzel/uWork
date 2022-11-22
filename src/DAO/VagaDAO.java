package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConectaBanco;
import model.Vaga;

public class VagaDAO {
    public VagaDAO() {}

    public int criarVaga(Vaga vaga) throws SQLException, ClassNotFoundException {
        int idVaga = -1;
        
        String sql = "INSERT INTO uwork.vaga (v_nome, v_area_atuacao,v_regime,v_descricao,v_salario,v_data_criacao, v_data_limite, v_status , v_fk_Usuario_email) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?);";
        PreparedStatement pst;
        ResultSet rs = null;
        Connection conexao = new ConectaBanco().conectar();
        
        pst = conexao.prepareStatement(sql);
        pst.setString(1, vaga.getNomeVaga());
        pst.setString(2, vaga.getArea());
        pst.setString(3, vaga.getRegime());
        pst.setString(4, vaga.getDescricao());
        pst.setDouble(5, vaga.getSalario());
        pst.setDate(6, vaga.getDataAtualString());
        pst.setDate(7, vaga.getDataLimite());
        pst.setString(8, vaga.getStatus());
        pst.setString(9, vaga.getEmail());

        pst.execute();

        rs = pst.getGeneratedKeys();
        System.out.println("resset "+rs);
        while(rs.next()){
            idVaga = rs.getInt("v_id");
            System.out.println(idVaga);
        }

        pst.close();
        rs.close();
        conexao.close();

        return idVaga;
    }
/*
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
         String sql="update  vaga set () values(?,?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        
        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setInt(1, vaga.getIdVaga());
        pst.setString(2, vaga.getNome());
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
        pst.setInt(1, vaga.getIdVaga());
        pst.execute();
        pst.close();
        conexao.close();
    }*/
}
