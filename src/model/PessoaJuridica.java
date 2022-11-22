package model;

public class PessoaJuridica extends Empregador {
    // Atributos
    private long cnpj;
    private String razaoSocial;

    // Construtor
    public PessoaJuridica(){
        super();
    }

    // Setters
    public void setCNPJ(long cnpj) { this.cnpj = cnpj; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }

    // Getters
    public long getCNPJ() { return this.cnpj; }
    public String getRazaoSocial() { return this.razaoSocial; }
}
