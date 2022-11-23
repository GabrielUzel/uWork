package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConectaBanco;
import model.Usuario;

public class UsuarioDAO {
    public UsuarioDAO() {}

    public void criarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO uwork.usuario VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setString(1, usuario.getEmail());
        pst.setString(2, usuario.getSenha());
        pst.setString(3, usuario.getNome());
        pst.setString(4, usuario.getLogradouro());
        pst.setInt(5, usuario.getNumero());
        pst.setString(6, usuario.getBairro());
        pst.setString(7, usuario.getComplemento());
        pst.setString(8, usuario.getCidade());
        pst.setString(9, usuario.getEstado());
        pst.setString(10, usuario.getPais());
        pst.setLong(11, usuario.getCep());
        pst.setLong(12, usuario.getTelefone());

        pst.execute();

        pst.close();
        conexao.close();
    }

    public Usuario pesquisarCandidato(String id) throws SQLException, ClassNotFoundException {
        String sql = "select * from uwork.usuario where u_email=?";
        PreparedStatement pst;
        ResultSet rs;
        Usuario canditado = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null ){
            canditado = new Usuario();
            canditado.setEmail(rs.getString("u_email"));
            canditado.setNome(rs.getString("u_nome"));
            //canditado.setSobrenome(rs.getString("sobrenome"));
            canditado.setEmail(rs.getString("u_email"));
            //canditado.setTelefone(rs.getString("u_telefone"));
            //canditado.setDataNascimento(rs.getDate("data nascimento"));
        }

        rs.close();
        pst.close();
        conexao.close();

        return canditado;
    }

    /*
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
    */
}
