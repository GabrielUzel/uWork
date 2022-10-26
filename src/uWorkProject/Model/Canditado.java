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
    public Canditado(){}

    public void  setIdCanditado(int nom){
        this.id_candidato=nom;
    }
    public void  setNome(String nom){
        this.nome=nom;
    }
    public void  setSobrenome(String nom){
        this.sobrenome=nom;
    }
    public void  setEmail(String nom){
        this.email=nom;
    }
    public void  setTelefone(String nom){
        this.telefone=nom;
    }

    public void  setDataNascimento(Date nom){
        this.dataNascimeto=nom;
    }

    public void setCPF(String CPF){
        this.CPF=CPF;
    }

    public int  getIdCanditado(){
        return this.id_candidato;
    }
    public String getNome(){
       return this.nome;
    }
    public String   getSobrenome(){
        return this.sobrenome;
    }
    public String   getEmail(){
        return this.email;
    }
    public String getTelefone(){
        return this.telefone;
    }

    public String getCPF(){
        return this.CPF;
    }

    public Date  getDataNascimento(){
      return  this.dataNascimeto;
    }
}
