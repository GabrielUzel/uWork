package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConectaBanco;
import java.util.ArrayList;
import java.util.List;
import model.Empregador;

public class EmpregadorDAO {
    public EmpregadorDAO() {}

    public void criarEmpregador(Empregador empregador) throws SQLException, ClassNotFoundException {
       String sql = "insert into empregador () values(?,?,?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, empregador.getIdEmpregador());
        pst.setString(2, empregador.getNome());
        pst.setString(3, empregador.getSobrenome());
        pst.setString(5, empregador.getEmail());
        pst.setString(6, empregador.getTelefone());
        conexao.close();
    }

    public Empregador pesquisarEmpregador(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from empregador where id=?";
        PreparedStatement pst;
        ResultSet rs;
        Empregador empregador = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            empregador = new Empregador();
            empregador.setIdEmpregador(rs.getInt(id));
            empregador.setNome(rs.getString("nome"));
            empregador.setSobrenome(rs.getString("sobrenome"));
            empregador.setEmail(rs.getString("email"));
            empregador.setTelefone(rs.getString("telefone"));
        }

        rs.close();
        pst.close();
        conexao.close();

        return empregador;
    }

    public List<Empregador> listarTodosEmpregadores() throws SQLException, ClassNotFoundException {
        String sql = "select * from empregadordidato";
        PreparedStatement pst;
        List <Empregador> empregadoresList = null;
        ResultSet rs;
        Empregador empregador = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            empregadoresList = new ArrayList<Empregador>();

            while(rs.next()) {
                empregador = new Empregador();
                empregador.setIdEmpregador(rs.getInt("id"));
                empregador.setNome(rs.getString("nome"));
                empregador.setSobrenome(rs.getString("sobrenome"));
                empregador.setEmail(rs.getString("email"));
                empregador.setTelefone(rs.getString("telefone"));
                empregadoresList.add(empregador);
            }
        }

        rs.close();
        pst.close();
        conexao.close();
        
        return empregadoresList;
    }

    public void atualizarEmpregador(Empregador empregador) throws SQLException, ClassNotFoundException {
        String sql="update  contratante set () values(?,?,?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, empregador.getIdEmpregador());
        pst.setString(2, empregador.getNome());
        pst.setString(3, empregador.getSobrenome());
        pst.setString(5, empregador.getEmail());
        pst.setString(6, empregador.getTelefone());

        pst.close();
        conexao.close();
    }

    public void deletarEmpregador(Empregador empregador) throws SQLException, ClassNotFoundException {
        String sql = "delete from empregadordidato where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setInt(1, empregador.getIdEmpregador());
        pst.execute();
        pst.close();
        conexao.close();
    }
}

