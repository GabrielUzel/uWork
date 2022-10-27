package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConectaBanco;
import Model.Canditado;
public class CandidatoDAO {
    public CandidatoDAO(){}
    public void criarCanditado(Canditado can)throws SQLException, ClassNotFoundException{
        
        String sql="insert into canditado () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdCanditado());
        pst.setString(1, can.getNome());
        pst.setString(2, can.getCPF());
        pst.setString(3, can.getSobrenome());
        pst.setString(4, can.getEmail());
        pst.setString(5, can.getTelefone());
        pst.setDate(6, (Date) can.getDataNascimento());
        conexao.close();
        
    }
    public Canditado pesquisarCandidato(int id) throws SQLException, ClassNotFoundException{
        String sql="select * from candidato where id=?";
        PreparedStatement pst;
        ResultSet rs;
        Canditado canditado = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            canditado = new Canditado();
            canditado.setIdCanditado(rs.getInt("id"));
            canditado.setNome(rs.getString("nome"));
            canditado.setSobrenome(rs.getString("sobrenome"));
            canditado.setEmail(rs.getString("email"));
            canditado.setTelefone(rs.getString("telefone"));
            canditado.setDataNascimento(rs.getDate("data nascimento"));
        }
        rs.close();
        pst.close();
        conexao.close();
        return canditado;
    }

    public List <Canditado> listarTodosCandidatos()throws SQLException, ClassNotFoundException{
        String sql="select * from candidato";
        PreparedStatement pst;
        List <Canditado> canditados = null;
        ResultSet rs;
        Canditado canditado = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            canditados = new ArrayList<Canditado>();
            while(rs.next()){
                canditado = new Canditado();
                canditado.setIdCanditado(rs.getInt("id"));
                canditado.setNome(rs.getString("nome"));
                canditado.setSobrenome(rs.getString("sobrenome"));
                canditado.setEmail(rs.getString("email"));
                canditado.setTelefone(rs.getString("telefone"));
                canditado.setDataNascimento(rs.getDate("data nascimento"));
                canditados.add(canditado);
            }
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return canditados;
    }
    public void atualizarCandidato(Canditado can)throws SQLException, ClassNotFoundException{
        String sql="update  canditado set () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdCanditado());
        pst.setString(1, can.getNome());
        pst.setString(2, can.getCPF());
        pst.setString(3, can.getSobrenome());
        pst.setString(4, can.getEmail());
        pst.setString(5, can.getTelefone());
        pst.setDate(6, (Date) can.getDataNascimento());
        
    }
    public void deletarCandidato(Canditado can)throws SQLException, ClassNotFoundException{
        String sql="delete from candidato where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(0, can.getIdCanditado());
        pst.execute();
        pst.close();
        conexao.close();
    }
}
