package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.VagaDAO;
import model.*;

public class ControllerVaga {
    public ControllerVaga() {}

    private VagaDAO vagaDao = new VagaDAO();

    public void cadastraVaga(String nome, String area, String descricao, int id, double salario, String email) throws ClassNotFoundException, SQLException {
        Vaga vaga = new Vaga();
        vaga.setArea(nome);
        vaga.setRegime(area);
        vaga.setDescricao(descricao);
        vaga.setIdVaga(id);
        vaga.setSalario(salario);
        vaga.setEmail(email);
        vagaDao.criarVaga(vaga);
    }

    public ArrayList<Vaga> listarTodasVagas() throws ClassNotFoundException, SQLException {
        ArrayList<Vaga> vagasList = (ArrayList<Vaga>) vagaDao.listarTodasVagas();
        return vagasList;
    }

    public Vaga pesquisarVaga(String id) throws ClassNotFoundException, SQLException {
        Vaga vaga = vagaDao.pesquisarVaga(id);
        return vaga;
    }

    public void atualizarVaga(String nome, String area, String descricao, int id, double salario) throws ClassNotFoundException, SQLException {
        Vaga vaga = new Vaga();
        vaga.setArea(nome);
        vaga.setRegime(area);
        vaga.setDescricao(descricao);
        vaga.setIdVaga(id);
        vaga.setSalario(salario);
        vagaDao.atualizarVaga(vaga);
    }

    public void deletarVaga(Vaga vaga) throws ClassNotFoundException, SQLException {
        vagaDao.deletarVaga(vaga);
    }
}
