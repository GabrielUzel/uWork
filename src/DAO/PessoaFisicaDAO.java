package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import Model.PessoaFisica;
public class PessoaFisicaDAO {
    public PessoaFisicaDAO(){}
    public void criarPessoaFisica(PessoaFisica can)throws SQLException, ClassNotFoundException{
        
        String sql="insert into pessoafisica () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setString(1, can.getCPF());
        pst.setString(2, can.getCategoriaServico());
        pst.close();
        conexao.close();
        
    }
    public PessoaFisica listarPessoaFisica(int id) throws SQLException, ClassNotFoundException{
        String sql="select * from pessoafisica where id=?";
        PreparedStatement pst;
        ResultSet rs;
        PessoaFisica pessoaFisica = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            pessoaFisica  = new PessoaFisica();
            pessoaFisica.setCPF(rs.getString("CPF"));
            pessoaFisica.setCategoriaServico(rs.getString("CategoriaServico"));
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return pessoaFisica ;
    }

    public List <PessoaFisica> listarTodasPessoasFisicas()throws SQLException, ClassNotFoundException{
        String sql="select * from pessoafisica";
        PreparedStatement pst;
        List <PessoaFisica> pessoasFisicas  = null;
        ResultSet rs;
        PessoaFisica  pessoaFisica  = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            pessoasFisicas  = new ArrayList<PessoaFisica >();
            while(rs.next()){
                pessoaFisica  = new PessoaFisica();
                pessoaFisica.setCPF(rs.getString("CPF"));
                pessoaFisica.setCategoriaServico(rs.getString("CategoriaServico"));
                pessoasFisicas .add(pessoaFisica);
            }
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return pessoasFisicas;
    }
    public void atualizarPessoaFisica(PessoaFisica can)throws SQLException, ClassNotFoundException{
        String sql="update  pessoafisica set () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setString(1, can.getCPF());
        pst.setString(2, can.getCategoriaServico());
        pst.close();
        conexao.close();
        
        
    }
    public void deletarExperiencia(PessoaFisica can)throws SQLException, ClassNotFoundException{
        String sql="delete from pessoafisica where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setString(0, can.getCPF());
        pst.execute();
        pst.close();
        conexao.close();
    }
}
