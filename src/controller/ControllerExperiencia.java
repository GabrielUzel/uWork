package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.ExeperienciaDAO;
import Model.Experiencia;
public class ControllerExperiencia {
    public ControllerExperiencia(){}
    private ExeperienciaDAO EmDAO = new ExeperienciaDAO();
    public void cadastraCandidato(String nome,String sobrenome) throws ClassNotFoundException, SQLException{
        Experiencia c = new Experiencia();
        c.setCargo(nome);
        c.setEmpresa(sobrenome);
        EmDAO.criarExperiencia(c);
    }
    public ArrayList<Experiencia> listarTodosCanditados() throws ClassNotFoundException, SQLException{
        ArrayList<Experiencia> candidatos = (ArrayList<Experiencia>) EmDAO.listarTodasExperiencias();
        return candidatos;
        
    }
    public Experiencia pesquisarEmpregadorPorId(int id) throws ClassNotFoundException, SQLException{
        Experiencia c = EmDAO.listarExperiencia(id);
        return c;

    }
    public void atualizarCandidato(String nome,String sobrenome) throws ClassNotFoundException, SQLException{
        Experiencia c = new Experiencia();
        c.setCargo(nome);
        c.setEmpresa(sobrenome);
        EmDAO.atualizarExperiencia(c);
    }
    public void deletarCandidato(Experiencia c) throws ClassNotFoundException, SQLException{
        EmDAO.deletarExperiencia(c);

    }

}
