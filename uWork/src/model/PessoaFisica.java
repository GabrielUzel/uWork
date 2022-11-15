package model;

public class PessoaFisica extends Empregador {
    // Atributos
    private String cpf;
    private String categoriaServico;

    // Construtor
    public PessoaFisica() {
        super();
    }

    // Setters
    public void setCPF(String cpf) { this.cpf = cpf; }
    public void setCategoriaServico(String categoriaServico) { this.categoriaServico = categoriaServico; }

    // Getters
    public String getCPF() { return this.cpf; }
    public String getCategoriaServico() { return this.categoriaServico; }
}
