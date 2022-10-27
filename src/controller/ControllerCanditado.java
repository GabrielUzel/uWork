package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.CandidatoDAO;
import model.Canditado;

public class ControllerCanditado {
    private CandidatoDAO candidatoDao = new CandidatoDAO();

    public ControllerCanditado() {}

    public void cadastraCandidato(String nome,String sobrenome) throws ClassNotFoundException, SQLException {
        Canditado candidato = new Canditado();
        candidato.setCPF(sobrenome);
        candidato.setNome(nome);
        candidato.setSobrenome(sobrenome);
        candidatoDao.criarCanditado(candidato);
    }

    public ArrayList<Canditado> listarTodosCanditados() throws ClassNotFoundException, SQLException {
        ArrayList<Canditado> candidatosList = (ArrayList<Canditado>) candidatoDao.listarTodosCandidatos();
        return candidatosList;
    }

    public Canditado pesquisarCanditado(int id) throws ClassNotFoundException, SQLException {
        Canditado candidato = candidatoDao.pesquisarCandidato(id);
        return candidato;
    }

    public void atualizarCandidato(String nome, String sobrenome) throws ClassNotFoundException, SQLException {
        Canditado canditado = new Canditado();
        canditado.setCPF(sobrenome);
        canditado.setNome(nome);
        canditado.setSobrenome(sobrenome);
        candidatoDao.atualizarCandidato(canditado);
    }

    public void deletarCandidato(Canditado canditado) throws ClassNotFoundException, SQLException {
        candidatoDao.deletarCandidato(canditado);
    }
}
