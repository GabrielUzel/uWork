package model;

public class PessoaJuridica extends Empregador {
    // Atributos
    private String cnpj;
    private String razaoSocial;

    // Construtor
    public PessoaJuridica(){
        super();
    }

    // Setters
    public void setCNPJ(String cnpj) { this.cnpj = cnpj; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }

    // Getters
    public String getCNPJ() { return this.cnpj; }
    public String getRazaoSocial() { return this.razaoSocial; }
}
