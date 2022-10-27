package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import Model.Vaga;
public class VagaDAO {
    public VagaDAO(){}

    public void criarVaga(Vaga can)throws SQLException, ClassNotFoundException{
        
        String sql="insert into vaga () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdVaga());
        pst.setString(1, can.getNome());
        pst.setString(3, can.getDescricao());
        pst.setString(4, can.getTipoRegime());
        pst.setDouble(5, can.getSalario());
        pst.setString(6, can.getAreaAtuacao());
        pst.close();
        conexao.close();
        
    }
    public Vaga listarVaga(int id) throws SQLException, ClassNotFoundException{
        String sql="select * from vaga where id=?";
        PreparedStatement pst;
        ResultSet rs;
        Vaga experiencia = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            experiencia  = new Vaga();
            experiencia.setIdVaga(rs.getInt(id));
            experiencia.setNome(rs.getString("cargo"));
            experiencia.setAreaAtuacao(rs.getString("areaDeAtuacao"));
            experiencia.setDescricao(rs.getString("empresa"));
            experiencia.setSalario(rs.getDouble("tempoDeServico"));
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return experiencia;
    }

    public List <Vaga> listarTodasVagas()throws SQLException, ClassNotFoundException{
        String sql="select * from vaga";
        PreparedStatement pst;
        List <Vaga> canditados = null;
        ResultSet rs;
        Vaga experiencia = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            canditados = new ArrayList<Vaga>();
            while(rs.next()){
                experiencia = new Vaga();
                experiencia.setIdVaga(rs.getInt("id"));
                experiencia.setNome(rs.getString("cargo"));
                experiencia.setAreaAtuacao(rs.getString("areaDeAtuacao"));
                experiencia.setDescricao(rs.getString("empresa"));
                experiencia.setSalario(rs.getDouble("tempoDeServico"));
                canditados.add(experiencia);
            }
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return canditados;
    }
    public void atualizarVaga(Vaga can)throws SQLException, ClassNotFoundException{
        String sql="update  vaga set () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setInt(0, can.getIdVaga());
        pst.setString(1, can.getNome());
        pst.setString(3, can.getDescricao());
        pst.setString(4, can.getTipoRegime());
        pst.setDouble(5, can.getSalario());
        pst.setString(6, can.getAreaAtuacao());
        pst.close();
        conexao.close();
        
        
    }
    public void deletarExperiencia(Vaga can)throws SQLException, ClassNotFoundException{
        String sql="delete from vaga where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdVaga());
        pst.execute();
        pst.close();
        conexao.close();
    }
}
