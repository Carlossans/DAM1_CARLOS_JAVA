import java.sql.*;

public class E880PruebaDeConceptoBBDD {
    public static void main(String[] args) {
        String urlConexion = "jdbc:mysql://localhost:3306/gestion_usuarios";
        String usuarioDB = "root";
        String passwordDB = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexionPrincipal = DriverManager.getConnection(urlConexion, usuarioDB, passwordDB);

            String sqlListarCat = "SELECT * FROM categorias";
            Statement stmtListarCat = conexionPrincipal.createStatement();
            ResultSet rsListarCat = stmtListarCat.executeQuery(sqlListarCat);
            while (rsListarCat.next()) {
                System.out.println(rsListarCat.getInt("id_categoria") + " - " + rsListarCat.getString("nombre"));
            }

            String sqlListarPers = "SELECT * FROM personas";
            Statement stmtListarPers = conexionPrincipal.createStatement();
            ResultSet rsListarPers = stmtListarPers.executeQuery(sqlListarPers);
            while (rsListarPers.next()) {
                System.out.println(rsListarPers.getInt("id_persona") + " - " + rsListarPers.getString("nombre") + " - " + rsListarPers.getInt("edad"));
            }

            String sqlInsertarCat = "INSERT INTO categorias (nombre) VALUES (?)";
            PreparedStatement psInsertarCat = conexionPrincipal.prepareStatement(sqlInsertarCat);
            psInsertarCat.setString(1, "Nueva Categoria");
            psInsertarCat.executeUpdate();

            String sqlInsertarPers = "INSERT INTO personas (nombre, edad, id_categoria) VALUES (?, ?, ?)";
            PreparedStatement psInsertarPers = conexionPrincipal.prepareStatement(sqlInsertarPers);
            psInsertarPers.setString(1, "Juan Perez");
            psInsertarPers.setInt(2, 30);
            psInsertarPers.setInt(3, 1);
            psInsertarPers.executeUpdate();

            String sqlEliminarCat = "DELETE FROM categorias WHERE id_categoria = ?";
            PreparedStatement psEliminarCat = conexionPrincipal.prepareStatement(sqlEliminarCat);
            psEliminarCat.setInt(1, 99);
            psEliminarCat.executeUpdate();

            String sqlEliminarPers = "DELETE FROM personas WHERE id_persona = ?";
            PreparedStatement psEliminarPers = conexionPrincipal.prepareStatement(sqlEliminarPers);
            psEliminarPers.setInt(1, 99);
            psEliminarPers.executeUpdate();

            String sqlModificarCat = "UPDATE categorias SET nombre = ? WHERE id_categoria = ?";
            PreparedStatement psModificarCat = conexionPrincipal.prepareStatement(sqlModificarCat);
            psModificarCat.setString(1, "Nombre Editado");
            psModificarCat.setInt(2, 1);
            psModificarCat.executeUpdate();

            String sqlModificarEdad = "UPDATE personas SET edad = ? WHERE id_persona = ?";
            PreparedStatement psModificarEdad = conexionPrincipal.prepareStatement(sqlModificarEdad);
            psModificarEdad.setInt(1, 45);
            psModificarEdad.setInt(2, 1);
            psModificarEdad.executeUpdate();

            String sqlIncrementarEdad = "UPDATE personas SET edad = edad + 1 WHERE id_persona = ?";
            PreparedStatement psIncrementarEdad = conexionPrincipal.prepareStatement(sqlIncrementarEdad);
            psIncrementarEdad.setInt(1, 1);
            psIncrementarEdad.executeUpdate();

            conexionPrincipal.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}