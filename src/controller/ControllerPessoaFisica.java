package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.PessoaFisicaDAO;
import Model.PessoaFisica;
public class ControllerPessoaFisica {
    public ControllerPessoaFisica(){}
    private PessoaFisicaDAO EmDAO = new PessoaFisicaDAO();
    public void cadastraFormacao(String cpf,String ser) throws ClassNotFoundException, SQLException{
        PessoaFisica c = new PessoaFisica();
        c.setCPF(cpf);
        c.setCategoriaServico(ser);
        EmDAO.criarPessoaFisica(c);
    }
    public ArrayList<PessoaFisica> listarTodasFormacao() throws ClassNotFoundException, SQLException{
        ArrayList<PessoaFisica> candidatos = (ArrayList<PessoaFisica>) EmDAO.listarTodasPessoasFisicas();
        return candidatos;
        
    }
    public PessoaFisica pesquisarFormacaoPorId(int id) throws ClassNotFoundException, SQLException{
        PessoaFisica c = EmDAO.listarPessoaFisica(id);
        return c;

    }
    public void atualizarCandidato(String cpf,String ser) throws ClassNotFoundException, SQLException{
        PessoaFisica c = new PessoaFisica();
        c.setCPF(cpf);
        c.setCategoriaServico(ser);
        EmDAO.atualizarPessoaFisica(c);
    }
    public void deletarCandidato(PessoaFisica c) throws ClassNotFoundException, SQLException{
        EmDAO.deletarPessoaFisica(c);

    }
}
