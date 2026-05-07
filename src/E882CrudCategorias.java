import java.sql.*;
import java.util.Scanner;

public class E882CrudCategorias {
    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost:3306/agenda2";
        String usuarioBD = "root";
        String passwordBD = "";
        Scanner lectorTeclado = new Scanner(System.in);

        try {
            Connection conexionMenu = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD);
            int opcionPrincipal = -1;

            while (opcionPrincipal != 0) {
                System.out.println("\nMENÚ AGENDA");
                System.out.println("1. Listar categorías (A-Z)");
                System.out.println("2. Insertar categoría");
                System.out.println("3. Eliminar categoría");
                System.out.println("4. Modificar categoría");
                System.out.println("0. Salir");
                System.out.print("Elija opción: ");
                opcionPrincipal = Integer.parseInt(lectorTeclado.nextLine());

                if (opcionPrincipal == 1) {
                    String sqlListado = "SELECT * FROM categoria ORDER BY nombre ASC";
                    Statement stmtListado = conexionMenu.createStatement();
                    ResultSet rsListado = stmtListado.executeQuery(sqlListado);
                    System.out.println("\nID | NOMBRE");
                    while (rsListado.next()) {
                        System.out.println(rsListado.getInt("id") + " | " + rsListado.getString("nombre"));
                    }
                }

                else if (opcionPrincipal == 2) {
                    System.out.print("Nombre de la nueva categoría (o 'cancelar'): ");
                    String nombreNuevo = lectorTeclado.nextLine();
                    if (!nombreNuevo.equalsIgnoreCase("cancelar")) {
                        String sqlInsert = "INSERT INTO categoria (nombre) VALUES (?)";
                        PreparedStatement psInsert = conexionMenu.prepareStatement(sqlInsert);
                        psInsert.setString(1, nombreNuevo);
                        psInsert.executeUpdate();
                        System.out.println("Categoría añadida.");
                    }
                }

                else if (opcionPrincipal == 3) {
                    System.out.println("1. Por ID | 2. Por Nombre | 0. Cancelar");
                    int subOpcionDel = Integer.parseInt(lectorTeclado.nextLine());
                    if (subOpcionDel == 1) {
                        System.out.print("ID a borrar: ");
                        int idBorrar = Integer.parseInt(lectorTeclado.nextLine());
                        String sqlDelId = "DELETE FROM categoria WHERE id = ?";
                        PreparedStatement psDelId = conexionMenu.prepareStatement(sqlDelId);
                        psDelId.setInt(1, idBorrar);
                        int filasId = psDelId.executeUpdate();
                        System.out.println(filasId > 0 ? "Borrado con éxito." : "ID no encontrado.");
                    } else if (subOpcionDel == 2) {
                        System.out.print("Nombre a borrar: ");
                        String nomBorrar = lectorTeclado.nextLine();
                        String sqlDelNom = "DELETE FROM categoria WHERE nombre = ?";
                        PreparedStatement psDelNom = conexionMenu.prepareStatement(sqlDelNom);
                        psDelNom.setString(1, nomBorrar);
                        int filasNom = psDelNom.executeUpdate();
                        System.out.println(filasNom > 0 ? "Borrado con éxito." : "Nombre no encontrado.");
                    }
                }

                else if (opcionPrincipal == 4) {
                    System.out.print("ID de la categoría a modificar (o 0 para cancelar): ");
                    int idMod = Integer.parseInt(lectorTeclado.nextLine());
                    if (idMod != 0) {
                        String sqlBusca = "SELECT nombre FROM categoria WHERE id = ?";
                        PreparedStatement psBusca = conexionMenu.prepareStatement(sqlBusca);
                        psBusca.setInt(1, idMod);
                        ResultSet rsBusca = psBusca.executeQuery();

                        if (rsBusca.next()) {
                            String nombreActual = rsBusca.getString("nombre");
                            boolean modificado = false;
                            while (!modificado) {
                                System.out.print("Nuevo nombre (actual: " + nombreActual + ") o 'cancelar': ");
                                String nombreEdit = lectorTeclado.nextLine();
                                if (nombreEdit.equalsIgnoreCase("cancelar")) break;

                                if (nombreEdit.equals(nombreActual)) {
                                    System.out.println("El nombre es igual al actual. Intente de nuevo.");
                                } else {
                                    String sqlUpdate = "UPDATE categoria SET nombre = ? WHERE id = ?";
                                    PreparedStatement psUpdate = conexionMenu.prepareStatement(sqlUpdate);
                                    psUpdate.setString(1, nombreEdit);
                                    psUpdate.setInt(2, idMod);
                                    psUpdate.executeUpdate();
                                    System.out.println("Categoría actualizada.");
                                    modificado = true;
                                }
                            }
                        } else {
                            System.out.println("No existe esa categoría.");
                        }
                    }
                }
            }
            conexionMenu.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}