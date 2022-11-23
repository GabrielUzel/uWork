package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConectaBanco;
import model.CacheUsuario;
import model.PessoaJuridica;

public class PessoaJuridicaDAO {
    CacheUsuario cacheUsuario = new CacheUsuario();

    public PessoaJuridicaDAO(){}

    public void criarPessoaJuridica(PessoaJuridica pessoaJuridica) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO uwork.pj VALUES(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setLong(1, pessoaJuridica.getCNPJ());
        pst.setString(2, pessoaJuridica.getRazaoSocial());
        pst.setString(3, cacheUsuario.getUsuario());

        pst.execute();

        pst.close();
        conexao.close();
    }

    public PessoaJuridica pesquisarPessoaJuridica(String id) throws SQLException, ClassNotFoundException {
        String sql = "select * from uwork.pj where pj_fk_usuario_email=?";
        PreparedStatement pst;
        ResultSet rs;
        PessoaJuridica canditado = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null ){
            canditado = new PessoaJuridica();
            canditado.setCNPJ(rs.getLong("pj_cnpj"));
            canditado.setRazaoSocial(rs.getString("pj_razao_social"));
        }

        rs.close();
        pst.close();
        conexao.close();

        return canditado;
    }
    /*
    public List<PessoaJuridica> listarTodasPessoasJuridicas() throws SQLException, ClassNotFoundException {
        String sql = "select * from pessoaJuridica";
        PreparedStatement pst;
        List <PessoaJuridica> pessoasJuridicasList = null;
        ResultSet rs;
        PessoaJuridica pessoaJuridica = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            pessoasJuridicasList = new ArrayList<PessoaJuridica>();

            while(rs.next()) {
                pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setCNPJ(rs.getString("CNPJ"));
                pessoaJuridica.setRazaoSocial(rs.getString("RazaoSocial"));
                pessoasJuridicasList.add(pessoaJuridica);
            }
        }

        rs.close();
        pst.close();
        conexao.close();

        return pessoasJuridicasList;
    }

    
    public void atualizarPessoaJuridica(PessoaJuridica pessoaJuridica) throws SQLException, ClassNotFoundException {
        String sql = "update  pessoajuridica set () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setString(1, pessoaJuridica.getCNPJ());
        pst.setString(2, pessoaJuridica.getRazaoSocial());

        pst.close();
        conexao.close();
    }

    public void deletarPessoaJuridica(PessoaJuridica pessoaJuridica) throws SQLException, ClassNotFoundException {
        String sql = "delete from pessoafisica where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setString(1, pessoaJuridica.getCNPJ());
        pst.execute();
        pst.close();
        conexao.close();
    }*/
}
