package Model;

public class Vaga {
    private String nome;
    private String areaAtuacao;
    private String descricao;
    private int id_vaga;
    private Empregador empregador;
    private String tipoRegime;
    private double salario;

    public Vaga(){

    }
    
    public void setNome(String nome){
        this.nome = nome;

    }
    public void setAreaAtuacao(String nome){
        this.areaAtuacao = nome;

    }
    public void setDescricao(String nome){
        this.descricao = nome;

    }
    public void setTipoRegime(String nome){
        this.descricao = nome;

    }
    public void setIdVaga(int nome){
        this.id_vaga = nome;

    }

    public void setSalario(double nome){
        this.salario = nome;

    }

    public String getNome(){
        return this.nome;

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

    public String getTipoRegime(){
        return this.tipoRegime;

    }

    public double getSalario(){
        return this.salario;

    }
}
