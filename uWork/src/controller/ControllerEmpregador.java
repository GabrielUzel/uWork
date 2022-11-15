package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.EmpregadorDAO;
import model.Empregador;

public class ControllerEmpregador {
    public ControllerEmpregador() {}

    private EmpregadorDAO empregadorDao = new EmpregadorDAO();

    public void cadastraEmpregador(String nome, String sobrenome) throws ClassNotFoundException, SQLException {
        Empregador empregador = new Empregador();
        empregador.setNome(nome);
        empregador.setSobrenome(sobrenome);
        empregadorDao.criarEmpregador(empregador);
    }

    public ArrayList<Empregador> listarTodosEmpregadores() throws ClassNotFoundException, SQLException {
        ArrayList<Empregador> empregadoresList = (ArrayList<Empregador>) empregadorDao.listarTodosEmpregadores();
        return empregadoresList;
    }

    public Empregador pesquisarEmpregador(int id) throws ClassNotFoundException, SQLException {
        Empregador empregador = empregadorDao.pesquisarEmpregador(id);
        return empregador;
    }

    public void atualizarEmpregador(String nome, String sobrenome) throws ClassNotFoundException, SQLException {
        Empregador empregador = new Empregador();
        empregador.setNome(nome);
        empregador.setSobrenome(sobrenome);
        empregadorDao.atualizarEmpregador(empregador);
    }

    public void deletarCandidato(Empregador empregador) throws ClassNotFoundException, SQLException {
        empregadorDao.deletarEmpregador(empregador);
    }
}
