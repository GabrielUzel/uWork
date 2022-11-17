package model;

public class Usuario {
    // Atributos
    private String nome;
    private String Email;
    private String senha;
    private long telefone;
    private String pais;
    private String estado;
    private long cep;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String complemento;
    private int numero;

    //getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return Email;
    }

    public String getSenha() {
        return senha;
    }

    public long getTelefone() {
        return telefone;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public long getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public int getNumero() {
        return numero;
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Construtor
    public Usuario(String nome, String Email,String senha, long telefone, String pais, String estado, long cep,String cidade, String bairro, String logradouro, String complemento, int numero) {
        this.nome = nome;
        this.Email = Email;
        this.senha = senha;
        this.telefone = telefone;
        this.pais = pais;
        this.estado = estado;
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
}


}
