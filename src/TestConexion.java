import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexion {
    static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/agenda";
        String user = "root";
        String password = "";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("¡Conexión exitosa!");
        } catch (SQLException e) {
            System.out.println("Error al conectar " + e.getMessage());
        }
    }
}
