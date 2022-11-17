package model;

public class Vaga {
    // Atributos
    private String nome;
    private String areaAtuacao;
    private String descricao;
    private int id_vaga;
    private String tipoRegime;
    private double salario;

    // Construtor
    public Vaga() {}
    
    // Setters
    public void setNome(String nome) { this.nome = nome; }
    public void setAreaAtuacao(String areaAtuacao) { this.areaAtuacao = nome; }
    public void setDescricao(String descricao) { this.descricao = nome; }
    public void setTipoRegime(String tipoRegime) { this.descricao = tipoRegime; }
    public void setIdVaga(int id_vaga) { this.id_vaga = id_vaga; }
    public void setSalario(double nome) { this.salario = nome; }

    // Getters
    public String getNome() { return this.nome; }
    public String getAreaAtuacao() { return this.areaAtuacao; }
    public String getDescricao() { return this.descricao; }
    public int getIdVaga() { return this.id_vaga; }
    public String getTipoRegime() { return this.tipoRegime; }
    public double getSalario() { return this.salario; }
}
