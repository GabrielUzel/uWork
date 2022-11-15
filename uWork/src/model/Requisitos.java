package model;

public class Requisitos {
    // Atributos
    private String nomeRequisito;
    private String areaAtuacao;
    private String descricao;
    private int id_vaga;

    // Construtor
    public Requisitos() {}
    
    // Setters
    public void setNomeRequisito(String nomeRequisito) { this.nomeRequisito = nomeRequisito; }
    public void setAreaAtuacao(String areaAtuacao) { this.areaAtuacao = areaAtuacao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setIdVaga(int id_vaga){ this.id_vaga = id_vaga; }

    // Getters
    public String getNomeRequisito() { return this.nomeRequisito; }
    public String getAreaAtuacao() { return this.areaAtuacao; }
    public String getDescricao() { return this.descricao; }
    public int getIdVaga() { return this.id_vaga; }
}
