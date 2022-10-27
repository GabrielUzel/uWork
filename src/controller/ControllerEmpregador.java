package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.EmpregadorDAO;
import Model.Empregador;
public class ControllerEmpregador {
    public ControllerEmpregador(){}
    private EmpregadorDAO EmDAO = new EmpregadorDAO();
    public void cadastraCandidato(String nome,String sobrenome) throws ClassNotFoundException, SQLException{
        Empregador c = new Empregador();
        c.setNome(nome);
        c.setSobrenome(sobrenome);
        EmDAO.criarEmpregador(c);
    }
    public ArrayList<Empregador> listarTodosCanditados() throws ClassNotFoundException, SQLException{
        ArrayList<Empregador> candidatos = (ArrayList<Empregador>) EmDAO.listarTodosCandidatos();
        return candidatos;
        
    }
    public Empregador pesquisarEmpregadorPorId(int id) throws ClassNotFoundException, SQLException{
        Empregador c = EmDAO.listarEmpregador(id);
        return c;

    }
    public void atualizarCandidato(String nome,String sobrenome) throws ClassNotFoundException, SQLException{
        Empregador c = new Empregador();
        c.setNome(nome);
        c.setSobrenome(sobrenome);
        EmDAO.atualizarEmpregador(c);
    }
    public void deletarCandidato(Empregador c) throws ClassNotFoundException, SQLException{
        EmDAO.deletarEmpregador(c);

    }

}
