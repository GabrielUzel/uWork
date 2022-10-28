package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.PessoaFisicaDAO;
import model.PessoaFisica;

public class ControllerPessoaFisica {
    public ControllerPessoaFisica() {}

    private PessoaFisicaDAO pessoaFisicaDao = new PessoaFisicaDAO();

    public void cadastraFormacao(String cpf, String categoriaServico) throws ClassNotFoundException, SQLException {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCPF(cpf);
        pessoaFisica.setCategoriaServico(categoriaServico);
        pessoaFisicaDao.criarPessoaFisica(pessoaFisica);
    }

    public ArrayList<PessoaFisica> listarTodasPessoasFisicas() throws ClassNotFoundException, SQLException {
        ArrayList<PessoaFisica> pessoasFisicasList = (ArrayList<PessoaFisica>) pessoaFisicaDao.listarTodasPessoasFisicas();
        return pessoasFisicasList;
    }

    public PessoaFisica pesquisarPessoaFisica(int id) throws ClassNotFoundException, SQLException {
        PessoaFisica pessoaFisica = pessoaFisicaDao.pesquisarPessoaFisica(id);
        return pessoaFisica;
    }

    public void atualizarPessoaFisica(String cpf, String categoriaServico) throws ClassNotFoundException, SQLException {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCPF(cpf);
        pessoaFisica.setCategoriaServico(categoriaServico);
        pessoaFisicaDao.atualizarPessoaFisica(pessoaFisica);
    }

    public void deletarPessoaFisica(PessoaFisica pessoaFisica) throws ClassNotFoundException, SQLException {
        pessoaFisicaDao.deletarPessoaFisica(pessoaFisica);
    }
}
