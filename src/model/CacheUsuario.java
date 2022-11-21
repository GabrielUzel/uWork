package model;

public class CacheUsuario {
    private static String usuario;
    
    public void setUsuario(String u) {
        CacheUsuario.usuario = u;
    }

    public String getUsuario() {
        return CacheUsuario.usuario;
    }
}