package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {
    public ConectaBanco() {}

    public Connection conectar() throws  SQLException, ClassNotFoundException {
        Connection conexao = null;
        Class.forName("org.postgresql.Driver");
        conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "3626");//mudar senha e usuario

        return conexao;
    }

    public void desconectar(Connection conn) throws  SQLException {
        if(conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Desconectou do banco de dados.");
        }
    }
}
