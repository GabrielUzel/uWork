package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {
    public ConectaBanco() {}

    public Connection conectar() throws  SQLException, ClassNotFoundException {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");

        return conn;
    }

    public void desconectar(Connection conn) throws  SQLException {
        if(conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Desconectou do banco de dados.");
        }
    }
}
