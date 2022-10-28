package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.ExperienciaDAO;
import model.Experiencia;

public class ControllerExperiencia {
    public ControllerExperiencia() {}

    private ExperienciaDAO experienciaDao = new ExperienciaDAO();

    public void cadastraExperiencia(String nome, String sobrenome) throws ClassNotFoundException, SQLException {
        Experiencia experiencia = new Experiencia();
        experiencia.setCargo(nome);
        experiencia.setEmpresa(sobrenome);
        experienciaDao.criarExperiencia(experiencia);
    }

    public ArrayList<Experiencia> listarTodasExperiencias() throws ClassNotFoundException, SQLException {
        ArrayList<Experiencia> experienciasList = (ArrayList<Experiencia>) experienciaDao.listarTodasExperiencias();
        return experienciasList;
    }

    public Experiencia pesquisarexperiencia(int id) throws ClassNotFoundException, SQLException {
        Experiencia experiencia = experienciaDao.pesquisarExperiencia(id);
        return experiencia;
    }

    public void atualizarExperiencia(String nome, String sobrenome) throws ClassNotFoundException, SQLException {
        Experiencia experiencia = new Experiencia();
        experiencia.setCargo(nome);
        experiencia.setEmpresa(sobrenome);
        experienciaDao.atualizarExperiencia(experiencia);
    }

    public void deletarExperiencia(Experiencia experiencia) throws ClassNotFoundException, SQLException{
        experienciaDao.deletarExperiencia(experiencia);
    }
}
