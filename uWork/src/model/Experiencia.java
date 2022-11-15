package model;

public class Experiencia {
    // Atributos
    private String empresa;
    private int tempoServico;
    private String areaDeAtuacao;
    private int id_cadidato;
    private String cargo;

    // Construtor
    public Experiencia() {}
    
    // Setters
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    public void setTempoServico(int tempoServico) { this.tempoServico = tempoServico; }
    public void setAreaDeAtuacao(String areaDeAtuacao) { this.areaDeAtuacao = areaDeAtuacao; }
    public void setIdCanditado(int id_cadidato) { this.id_cadidato = id_cadidato; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    // Getters
    public String getEmpresa() { return this.empresa; }
    public int getTempoServico() { return this.tempoServico; }
    public String setAreaDeAtuacao() { return this.areaDeAtuacao; }
    public int getIdCanditado() { return this.id_cadidato; }
    public String getCargo() { return this.cargo; }
}
