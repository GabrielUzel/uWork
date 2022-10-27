package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.VagaDAO;
import Model.Vaga;
public class ControllerVaga {
    public ControllerVaga(){}
    private VagaDAO EmDAO = new VagaDAO();
    public void cadastraVaga(String nome,String area,String des, int id,double sal) throws ClassNotFoundException, SQLException{
        Vaga c = new Vaga();
        c.setAreaAtuacao(nome);
        c.setTipoRegime(area);
        c.setDescricao(des);
        c.setIdVaga(id);
        c.setSalario(sal);
        EmDAO.criarVaga(c);
    }
    public ArrayList<Vaga> listarTodasVagas() throws ClassNotFoundException, SQLException{
        ArrayList<Vaga> candidatos = (ArrayList<Vaga>) EmDAO.listarTodasVagas();
        return candidatos;
        
    }
    public Vaga pesquisarVagaPorId(int id) throws ClassNotFoundException, SQLException{
        Vaga c = EmDAO.listarVaga(id);
        return c;

    }
    public void atualizarVaga(String nome,String area,String des, int id,double sal) throws ClassNotFoundException, SQLException{
        Vaga c = new Vaga();
        c.setAreaAtuacao(nome);
        c.setTipoRegime(area);
        c.setDescricao(des);
        c.setIdVaga(id);
        c.setSalario(sal);
        EmDAO.atualizarVaga(c);
    }
    public void deletarVaga(Vaga c) throws ClassNotFoundException, SQLException{
        EmDAO.deletarVaga(c);

    }
}
