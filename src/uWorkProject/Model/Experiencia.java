package Model;

public class Experiencia {
    private String empresa;
    private int tempoServico;
    private String areaDeAtuacao;
    private int id_cadidato;
    private String cargo;

    public Experiencia(){

    }
    public void setEmpresa(String Em){
        this.empresa = Em;
    }

    public void setTempoServico(int Em){
        this.tempoServico = Em;
    }

    public void setAreaDeAtuacao(String Em){
        this.areaDeAtuacao = Em;
    }

    public void setIdCanditado(int Em){
        this.id_cadidato = Em;
    }

    public void setCargo(String Em){
        this.cargo = Em;
    }


    public String getEmpresa(){
        return this.empresa;
    }

    public int getTempoServico(){
        return this.tempoServico;
    }

    public String setAreaDeAtuacao(){
        return this.areaDeAtuacao;
    }

    public int getIdCanditado(){
        return this.id_cadidato;
    }

    public String  getCargo(){
        return this.cargo;
    }

}
