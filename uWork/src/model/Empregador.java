package model;

import java.util.Date;

public class Empregador {
    // Atributos
    private int id_empregador;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private Date dataNascimeto;

    // Construtor
    public Empregador(){}

    // Setters
    public void setIdEmpregador(int id_empregador) { this.id_empregador = id_empregador; }
    public void setNome(String nome) { this.nome = nome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    // Getters
    public int getIdEmpregador() { return this.id_empregador; }
    public String getNome() { return this.nome; }
    public String getSobrenome() { return this.sobrenome; }
    public String getEmail() { return this.email; }
    public String getTelefone() { return this.telefone; }
    public Date getDataNascimento() { return  this.dataNascimeto; }
}
