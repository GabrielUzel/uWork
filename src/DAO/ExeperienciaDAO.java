package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import Model.Experiencia;
public class ExeperienciaDAO {
    public ExeperienciaDAO(){}

    public void criarExperiencia(Experiencia can)throws SQLException, ClassNotFoundException{
        
        String sql="insert into experiencia () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdCanditado());
        pst.setString(1, can.getCargo());
        pst.setString(3, can.getEmpresa());
        pst.setString(4, can.setAreaDeAtuacao());
        pst.setInt(5, can.getTempoServico());
        pst.close();
        conexao.close();
        
    }
    public Experiencia listarExperiencia(int id) throws SQLException, ClassNotFoundException{
        String sql="select * from experiencia where id=?";
        PreparedStatement pst;
        ResultSet rs;
        Experiencia experiencia = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            experiencia  = new Experiencia();
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

    public List <Experiencia> listarTodasExperiencias()throws SQLException, ClassNotFoundException{
        String sql="select * from experiencia";
        PreparedStatement pst;
        List <Experiencia> canditados = null;
        ResultSet rs;
        Experiencia experiencia = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            canditados = new ArrayList<Experiencia>();
            while(rs.next()){
                experiencia = new Experiencia();
                experiencia.setIdCanditado(rs.getInt("id"));
                experiencia.setCargo(rs.getString("cargo"));
                experiencia.setAreaDeAtuacao(rs.getString("areaDeAtuacao"));
                experiencia.setEmpresa(rs.getString("empresa"));
                experiencia.setTempoServico(rs.getInt("tempoDeServico"));
                canditados.add(experiencia);
            }
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return canditados;
    }
    public void atualizarExperiencia(Experiencia can)throws SQLException, ClassNotFoundException{
        String sql="update  experiencia set () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setInt(0, can.getIdCanditado());
        pst.setString(1, can.getCargo());
        pst.setString(3, can.getEmpresa());
        pst.setString(4, can.setAreaDeAtuacao());
        pst.setInt(5, can.getTempoServico());
        pst.close();
        conexao.close();
        
        
    }
    public void deletarExperiencia(Experiencia can)throws SQLException, ClassNotFoundException{
        String sql="delete from experiencia where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdCanditado());
        pst.execute();
        pst.close();
        conexao.close();
    }
}
