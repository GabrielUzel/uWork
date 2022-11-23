package controller;
public class RecID {
    private static String nome;
    private static String Email;
    private static String senha;
    private static long telefone;
    private static String pais;
    private static String estado;
    private static long cep;
    private static String cidade;
    private static String bairro;
    private static String logradouro;
    private static String complemento;
    private static int numero;
     
    // Setters
    public static void setNome(String nome1) { nome = nome1; }
    public static void setEmail(String Email1) { Email = Email1; }
    public static void setSenha(String senha1) { senha = senha1; }
    public static void setTelefone(long telefone1) { telefone = telefone1; }
    public static void setPais(String pais1) { pais = pais1; }
    public static void setEstado(String estado1) { estado = estado1; }
    public static void setCep(long cep1) { cep = cep1; }
    public static void setCidade(String cidade1) { cidade = cidade1; }
    public static void setBairro(String bairro1) { bairro = bairro1; }
    public static void setLogradouro(String logradouro1) {logradouro = logradouro1; }
    public static void setComplemento(String complemento1) { complemento = complemento1; }
    public static void setNumero(int numero1) { numero = numero1; }

    // Getters
    public static String getNome() { return nome; }
    public static String getEmail() { return Email; }
    public static String getSenha() { return senha; }
    public static long getTelefone() { return telefone; }
    public static String getPais() { return pais; }
    public static String getEstado() { return estado; }
    public static long getCep() { return cep; }
    public static String getCidade() { return cidade; }
    public static String getBairro() { return bairro; }
    public static String getLogradouro() { return logradouro; }
    public static String getComplemento() { return complemento; }
    public static int getNumero() { return numero; }
    
}
