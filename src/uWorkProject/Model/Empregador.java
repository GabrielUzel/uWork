package Model;

import java.util.Date;

class Empregador{
    private int id_candidato;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private Date dataNascimeto;
    public Empregador(){}

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

    public Date  getDataNascimento(){
      return  this.dataNascimeto;
    }
}