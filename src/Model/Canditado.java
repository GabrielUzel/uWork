package Model;

import java.util.Date;

public class Canditado {
    private int id_candidato;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private Formacao formacao;
    private Experiencia experiencia;
    private Date dataNascimeto;
    private String CPF;

    public Canditado() {}

    public void setIdCanditado(int id_candidato) { this.id_candidato = id_candidato; }
    public void setNome(String nome) { this.nome = nome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setDataNascimento(Date dataNascimento) { this.dataNascimeto = dataNascimento; }
    public void setCPF(String CPF) { this.CPF = CPF; }

    public int getIdCanditado() { return this.id_candidato; }
    public String getNome() { return this.nome; }
    public String getSobrenome() { return this.sobrenome; }
    public String getEmail() { return this.email; }
    public String getTelefone() { return this.telefone; }
    public String getCPF() { return this.CPF; }
    public Date getDataNascimento() { return this.dataNascimeto; }
}
