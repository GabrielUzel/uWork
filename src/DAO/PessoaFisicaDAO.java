package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import model.CacheUsuario;
import model.PessoaFisica;

public class PessoaFisicaDAO {
    public PessoaFisicaDAO(){}
    CacheUsuario cacheUsuario = new CacheUsuario();

    public void criarPessoaFisica(PessoaFisica pessoaFisica) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO uwork.pf VALUES(?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setLong(1, Long.parseLong(pessoaFisica.getCPF()));
        pst.setString(2, cacheUsuario.getUsuario());

        pst.execute();

        pst.close();
        conexao.close();
    }

    public PessoaFisica pesquisarPessoaFisica(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from pessoafisica where id=?";
        PreparedStatement pst;
        ResultSet rs;
        PessoaFisica pessoaFisica = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            pessoaFisica = new PessoaFisica();
            pessoaFisica.setCPF(rs.getString("CPF"));
            pessoaFisica.setCategoriaServico(rs.getString("CategoriaServico"));
        }

        rs.close();
        pst.close();
        conexao.close();

        return pessoaFisica;
    }

    public List<PessoaFisica> listarTodasPessoasFisicas() throws SQLException, ClassNotFoundException {
        String sql = "select * from pessoafisica";
        PreparedStatement pst;
        List<PessoaFisica> pessoasFisicasList = null;
        ResultSet rs;
        PessoaFisica  pessoaFisica  = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            pessoasFisicasList = new ArrayList<PessoaFisica>();

            while(rs.next()) {
                pessoaFisica  = new PessoaFisica();
                pessoaFisica.setCPF(rs.getString("CPF"));
                pessoaFisica.setCategoriaServico(rs.getString("CategoriaServico"));
                pessoasFisicasList.add(pessoaFisica);
            }
        }

        rs.close();
        pst.close();
        conexao.close();

        return pessoasFisicasList;
    }

    public void atualizarPessoaFisica(PessoaFisica pessoaFisica) throws SQLException, ClassNotFoundException {
        String sql = "update  pessoafisica set () values(?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setString(1, pessoaFisica.getCPF());
        pst.setString(2, pessoaFisica.getCategoriaServico());

        pst.close();
        conexao.close();
    }
    
    public void deletarPessoaFisica(PessoaFisica pessoaFisica) throws SQLException, ClassNotFoundException {
        String sql = "delete from pessoafisica where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setString(1, pessoaFisica.getCPF());
        pst.execute();
        pst.close();
        conexao.close();
    }
}
