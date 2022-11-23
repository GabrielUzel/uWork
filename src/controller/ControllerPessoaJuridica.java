package controller;

import java.sql.SQLException;
import DAO.PessoaJuridicaDAO;
import model.PessoaJuridica;

public class ControllerPessoaJuridica {
    public ControllerPessoaJuridica() {}
    
    private PessoaJuridicaDAO pessoaJuridicaDao = new PessoaJuridicaDAO();
    
    public void cadastrarPessoaJuridica(String cnpj, String razaoSocial) throws ClassNotFoundException, SQLException {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCNPJ(Long.parseLong(cnpj));
        pessoaJuridica.setRazaoSocial(razaoSocial);
        pessoaJuridicaDao.criarPessoaJuridica(pessoaJuridica);
    }
    /*
    public ArrayList<PessoaJuridica> listarTodasPessoasJuridicas() throws ClassNotFoundException, SQLException{ 
        ArrayList<PessoaJuridica> pessoasJuridicasList = (ArrayList<PessoaJuridica>) pessoaJuridicaDao.listarTodasPessoasJuridicas();
        return pessoasJuridicasList;
    }

    public PessoaJuridica pesquisarPessoaJuridica(int id) throws ClassNotFoundException, SQLException {
        PessoaJuridica pessoaJuridica = pessoaJuridicaDao.pesquisarPessoaJuridica(id);
        return pessoaJuridica;
    }

    public void atualizarPessoaJuridica(String cnpj, String razaoSocial) throws ClassNotFoundException, SQLException {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCNPJ(cnpj);
        pessoaJuridica.setRazaoSocial(razaoSocial);
        pessoaJuridicaDao.atualizarPessoaJuridica(pessoaJuridica);
    }

    public void deletarPessoaJuridica(PessoaJuridica pessoaJuridica) throws ClassNotFoundException, SQLException {
        pessoaJuridicaDao.deletarPessoaJuridica(pessoaJuridica);
    }*/
}
