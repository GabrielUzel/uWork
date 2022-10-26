package Model;

public class PessoaJuridica extends Empregador{
    private String CNPJ;
    private String razaoSocial;
    public PessoaJuridica(){
        super();
    }
    public void setCPF(String CNPJ){
        this.CNPJ=CNPJ;
    }

    public void setRazaoSocial(String cat){
        this.razaoSocial=cat;
    }

    public String getCNPJ(){
        return this.CNPJ;
    }

    public String getRazaoSocial(){
        return this.razaoSocial;
    }
}
