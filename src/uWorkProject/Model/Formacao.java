package Model;

public class Formacao {
    private String instituicao;
    private int tempoDuracao;
    private String curso;
    private int id_candidato;
    public Formacao(){

    }
    public void setInstituição(String ins){
        this.instituicao=ins;
    }

    public void setTempoDuracao(int ins){
        this.tempoDuracao=ins;
    }

    public void setCurso(String ins){
        this.curso=ins;
    }

    public void setIdCanditado(int ins){
        this.id_candidato=ins;
    }

    public String getInstituição(){
        return this.instituicao;
    }

    public int getTempoDuracao(){
        return this.tempoDuracao;
    }

    public String getCurso(){
        return this.curso;
    }

    public int getIdCanditado(){
        return this.id_candidato;
    }
}
