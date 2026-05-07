package E883CrudAgendaCompletoConConexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
    private static ConexionBD conexionBD;
    private static Scanner sc;

    public static void main(String[] args) {
        conexionBD = new ConexionBD();
        sc = new Scanner(System.in);

        conexionBD.conectar();
        mostrarMenuPrincipal();
        conexionBD.desconectar();
    }

    private static void mostrarMenuPrincipal() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. GESTIÓN DE CATEGORÍAS");
            System.out.println("2. GESTIÓN DE PERSONAS");
            System.out.println("0. SALIR");
            System.out.print("Seleccione opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> menuCategorias();
                    case 2 -> menuPersonas();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un número válido.");
            }
        }
    }

    private static void menuCategorias() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\nGESTIÓN DE CATEGORÍAS");
            System.out.println("1. Listar categorías (A-Z)");
            System.out.println("2. Obtener categoría por ID");
            System.out.println("3. Insertar categoría");
            System.out.println("4. Eliminar categoría");
            System.out.println("5. Modificar categoría");
            System.out.println("0. VOLVER AL MENÚ PRINCIPAL");
            System.out.print("Seleccione opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> listarCategorias();
                    case 2 -> obtenerCategoriaPorId();
                    case 3 -> insertarCategoria();
                    case 4 -> eliminarCategoria();
                    case 5 -> modificarCategoria();
                    case 0 -> System.out.println("Volviendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un número válido.");
            }
        }
    }

    private static void listarCategorias() {
        String sql = "SELECT * FROM categoria ORDER BY nombre ASC";
        PreparedStatement ps = conexionBD.prepareStatement(sql);
        if (ps == null) {
            System.out.println("Error al preparar la consulta.");
            return;
        }
        ResultSet rs = conexionBD.ejecutarConsulta(ps);

        if (rs == null) {
            System.out.println("Error al ejecutar la consulta.");
            return;
        }

        System.out.println("\nID | NOMBRE");
        System.out.println("--------------");
        try {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
    }

    private static void obtenerCategoriaPorId() {
        System.out.print("Introduzca ID de la categoría: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID no válido.");
            return;
        }

        String sql = "SELECT * FROM categoria WHERE id = ?";
        PreparedStatement ps = conexionBD.prepareStatement(sql);
        if (ps == null) {
            System.out.println("Error al preparar la consulta.");
            return;
        }
        try {
            ps.setInt(1, id);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        ResultSet rs = conexionBD.ejecutarConsulta(ps);
        if (rs == null) {
            System.out.println("Error al ejecutar la consulta.");
            return;
        }

        try {
            if (rs.next()) {
                System.out.println("\nCategoría encontrada:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
            } else {
                System.out.println("No existe ninguna categoría con ID " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void insertarCategoria() {
        System.out.print("Nombre de la nueva categoría (o 'cancelar'): ");
        String nombre = sc.nextLine();

        if (nombre.equalsIgnoreCase("cancelar")) {
            System.out.println("Operación cancelada.");
            return;
        }

        if (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        String sql = "INSERT INTO categoria (nombre) VALUES (?)";
        PreparedStatement ps = conexionBD.prepareStatement(sql);
        if (ps == null) {
            System.out.println("Error al preparar la inserción.");
            return;
        }
        try {
            ps.setString(1, nombre);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        conexionBD.ejecutarActualizacion(ps);
        System.out.println("Categoría insertada correctamente.");
    }

    private static void eliminarCategoria() {
        System.out.println("\n1. Eliminar por ID");
        System.out.println("2. Eliminar por NOMBRE");
        System.out.println("0. Cancelar");
        System.out.print("Seleccione opción: ");

        int opcion;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opción no válida.");
            return;
        }

        if (opcion == 0) {
            System.out.println("Operación cancelada.");
            return;
        }

        if (opcion == 1) {
            System.out.print("ID de la categoría a eliminar: ");
            int id;
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ID no válido.");
                return;
            }

            String sql = "DELETE FROM categoria WHERE id = ?";
            PreparedStatement ps = conexionBD.prepareStatement(sql);
            if (ps == null) {
                System.out.println("Error al preparar la eliminación.");
                return;
            }
            try {
                ps.setInt(1, id);
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }
            int filas = conexionBD.ejecutarActualizacionConRetorno(ps);
            System.out.println(filas > 0 ? "Categoría eliminada." : "No se encontró ninguna categoría con ese ID.");

        } else if (opcion == 2) {
            System.out.print("Nombre de la categoría a eliminar: ");
            String nombre = sc.nextLine();

            String sql = "DELETE FROM categoria WHERE nombre = ?";
            PreparedStatement ps = conexionBD.prepareStatement(sql);
            if (ps == null) {
                System.out.println("Error al preparar la eliminación.");
                return;
            }
            try {
                ps.setString(1, nombre);
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }
            int filas = conexionBD.ejecutarActualizacionConRetorno(ps);
            System.out.println(filas > 0 ? "Categoría eliminada." : "No se encontró ninguna categoría con ese nombre.");

        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void modificarCategoria() {
        System.out.print("ID de la categoría a modificar (0 para cancelar): ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID no válido.");
            return;
        }

        if (id == 0) {
            System.out.println("Operación cancelada.");
            return;
        }

        String sqlBusqueda = "SELECT * FROM categoria WHERE id = ?";
        PreparedStatement psBusqueda = conexionBD.prepareStatement(sqlBusqueda);
        if (psBusqueda == null) {
            System.out.println("Error al preparar la consulta.");
            return;
        }
        try {
            psBusqueda.setInt(1, id);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        ResultSet rs = conexionBD.ejecutarConsulta(psBusqueda);
        if (rs == null) {
            System.out.println("Error al ejecutar la consulta.");
            return;
        }

        try {
            if (!rs.next()) {
                System.out.println("No existe ninguna categoría con ID " + id);
                return;
            }

            String nombreActual = rs.getString("nombre");
            boolean modificado = false;

            while (!modificado) {
                System.out.print("Nuevo nombre (actual: " + nombreActual + ") o 'cancelar': ");
                String nuevoNombre = sc.nextLine();

                if (nuevoNombre.equalsIgnoreCase("cancelar")) {
                    System.out.println("Operación cancelada.");
                    return;
                }

                if (nuevoNombre.equals(nombreActual)) {
                    System.out.println("El nombre es igual al actual. No se ha modificado nada.");
                } else {
                    String sqlUpdate = "UPDATE categoria SET nombre = ? WHERE id = ?";
                    PreparedStatement psUpdate = conexionBD.prepareStatement(sqlUpdate);
                    if (psUpdate == null) {
                        System.out.println("Error al preparar la actualización.");
                        return;
                    }
                    try {
                        psUpdate.setString(1, nuevoNombre);
                        psUpdate.setInt(2, id);
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                        return;
                    }
                    conexionBD.ejecutarActualizacion(psUpdate);
                    System.out.println("Categoría modificada correctamente.");
                    modificado = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void menuPersonas() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\nGESTIÓN DE PERSONAS");
            System.out.println("1. Listar personas");
            System.out.println("2. Obtener persona por ID");
            System.out.println("3. Insertar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Modificar persona");
            System.out.println("0. VOLVER AL MENÚ PRINCIPAL");
            System.out.print("Seleccione opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> listarPersonas();
                    case 2 -> obtenerPersonaPorId();
                    case 3 -> insertarPersona();
                    case 4 -> eliminarPersona();
                    case 5 -> modificarPersona();
                    case 0 -> System.out.println("Volviendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un número válido.");
            }
        }
    }

    private static void listarPersonas() {
        String sql = "SELECT p.id_persona, p.nombre, p.edad, p.id_categoria, c.nombre as categoria_nombre " +
                     "FROM persona p LEFT JOIN categoria c ON p.id_categoria = c.id " +
                     "ORDER BY p.nombre ASC";
        PreparedStatement ps = conexionBD.prepareStatement(sql);
        if (ps == null) {
            System.out.println("Error al preparar la consulta.");
            return;
        }
        ResultSet rs = conexionBD.ejecutarConsulta(ps);
        if (rs == null) {
            System.out.println("Error al ejecutar la consulta.");
            return;
        }

        System.out.println("\nID | NOMBRE | EDAD | CATEGORÍA");
        System.out.println("----------------------------------------");
        try {
            while (rs.next()) {
                int id = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String categoriaNombre = rs.getString("categoria_nombre");
                String categoriaStr = (categoriaNombre != null) ? categoriaNombre : "Sin categoría";
                System.out.println(id + " | " + nombre + " | " + edad + " | " + categoriaStr);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
    }

    private static void obtenerPersonaPorId() {
        System.out.print("Introduzca ID de la persona: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID no válido.");
            return;
        }

        String sql = "SELECT p.id_persona, p.nombre, p.edad, p.id_categoria, c.nombre as categoria_nombre " +
                     "FROM persona p LEFT JOIN categoria c ON p.id_categoria = c.id " +
                     "WHERE p.id_persona = ?";
        PreparedStatement ps = conexionBD.prepareStatement(sql);
        if (ps == null) {
            System.out.println("Error al preparar la consulta.");
            return;
        }
        try {
            ps.setInt(1, id);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        ResultSet rs = conexionBD.ejecutarConsulta(ps);
        if (rs == null) {
            System.out.println("Error al ejecutar la consulta.");
            return;
        }

        try {
            if (rs.next()) {
                System.out.println("\nPersona encontrada:");
                System.out.println("ID: " + rs.getInt("id_persona"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Edad: " + rs.getInt("edad"));
                String categoriaNombre = rs.getString("categoria_nombre");
                System.out.println("Categoría: " + (categoriaNombre != null ? categoriaNombre : "Sin categoría"));
            } else {
                System.out.println("No existe ninguna persona con ID " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void insertarPersona() {
        System.out.print("Nombre de la persona: ");
        String nombre = sc.nextLine();

        if (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Edad: ");
        int edad;
        try {
            edad = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Edad no válida.");
            return;
        }

        System.out.print("ID de categoría (0 si no tiene): ");
        int idCategoria;
        try {
            idCategoria = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID de categoría no válido.");
            return;
        }

        String sql;
        PreparedStatement ps;
        if (idCategoria == 0) {
            sql = "INSERT INTO persona (nombre, edad) VALUES (?, ?)";
            ps = conexionBD.prepareStatement(sql);
            if (ps == null) {
                System.out.println("Error al preparar la inserción.");
                return;
            }
            try {
                ps.setString(1, nombre);
                ps.setInt(2, edad);
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }
        } else {
            sql = "INSERT INTO persona (nombre, edad, id_categoria) VALUES (?, ?, ?)";
            ps = conexionBD.prepareStatement(sql);
            if (ps == null) {
                System.out.println("Error al preparar la inserción.");
                return;
            }
            try {
                ps.setString(1, nombre);
                ps.setInt(2, edad);
                ps.setInt(3, idCategoria);
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }
        }

        conexionBD.ejecutarActualizacion(ps);
        System.out.println("Persona insertada correctamente.");
    }

    private static void eliminarPersona() {
        System.out.print("ID de la persona a eliminar (0 para cancelar): ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID no válido.");
            return;
        }

        if (id == 0) {
            System.out.println("Operación cancelada.");
            return;
        }

        String sql = "DELETE FROM persona WHERE id_persona = ?";
        PreparedStatement ps = conexionBD.prepareStatement(sql);
        if (ps == null) {
            System.out.println("Error al preparar la eliminación.");
            return;
        }
        try {
            ps.setInt(1, id);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        int filas = conexionBD.ejecutarActualizacionConRetorno(ps);
        System.out.println(filas > 0 ? "Persona eliminada." : "No se encontró ninguna persona con ese ID.");
    }

    private static void modificarPersona() {
        System.out.print("ID de la persona a modificar (0 para cancelar): ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID no válido.");
            return;
        }

        if (id == 0) {
            System.out.println("Operación cancelada.");
            return;
        }

        String sqlBusqueda = "SELECT * FROM persona WHERE id_persona = ?";
        PreparedStatement psBusqueda = conexionBD.prepareStatement(sqlBusqueda);
        if (psBusqueda == null) {
            System.out.println("Error al preparar la consulta.");
            return;
        }
        try {
            psBusqueda.setInt(1, id);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        ResultSet rs = conexionBD.ejecutarConsulta(psBusqueda);
        if (rs == null) {
            System.out.println("Error al ejecutar la consulta.");
            return;
        }

        try {
            if (!rs.next()) {
                System.out.println("No existe ninguna persona con ID " + id);
                return;
            }

            String nombreActual = rs.getString("nombre");
            int edadActual = rs.getInt("edad");
            int idCategoriaActual = rs.getInt("id_categoria");

            System.out.println("\nDatos actuales:");
            System.out.println("Nombre: " + nombreActual);
            System.out.println("Edad: " + edadActual);
            System.out.println("ID Categoría: " + (idCategoriaActual == 0 ? "Sin categoría" : idCategoriaActual));

            System.out.print("\nNuevo nombre (Enter para mantener actual): ");
            String nuevoNombre = sc.nextLine();
            if (nuevoNombre.trim().isEmpty()) {
                nuevoNombre = nombreActual;
            }

            System.out.print("Nueva edad (Enter para mantener actual): ");
            String edadStr = sc.nextLine();
            int nuevaEdad;
            if (edadStr.trim().isEmpty()) {
                nuevaEdad = edadActual;
            } else {
                try {
                    nuevaEdad = Integer.parseInt(edadStr);
                } catch (NumberFormatException e) {
                    System.out.println("Edad no válida, se mantiene la actual.");
                    nuevaEdad = edadActual;
                }
            }

            System.out.print("Nueva ID de categoría (Enter para mantener actual, 0 para sin categoría): ");
            String idCatStr = sc.nextLine();
            Integer nuevaIdCategoria = null;
            if (idCatStr.trim().isEmpty()) {
                nuevaIdCategoria = idCategoriaActual == 0 ? null : idCategoriaActual;
            } else {
                try {
                    nuevaIdCategoria = Integer.parseInt(idCatStr);
                } catch (NumberFormatException e) {
                    System.out.println("ID de categoría no válida, se mantiene la actual.");
                    nuevaIdCategoria = idCategoriaActual == 0 ? null : idCategoriaActual;
                }
            }

            String sqlUpdate;
            PreparedStatement psUpdate;
            if (nuevaIdCategoria == null || nuevaIdCategoria == 0) {
                sqlUpdate = "UPDATE persona SET nombre = ?, edad = ? WHERE id_persona = ?";
                psUpdate = conexionBD.prepareStatement(sqlUpdate);
                if (psUpdate == null) {
                    System.out.println("Error al preparar la actualización.");
                    return;
                }
                try {
                    psUpdate.setString(1, nuevoNombre);
                    psUpdate.setInt(2, nuevaEdad);
                    psUpdate.setInt(3, id);
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                    return;
                }
            } else {
                sqlUpdate = "UPDATE persona SET nombre = ?, edad = ?, id_categoria = ? WHERE id_persona = ?";
                psUpdate = conexionBD.prepareStatement(sqlUpdate);
                if (psUpdate == null) {
                    System.out.println("Error al preparar la actualización.");
                    return;
                }
                try {
                    psUpdate.setString(1, nuevoNombre);
                    psUpdate.setInt(2, nuevaEdad);
                    psUpdate.setInt(3, nuevaIdCategoria);
                    psUpdate.setInt(4, id);
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                    return;
                }
            }

            conexionBD.ejecutarActualizacion(psUpdate);
            System.out.println("Persona modificada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
