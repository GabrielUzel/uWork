package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.RequisitosDAO;
import model.Requisitos;

public class ControllerRequisitos {
    public ControllerRequisitos() {}

    private RequisitosDAO requisitosDao = new RequisitosDAO();

    public void cadastrarRequisitos(String nome, String area, String descricao, int id) throws ClassNotFoundException, SQLException {
        Requisitos requisitos = new Requisitos();
        requisitos.setNomeRequisito(nome);
        requisitos.setAreaAtuacao(area);
        requisitos.setDescricao(descricao);
        requisitos.setIdVaga(id);
        requisitosDao.criarRequisitos(requisitos);
    }

    public ArrayList<Requisitos> listarTodosRequisitos() throws ClassNotFoundException, SQLException {
        ArrayList<Requisitos> requisitosList = (ArrayList<Requisitos>) requisitosDao.listarTodosRequisitos();
        return requisitosList;
    }

    public Requisitos pesquisarRequisitos(int id) throws ClassNotFoundException, SQLException {
        Requisitos requisitos = requisitosDao.pesquisarRequisitos(id);
        return requisitos;
    }

    public void atualizarRequisitos(String nome, String area, String descricao, int id) throws ClassNotFoundException, SQLException {
        Requisitos requisitos = new Requisitos();
        requisitos.setNomeRequisito(nome);
        requisitos.setAreaAtuacao(area);
        requisitos.setDescricao(descricao);
        requisitos.setIdVaga(id);
        requisitosDao.atualizarRequisitos(requisitos);
    }

    public void deletarRequisitos(Requisitos requisitos) throws ClassNotFoundException, SQLException {
        requisitosDao.deletarRequisitos(requisitos);
    }
}
