package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import Model.PessoaJuridica;
public class PessoaJuridicaDAO {
    public PessoaJuridicaDAO(){}
    public void criarPessoaFisica(PessoaJuridica can)throws SQLException, ClassNotFoundException{
        
        String sql="insert into pessoajuridica () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setString(1, can.getCNPJ());
        pst.setString(2, can.getRazaoSocial());
        pst.close();
        conexao.close();
        
    }
    public PessoaJuridica listarPessoaJuridica(int id) throws SQLException, ClassNotFoundException{
        String sql="select * from pessoajuridica where id=?";
        PreparedStatement pst;
        ResultSet rs;
        PessoaJuridica pessoaJuridica = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            pessoaJuridica  = new PessoaJuridica();
            pessoaJuridica.setCNPJ(rs.getString("CNPJ"));
            pessoaJuridica.setRazaoSocial(rs.getString("CategoriaServico"));
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return pessoaJuridica ;
    }

    public List <PessoaJuridica> listarTodasPessoasFisicas()throws SQLException, ClassNotFoundException{
        String sql="select * from pessoaJuridica";
        PreparedStatement pst;
        List <PessoaJuridica> pessoasJuridicas  = null;
        ResultSet rs;
        PessoaJuridica  pessoaJuridica  = null;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs != null){
            pessoasJuridicas  = new ArrayList<PessoaJuridica>();
            while(rs.next()){
                pessoaJuridica  = new PessoaJuridica();
                pessoaJuridica.setCNPJ(rs.getString("CNPJ"));
                pessoaJuridica.setRazaoSocial(rs.getString("RazaoSocial"));
                pessoasJuridicas .add(pessoaJuridica);
            }
            
        }
        rs.close();
        pst.close();
        conexao.close();
        return pessoasJuridicas;
    }
    public void atualizarPessoaFisica(PessoaJuridica can)throws SQLException, ClassNotFoundException{
        String sql="update  pessoajuridica set () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setString(1, can.getCNPJ());
        pst.setString(2, can.getRazaoSocial());
        pst.close();
        conexao.close();
        
        
    }
    public void deletarExperiencia(PessoaJuridica can)throws SQLException, ClassNotFoundException{
        String sql="delete from pessoafisica where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setString(0, can.getCNPJ());
        pst.execute();
        pst.close();
        conexao.close();
    }
    
}
