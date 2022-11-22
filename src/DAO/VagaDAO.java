package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConectaBanco;
import model.Vaga;

public class VagaDAO {
    public VagaDAO() {}

    public int criarVaga(Vaga vaga) throws SQLException, ClassNotFoundException {
        int idVaga = -1;
        
        String sql = "INSERT INTO uwork.vaga (v_nome, v_area_atuacao,v_regime,v_descricao,v_salario,v_data_criacao, v_data_limite, v_status , v_fk_Usuario_email) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?);";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        
        pst = conexao.prepareStatement(sql);
        pst.setString(1, vaga.getNomeVaga());
        pst.setString(2, vaga.getArea());
        pst.setString(3, vaga.getRegime());
        pst.setString(4, vaga.getDescricao());
        pst.setDouble(5, vaga.getSalario());
        pst.setDate(6, vaga.getDataAtualString());
        pst.setDate(7, vaga.getDataLimite());
        pst.setString(8, vaga.getStatus());
        pst.setString(9, vaga.getEmail());

        pst.execute();

        pst.close();
        conexao.close();
        
        ////////////////////////////////////////////////////////
        PreparedStatement stmt;
        Connection con;
        ResultSet rs;
        boolean check = false;
        try {
            sql = "Select v_id from uwork.usuario where v_nome = '"+ vaga.getNomeVaga()+"' AND v_fk_usuario_email='"+vaga.getEmail()+"';";
            con = new ConectaBanco().conectar();
            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();
            
            while(rs.next()){
                check=true;
                idVaga=rs.getInt("v_id");
            }
            
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        if(!check){
            JOptionPane.showMessageDialog(null, "Vaga não criada!");
        }
        ///////////////////////////////////////////////////////

        return idVaga;
    }

    public Vaga pesquisarVaga(String id) throws SQLException, ClassNotFoundException {
        String sql = "select * from vaga where nome=?";
        PreparedStatement pst;
        ResultSet rs;
        Vaga vaga = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            vaga = new Vaga();
            vaga.setIdVaga(rs.getInt(id));
            vaga.setNome(rs.getString("cargo"));
            vaga.setAreaAtuacao(rs.getString("areaDeAtuacao"));
            vaga.setDescricao(rs.getString("empresa"));
            vaga.setSalario(rs.getDouble("tempoDeServico"));
        }

        rs.close();
        pst.close();
        conexao.close();

        return vaga;
    }

    public List<Vaga> listarTodasVagas() throws SQLException, ClassNotFoundException {
        String sql = "select * from uwork.vaga";
        PreparedStatement pst;
        List<Vaga> vagasList = null;
        ResultSet rs;
        Vaga vaga = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            vagasList = new ArrayList<Vaga>();

            while(rs.next()){
                vaga = new Vaga();
                vaga.setIdVaga(rs.getInt("v_id"));
                vaga.setNomeVaga(rs.getString("v_nome"));
                vaga.setArea(rs.getString("v_area_atuacao"));
                vaga.setRegime(rs.getString("v_regime"));
                vaga.setDescricao(rs.getString("v_descricao"));
                vaga.setSalario(rs.getDouble("v_salario"));
                vagasList.add(vaga);
            }
        }

        rs.close();
        pst.close();
        conexao.close();

        return vagasList;
    }

    public List<Vaga> listarTodasVagasUsuario(String usuario) throws ClassNotFoundException, SQLException {
        String sql = "select * from uwork.vaga where v_fk_Usuario_email = '"+usuario+"';";
        PreparedStatement pst;
        List<Vaga> vagasList = null;
        ResultSet rs;
        Vaga vaga = null;
        Connection conexao = new ConectaBanco().conectar();

        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        if(rs != null) {
            vagasList = new ArrayList<Vaga>();

            while(rs.next()){
                vaga = new Vaga();
                vaga.setIdVaga(rs.getInt("v_id"));
                vaga.setNomeVaga(rs.getString("v_nome"));
                vaga.setArea(rs.getString("v_area_atuacao"));
                vaga.setRegime(rs.getString("v_regime"));
                //vaga.setDescricao(rs.getString("v_descricao"));
                //vaga.setSalario(rs.getDouble("v_salario"));
                vagasList.add(vaga);
            }
        }

        rs.close();
        pst.close();
        conexao.close();

        return vagasList;
    }

    /*public void atualizarVaga(Vaga vaga) throws SQLException, ClassNotFoundException {
         String sql="update  vaga set () values(?,?,?,?)";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        
        pst = conexao.prepareStatement(sql);
        pst.executeQuery();
        pst.setInt(1, vaga.getIdVaga());
        pst.setString(2, vaga.getNome());
        pst.setString(3, vaga.getDescricao());
        pst.setString(4, vaga.getTipoRegime());
        pst.setDouble(5, vaga.getSalario());
        pst.setString(6, vaga.getAreaAtuacao());
        
        pst.close();
        conexao.close();
    }

    public void deletarVaga(Vaga vaga) throws SQLException, ClassNotFoundException {
        String sql = "delete from vaga where id=?";
        PreparedStatement pst;
        Connection conexao = new ConectaBanco().conectar();
        
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, vaga.getIdVaga());
        pst.execute();
        pst.close();
        conexao.close();
    }*/
}
