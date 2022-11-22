package model;

import java.sql.Date;

public class Vaga {
    // Atributos
    private int idVaga;
    private String nomeVaga;
    private String regime; 
    private double salario; 
    private String area;
    private String descricao;
    private String status;
    private Date dataAtualString;
    private Date dataLimite;
    private String email;

    // Construtor
    public Vaga(String nomeVaga, String regime, double salario2, String area, String descricao2, String status, Date dataAtualString, Date dataLimite, String gmail) {
        this.nomeVaga = nomeVaga;
        this.regime= regime; 
        this.salario=salario2; 
        this.area= area;
        this.descricao=descricao2;
        this.status = status;
        this.dataAtualString = dataAtualString;
        this.dataLimite= dataLimite;
        this.email= gmail;
    }

    public Vaga() {
    }

    //getters
    public int getIdVaga() {
        return idVaga;
    }

    public String getNomeVaga() {
        return nomeVaga;
    }

    public String getRegime() {
        return regime;
    }

    public double getSalario() {
        return salario;
    }

    public String getArea() {
        return area;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public Date getDataAtualString() {
        return dataAtualString;
    }
    
    public Date getDataLimite() {
        return dataLimite;
    }

    public String getEmail() {
        return email;
    }

    //setters
    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataAtualString(Date dataAtualString) {
        this.dataAtualString = dataAtualString;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
