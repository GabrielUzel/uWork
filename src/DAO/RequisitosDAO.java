package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import Model.Requisitos;
public class RequisitosDAO {
   public RequisitosDAO(){}
   
   public void criarRequisitos(Requisitos can)throws SQLException, ClassNotFoundException{
        
    String sql="insert into requisitos () values(?,?,?)";
    PreparedStatement pst;
    Connection conexao = new ConectaBanco().conectar();
    pst = conexao.prepareStatement(sql);
    pst.setString(1, can.getNomeRequisito());
    pst.setString(3, can.getAreaAtuacao());
    pst.setInt(4, can.getIdVaga());
    pst.close();
    conexao.close();
    
}
public Requisitos listarRequisitos(int id) throws SQLException, ClassNotFoundException{
    String sql="select * from formacao where id=?";
    PreparedStatement pst;
    ResultSet rs;
    Requisitos formacao = null;
    Connection conexao = new ConectaBanco().conectar();
    pst = conexao.prepareStatement(sql);
    rs = pst.executeQuery();
    if(rs != null){
        formacao  = new Requisitos();
        formacao.setIdVaga(rs.getInt(id));
        formacao.setNomeRequisito(rs.getString("nome_requisito"));
        formacao.setAreaAtuacao(rs.getString("AreaAtuacao"));
        formacao.setDescricao(rs.getString("descricao"));
        
    }
    rs.close();
    pst.close();
    conexao.close();
    return formacao;
}

public List <Requisitos> listarTodosRequisitos()throws SQLException, ClassNotFoundException{
    String sql="select * from formacao";
    PreparedStatement pst;
    List <Requisitos> formacoes = null;
    ResultSet rs;
    Requisitos formacao = null;
    Connection conexao = new ConectaBanco().conectar();
    pst = conexao.prepareStatement(sql);
    rs = pst.executeQuery();
    if(rs != null){
        formacoes = new ArrayList<Requisitos>();
        while(rs.next()){
            formacao  = new Requisitos();
            formacao.setIdVaga(rs.getInt("id"));
            formacao.setNomeRequisito(rs.getString("nome_requisito"));
            formacao.setAreaAtuacao(rs.getString("AreaAtuacao"));
            formacao.setDescricao(rs.getString("descricao"));
            formacoes.add(formacao);
        }
        
    }
    rs.close();
    pst.close();
    conexao.close();
    return formacoes;
}
public void atualizarRequisitos(Requisitos can)throws SQLException, ClassNotFoundException{
    String sql="update  requitos set () values(?,?,?)";
    PreparedStatement pst;
    Connection conexao = new ConectaBanco().conectar();
    pst = conexao.prepareStatement(sql);
    pst.executeQuery();
    pst = conexao.prepareStatement(sql);
    pst.setString(1, can.getNomeRequisito());
    pst.setString(3, can.getAreaAtuacao());
    pst.setInt(4, can.getIdVaga());
    pst.close();
    conexao.close();
    
    
}
public void deletarRequisitos(Requisitos can)throws SQLException, ClassNotFoundException{
    String sql="delete from requisitos where id=?";
    PreparedStatement pst;
    Connection conexao = new ConectaBanco().conectar();
    pst = conexao.prepareStatement(sql);
    pst.setInt(0, can.getIdVaga());
    pst.execute();
    pst.close();
    conexao.close();
}
}
