package Model;

public class Requisitos {
    private String nome_requisito;
    private String areaAtuacao;
    private String descricao;
    private int id_vaga;

    public Requisitos(){

    }
    
    public void setNomeRequisito(String nome){
        this.nome_requisito = nome;

    }
    public void setAreaAtuacao(String nome){
        this.areaAtuacao = nome;

    }
    public void setDescricao(String nome){
        this.descricao = nome;

    }
    public void setIdVaga(int nome){
        this.id_vaga = nome;

    }

    public String getNomeRequisito(){
        return this.nome_requisito;

    }

    public String getAreaAtuacao(){
        return this.areaAtuacao;

    }
    public String getDescricao(){
        return this.descricao;

    }

    public int getIdVaga(){
        return this.id_vaga;

    }
}
