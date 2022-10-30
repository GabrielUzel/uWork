package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import model.PessoaJuridica;

public class PessoaJuridicaDAO {
    public PessoaJuridicaDAO(){}

    public void criarPessoaJuridica(PessoaJuridica pessoaJuridica) throws SQLException, ClassNotFoundException {
        String sql = "insert into pessoajuridica () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setString(1, pessoaJuridica.getCNPJ());
        pst.setString(2, pessoaJuridica.getRazaoSocial());

        pst.close();
        conexao.close();
    }

    public PessoaJuridica pesquisarPessoaJuridica(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from pessoajuridica where id=?";
        PreparedStatement pst;
        ResultSet rs;
        PessoaJuridica pessoaJuridica = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            pessoaJuridica = new PessoaJuridica();
            pessoaJuridica.setCNPJ(rs.getString("CNPJ"));
            pessoaJuridica.setRazaoSocial(rs.getString("CategoriaServico"));
        }

        rs.close();
        pst.close();
        conexao.close();

        return pessoaJuridica;
    }

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
    }
}
