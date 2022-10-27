package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.FormacaoDAO;
import Model.Formacao;
public class ControllerFormacao {
    public ControllerFormacao(){}
    private FormacaoDAO EmDAO = new FormacaoDAO();
    public void cadastraFormacao(String curso,String instituicao,int id,int temp) throws ClassNotFoundException, SQLException{
        Formacao c = new Formacao();
        c.setIdCanditado(id);
        c.setCurso(curso);
        c.setInstituição(instituicao);
        c.setTempoDuracao(temp);
        EmDAO.criarFormacao(c);
    }
    public ArrayList<Formacao> listarTodasFormacao() throws ClassNotFoundException, SQLException{
        ArrayList<Formacao> candidatos = (ArrayList<Formacao>) EmDAO.listarTodasFormacoes();
        return candidatos;
        
    }
    public Formacao pesquisarFormacaoPorId(int id) throws ClassNotFoundException, SQLException{
        Formacao c = EmDAO.listarFormacao(id);
        return c;

    }
    public void atualizarCandidato(String curso,String instituicao,int id,int temp) throws ClassNotFoundException, SQLException{
        Formacao c = new Formacao();
        c.setIdCanditado(id);
        c.setCurso(curso);
        c.setInstituição(instituicao);
        c.setTempoDuracao(temp);
        EmDAO.atualizarFormacao(c);
    }
    public void deletarCandidato(Formacao c) throws ClassNotFoundException, SQLException{
        EmDAO.deletarFormacao(c);

    }
}
