package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.PessoaJuridicaDAO;
import Model.PessoaJuridica;
public class ControllerPessoaJuridica {
    public ControllerPessoaJuridica(){}
    private PessoaJuridicaDAO EmDAO = new PessoaJuridicaDAO();
    public void cadastraFormacao(String cnpj,String ser) throws ClassNotFoundException, SQLException{
        PessoaJuridica c = new PessoaJuridica();
        c.setCNPJ(cnpj);
        c.setRazaoSocial(ser);
        EmDAO.criarPessoaJuridica(c);
    }
    public ArrayList<PessoaJuridica> listarTodasPessoasJuridicas() throws ClassNotFoundException, SQLException{
        ArrayList<PessoaJuridica> candidatos = (ArrayList<PessoaJuridica>) EmDAO.listarTodasPessoasJuridicas();
        return candidatos;
        
    }
    public PessoaJuridica pesquisarPessoaJuridicaPorId(int id) throws ClassNotFoundException, SQLException{
        PessoaJuridica c = EmDAO.listarPessoaJuridica(id);
        return c;

    }
    public void atualizarCandidato(String cnpj,String ser) throws ClassNotFoundException, SQLException{
        PessoaJuridica c = new PessoaJuridica();
        c.setCNPJ(cnpj);
        c.setRazaoSocial(ser);
        EmDAO.atualizarPessoaJuridica(c);
    }
    public void deletarCandidato(PessoaJuridica c) throws ClassNotFoundException, SQLException{
        EmDAO.deletarPessoaJuridica(c);

    }
}
