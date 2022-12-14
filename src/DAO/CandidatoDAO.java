package DAO;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConectaBanco;
import model.Canditado;

public class CandidatoDAO {
    public CandidatoDAO() {}

    public void criarCanditado(Canditado candidato) throws SQLException, ClassNotFoundException {
        String sql = "insert into candidato () values(?,?,?,?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setInt(1, candidato.getIdCanditado());
        pst.setString(2, candidato.getNome());
        pst.setString(3, candidato.getCPF());
        pst.setString(4, candidato.getSobrenome());
        pst.setString(5, candidato.getEmail());
        pst.setString(6, candidato.getTelefone());
        //pst.setDate(6, (Date) can.getDataNascimento());
        //pst.setString(7, can.getSenha());

        pst.close();
        conexao.close();
    }

    public Canditado pesquisarCandidato(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from candidato where id=?";
        PreparedStatement pst;
        ResultSet rs;
        Canditado canditado = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null ){
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

    public List<Canditado> listarTodosCandidatos() throws SQLException, ClassNotFoundException {
        String sql = "select * from candidato";
        PreparedStatement pst;
        List <Canditado> canditadosList = null;
        ResultSet rs;
        Canditado canditado = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            canditadosList = new ArrayList<Canditado>();

            while(rs.next()) {
                canditado = new Canditado();
                canditado.setIdCanditado(rs.getInt("id"));
                canditado.setNome(rs.getString("nome"));
                canditado.setSobrenome(rs.getString("sobrenome"));
                canditado.setEmail(rs.getString("email"));
                canditado.setTelefone(rs.getString("telefone"));
                canditado.setDataNascimento(rs.getDate("data nascimento"));
                canditadosList.add(canditado);
            }
        }

        rs.close();
        pst.close();
        conexao.close();

        return canditadosList;
    }

    public void atualizarCandidato(Canditado candidato) throws SQLException, ClassNotFoundException {
        String sql="update  canditado set () values(?,?,?,?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setInt(1, candidato.getIdCanditado());
        pst.setString(2, candidato.getNome());
        pst.setString(3, candidato.getCPF());
        pst.setString(4, candidato.getSobrenome());
        pst.setString(5, candidato.getEmail());
        pst.setString(6, candidato.getTelefone());
        //pst.setDate(6, (Date) can.getDataNascimento());

        pst.close();
        conexao.close();
    }

    public void deletarCandidato(Canditado candidato) throws SQLException, ClassNotFoundException {
        String sql = "delete from candidato where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setInt(0, candidato.getIdCanditado());
        pst.execute();
        pst.close();
        conexao.close();
    }
}
