package Model;

public class PessoaFisica extends Empregador{
    private String CPF;
    private String categoriaServico;
    public PessoaFisica(){
        super();
    }
    public void setCPF(String CPF){
        this.CPF=CPF;
    }

    public void setCategoriaServico(String cat){
        this.categoriaServico=cat;
    }

    public String getCPF(){
        return this.CPF;
    }

    public String getCategoriaServico(){
        return this.categoriaServico;
    }


}
