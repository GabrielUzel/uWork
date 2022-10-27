package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import Model.Empregador;
public class EmpregadorDAO {
    public EmpregadorDAO(){}
    public void criarEmpregador(Empregador can)throws SQLException, ClassNotFoundException{
        
        String sql="insert into empregador () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdEmpregador());
        pst.setString(1, can.getNome());
        pst.setString(3, can.getSobrenome());
        pst.setString(4, can.getEmail());
        pst.setString(5, can.getTelefone());
        conexao.close();
        
    }
    public Empregador listarEmpregador(int id) throws SQLException, ClassNotFoundException{
        String sql="select * from empregador where id=?";
        PreparedStatement pst;
        ResultSet rs;
        Empregador empregador = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            empregador  = new Empregador();
            empregador .setIdEmpregador(rs.getInt(id));
            empregador .setNome(rs.getString("nome"));
            empregador .setSobrenome(rs.getString("sobrenome"));
            empregador .setEmail(rs.getString("email"));
            empregador .setTelefone(rs.getString("telefone"));
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return empregador;
    }

    public List <Empregador> listarTodosCandidatos()throws SQLException, ClassNotFoundException{
        String sql="select * from candidato";
        PreparedStatement pst;
        List <Empregador> canditados = null;
        ResultSet rs;
        Empregador canditado = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            canditados = new ArrayList<Empregador>();
            while(rs.next()){
                canditado = new Empregador();
                canditado.setIdEmpregador(rs.getInt("id"));
                canditado.setNome(rs.getString("nome"));
                canditado.setSobrenome(rs.getString("sobrenome"));
                canditado.setEmail(rs.getString("email"));
                canditado.setTelefone(rs.getString("telefone"));
                canditados.add(canditado);
            }
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return canditados;
    }
    public void atualizarEmpregador(Empregador can)throws SQLException, ClassNotFoundException{
        String sql="update  canditado set () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdEmpregador());
        pst.setString(1, can.getNome());
        pst.setString(3, can.getSobrenome());
        pst.setString(4, can.getEmail());
        pst.setString(5, can.getTelefone());
        
        
    }
    public void deletarEmpregador(Empregador can)throws SQLException, ClassNotFoundException{
        String sql="delete from candidato where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdEmpregador());
        pst.execute();
        pst.close();
        conexao.close();
    }
}

