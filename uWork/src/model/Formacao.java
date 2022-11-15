package model;

public class Formacao {
    // Atributos
    private String instituicao;
    private int tempoDuracao;
    private String curso;
    private int id_candidato;

    // Construtor
    public Formacao() {}

    // Setters
    public void setInstituição(String instituicao) { this.instituicao = instituicao; }
    public void setTempoDuracao(int tempoDuracao) { this.tempoDuracao = tempoDuracao; }
    public void setCurso(String curso) { this.curso = curso; }
    public void setIdCandidato(int id_candidato) { this.id_candidato = id_candidato; }

    // Getters
    public String getInstituição() { return this.instituicao; }
    public int getTempoDuracao() { return this.tempoDuracao; }
    public String getCurso() { return this.curso; }
    public int getIdCanditado() { return this.id_candidato; }
}
