package model;

import java.util.Date;

class Empregador {
    // Atributos
    private int id_candidato;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private Date dataNascimeto;

    // Construtor
    public Empregador(){}

    // Setters
    public void setIdCanditado(int id_candidato) { this.id_candidato = id_candidato; }
    public void setNome(String nome) { this.nome = nome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    // Getters
    public int getIdCanditado() { return this.id_candidato; }
    public String getNome() { return this.nome; }
    public String getSobrenome() { return this.sobrenome; }
    public String getEmail() { return this.email; }
    public String getTelefone() { return this.telefone; }
    public Date getDataNascimento() { return  this.dataNascimeto; }
}