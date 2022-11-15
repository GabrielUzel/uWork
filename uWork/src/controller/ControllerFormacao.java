package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.FormacaoDAO;
import model.Formacao;

public class ControllerFormacao {
    public ControllerFormacao() {}

    private FormacaoDAO formacaoDao = new FormacaoDAO();

    public void cadastrarFormacao(String curso, String instituicao, int id, int tempoDuracao) throws ClassNotFoundException, SQLException {
        Formacao formacao = new Formacao();
        formacao.setIdCandidato(id);
        formacao.setCurso(curso);
        formacao.setInstituição(instituicao);
        formacao.setTempoDuracao(tempoDuracao);
        formacaoDao.criarFormacao(formacao);
    }

    public ArrayList<Formacao> listarTodasFormacoes() throws ClassNotFoundException, SQLException {
        ArrayList<Formacao> formacoesList = (ArrayList<Formacao>) formacaoDao.listarTodasFormacoes();
        return formacoesList;
    }

    public Formacao pesquisarFormacao(int id) throws ClassNotFoundException, SQLException {
        Formacao formacao = formacaoDao.pesquisarFormacao(id);
        return formacao;
    }

    public void atualizarCandidato(String curso, String instituicao, int id, int tempoDuracao) throws ClassNotFoundException, SQLException {
        Formacao formacao = new Formacao();
        formacao.setIdCandidato(id);
        formacao.setCurso(curso);
        formacao.setInstituição(instituicao);
        formacao.setTempoDuracao(tempoDuracao);
        formacaoDao.atualizarFormacao(formacao);
    }

    public void deletarCandidato(Formacao formacao) throws ClassNotFoundException, SQLException {
        formacaoDao.deletarFormacao(formacao);
    }
}
