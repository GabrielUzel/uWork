package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.CandidatoDAO;
import Model.Canditado;
public class ControllerCanditado {
    private CandidatoDAO candidatoDao = new CandidatoDAO();
    public ControllerCanditado(){}
    public void cadastraCandidato(String nome,String sobrenome) throws ClassNotFoundException, SQLException{
        Canditado c = new Canditado();
        c.setCPF(sobrenome);
        c.setNome(nome);
        c.setSobrenome(sobrenome);
        candidatoDao.criarCanditado(c);
    }
    public ArrayList<Canditado> listarTodosCanditados() throws ClassNotFoundException, SQLException{
        ArrayList<Canditado> candidatos = (ArrayList<Canditado>) candidatoDao.listarTodosCandidatos();
        return candidatos;
        
    }
    public Canditado pesquisarCanditadoPorId(int id) throws ClassNotFoundException, SQLException{
        Canditado c = candidatoDao.pesquisarCandidato(id);
        return c;

    }
    public void atualizarCandidato(String nome,String sobrenome) throws ClassNotFoundException, SQLException{
        Canditado c = new Canditado();
        c.setCPF(sobrenome);
        c.setNome(nome);
        c.setSobrenome(sobrenome);
        candidatoDao.atualizarCandidato(c);
    }
    public void deletarCandidato(Canditado c) throws ClassNotFoundException, SQLException{
        candidatoDao.deletarCandidato(c);

    }


    
}
