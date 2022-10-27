package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.RequisitosDAO;
import Model.Requisitos;
public class ControllerRequisitos {
    public ControllerRequisitos(){}
    private RequisitosDAO EmDAO = new RequisitosDAO();
    public void cadastraRequisitos(String nome,String area,String des, int id) throws ClassNotFoundException, SQLException{
        Requisitos c = new Requisitos();
        c.setNomeRequisito(nome);
        c.setAreaAtuacao(area);
        c.setDescricao(des);
        c.setIdVaga(id);
        EmDAO.criarRequisitos(c);
    }
    public ArrayList<Requisitos> listarTodosRequisitos() throws ClassNotFoundException, SQLException{
        ArrayList<Requisitos> candidatos = (ArrayList<Requisitos>) EmDAO.listarTodosRequisitos();
        return candidatos;
        
    }
    public Requisitos pesquisarRequisitosPorId(int id) throws ClassNotFoundException, SQLException{
        Requisitos c = EmDAO.listarRequisitos(id);
        return c;

    }
    public void atualizarRequisitos(String nome,String area,String des, int id) throws ClassNotFoundException, SQLException{
        Requisitos c = new Requisitos();
        c.setNomeRequisito(nome);
        c.setAreaAtuacao(area);
        c.setDescricao(des);
        c.setIdVaga(id);
        EmDAO.atualizarRequisitos(c);
    }
    public void deletarRequisitos(Requisitos c) throws ClassNotFoundException, SQLException{
        EmDAO.deletarRequisitos(c);

    }
}
