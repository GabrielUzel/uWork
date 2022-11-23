package model;

public class CacheUsuario {
    private static String usuario;
    
    public void setUsuario(String usuario) {
        CacheUsuario.usuario = usuario;
    }

    public String getUsuario() {
        return CacheUsuario.usuario;
    }
}