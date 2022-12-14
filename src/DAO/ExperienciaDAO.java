package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import model.Experiencia;

public class ExperienciaDAO {
    public ExperienciaDAO() {}

    public void criarExperiencia(Experiencia experiencia) throws SQLException, ClassNotFoundException {
        String sql = "insert into experiencia () values(?,?,?,?,?)";
        
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, experiencia.getIdCanditado());
        pst.setString(2, experiencia.getCargo());
        pst.setString(3, experiencia.getEmpresa());
        pst.setString(4, experiencia.setAreaDeAtuacao());
        pst.setInt(5, experiencia.getTempoServico());
        
        pst.close();
        conexao.close();
    }

    public Experiencia pesquisarExperiencia(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from experiencia where id=?";
        PreparedStatement pst;
        ResultSet rs;
        Experiencia experiencia = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            experiencia = new Experiencia();
            experiencia.setIdCanditado(rs.getInt(id));
            experiencia.setCargo(rs.getString("cargo"));
            experiencia.setAreaDeAtuacao(rs.getString("areaDeAtuacao"));
            experiencia.setEmpresa(rs.getString("empresa"));
            experiencia.setTempoServico(rs.getInt("tempoDeServico"));
        }

        rs.close();
        pst.close();
        conexao.close();

        return experiencia;
    }

    public List<Experiencia> listarTodasExperiencias() throws SQLException, ClassNotFoundException {
        String sql = "select * from experiencia";
        PreparedStatement pst;
        List <Experiencia> experienciasList = null;
        ResultSet rs;
        Experiencia experiencia = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            experienciasList = new ArrayList<Experiencia>();

            while(rs.next()) {
                experiencia = new Experiencia();
                experiencia.setIdCanditado(rs.getInt("id"));
                experiencia.setCargo(rs.getString("cargo"));
                experiencia.setAreaDeAtuacao(rs.getString("areaDeAtuacao"));
                experiencia.setEmpresa(rs.getString("empresa"));
                experiencia.setTempoServico(rs.getInt("tempoDeServico"));
                experienciasList.add(experiencia);
            }
        }

        rs.close();
        pst.close();
        conexao.close();

        return experienciasList;
    }

    public void atualizarExperiencia(Experiencia experiencia) throws SQLException, ClassNotFoundException {
       String sql = "update  experiencia set () values(?,?,?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        
        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, experiencia.getIdCanditado());
        pst.setString(2, experiencia.getCargo());
        pst.setString(3, experiencia.getEmpresa());
        pst.setString(4, experiencia.setAreaDeAtuacao());
        pst.setInt(5, experiencia.getTempoServico());
        
        pst.close();
        conexao.close();
    }

    public void deletarExperiencia(Experiencia experiencia) throws SQLException, ClassNotFoundException {
        String sql = "delete from experiencia where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setInt(0, experiencia.getIdCanditado());
        pst.execute();
        pst.close();
        conexao.close();
    }
}
