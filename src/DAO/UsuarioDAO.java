package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        Usuario usuario = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null ){
            usuario = new Usuario();
            usuario.setNome(rs.getString("u_nome"));
            usuario.setEmail(rs.getString("u_email"));
            usuario.setBairro(rs.getString("u_logradouro"));
            usuario.setComplemento(rs.getString("u_complemento"));
            usuario.setNumero(rs.getInt("u_numero"));
            usuario.setCidade(rs.getString("u_cidade"));
            usuario.setPais(rs.getString("u_pais"));
            usuario.setCep(rs.getInt("u_cep"));
            usuario.setTelefone(rs.getInt("u_telefone"));
            usuario.setEstado(rs.getString("u_estado"));
        }

        rs.close();
        pst.close();
        conexao.close();

        return usuario;
    }

    
    public List<Usuario> listarTodosUsuario() throws SQLException, ClassNotFoundException {
        String sql = "select * from Usuario";
        Usuario usuario = new Usuario();
        PreparedStatement pst;
        List <Usuario> canditadosList = null;
        ResultSet rs;
        Usuario canditado = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            canditadosList = new ArrayList<Usuario>();

            while(rs.next()) {
                usuario.setNome(rs.getString("u_nome"));
                usuario.setEmail(rs.getString("u_email"));
                usuario.setBairro(rs.getString("u_logradouro"));
                usuario.setComplemento(rs.getString("u_complemento"));
                usuario.setNumero(rs.getInt("u_numero"));
                usuario.setCidade(rs.getString("u_cidade"));
                usuario.setPais(rs.getString("u_pais"));
                usuario.setCep(rs.getInt("u_cep"));
                usuario.setTelefone(rs.getInt("u_telefone"));
                usuario.setEstado(rs.getString("u_estado"));
                canditadosList.add(canditado);
            }
        }

        rs.close();
        pst.close();
        conexao.close();

        return canditadosList;
    }

    public void atualizarCandidato(Usuario usuario) throws SQLException, ClassNotFoundException {
        String sql="update  canditado set () values(?,?,?,?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
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

        pst.close();
        conexao.close();
    }

    public void deletarCandidato(Usuario usuario) throws SQLException, ClassNotFoundException {
        String sql = "delete from candidato where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        pst.setInt(0, usuario.getNumero());
        pst.execute();
        pst.close();
        conexao.close();
    }
    
}
