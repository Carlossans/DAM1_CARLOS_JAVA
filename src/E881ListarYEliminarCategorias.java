import java.sql.*;
import java.util.Scanner;

public class E881ListarYEliminarCategorias {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/gestion_usuarios";
        String user = "root";
        String pass = "";
        Scanner sc = new Scanner(System.in);

        try {
            Connection conMenu = DriverManager.getConnection(url, user, pass);
            int opcionMenu = -1;

            while (opcionMenu != 0) {
                System.out.println("\nGESTIÓN DE CATEGORÍAS");
                System.out.println("1. Listar categorías (A-Z)");
                System.out.println("2. Eliminar categoría");
                System.out.println("0. Salir");
                System.out.print("Seleccione: ");
                opcionMenu = Integer.parseInt(sc.nextLine());

                if (opcionMenu == 1) {
                    String sqlListar = "SELECT * FROM categorias ORDER BY nombre ASC";
                    Statement stmtListar = conMenu.createStatement();
                    ResultSet rsListar = stmtListar.executeQuery(sqlListar);
                    System.out.println("\nID | NOMBRE");
                    while (rsListar.next()) {
                        System.out.println(rsListar.getInt("id_categoria") + " | " + rsListar.getString("nombre"));
                    }
                }

                else if (opcionMenu == 2) {
                    System.out.println("\n--- ELIMINAR ---");
                    System.out.println("1. Por ID");
                    System.out.println("2. Por Nombre");
                    System.out.println("0. Cancelar (Volver)");
                    System.out.print("Elección: ");
                    int modoEliminar = Integer.parseInt(sc.nextLine());

                    if (modoEliminar == 1) {
                        System.out.print("ID a borrar: ");
                        int idABorrar = Integer.parseInt(sc.nextLine());
                        String sqlDelId = "DELETE FROM categorias WHERE id_categoria = ?";
                        PreparedStatement psDelId = conMenu.prepareStatement(sqlDelId);
                        psDelId.setInt(1, idABorrar);
                        int filasId = psDelId.executeUpdate();
                        System.out.println(filasId > 0 ? "Borrado ok." : "No encontrado.");
                    }
                    else if (modoEliminar == 2) {
                        System.out.print("Nombre a borrar: ");
                        String nomABorrar = sc.nextLine();
                        String sqlDelNom = "DELETE FROM categorias WHERE nombre = ?";
                        PreparedStatement psDelNom = conMenu.prepareStatement(sqlDelNom);
                        psDelNom.setString(1, nomABorrar);
                        int filasNom = psDelNom.executeUpdate();
                        System.out.println(filasNom > 0 ? "Borrado ok." : "No encontrado.");
                    }
                }
            }
            conMenu.close();
        } catch (SQLException e) {
            System.out.println();
        }
    }
}