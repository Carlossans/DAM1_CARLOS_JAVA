package E883CrudAgendaCompletoConConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
    private Connection conexion;
    private static final String URL = "jdbc:mysql://localhost:3306/agenda2";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    public void conectar() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar: " + e.getMessage());
        }
    }

    public PreparedStatement prepareStatement(String sql) {
        if (conexion == null) {
            System.out.println("Error: No hay conexión con la base de datos.");
            return null;
        }
        try {
            return conexion.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Error al preparar sentencia: " + e.getMessage());
            return null;
        }
    }

    public ResultSet ejecutarConsulta(PreparedStatement preparedStatement) {
        if (preparedStatement == null) {
            return null;
        }
        try {
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar consulta: " + e.getMessage());
            return null;
        }
    }

    public void ejecutarActualizacion(PreparedStatement preparedStatement) {
        try {
            int filas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas: " + filas);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar actualización: " + e.getMessage());
        }
    }

    public int ejecutarActualizacionConRetorno(PreparedStatement preparedStatement) {
        try {
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar actualización: " + e.getMessage());
            return 0;
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
