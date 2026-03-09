package E231TresEnRayaCasiOO;

public class Tablero {
    private static final int[][] matriz = new int[3][3];
    private static int jugadorActual = 1;

    public static void dibujar() {
        System.out.println("\n  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                char hueco = ' ';
                if (matriz[i][j] == 1) hueco = 'X';
                else if (matriz[i][j] == 2) hueco = 'O';
                System.out.print(hueco + (j < 2 ? " | " : ""));
            }
            if (i < 2) System.out.println("\n -----------");
        }
        System.out.println("\n");
    }

    public static void marcar(int fil, int col) {
        int fila = fil - 1;
        int columna = col - 1;

        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && matriz[fila][columna] == 0) {
            matriz[fila][columna] = jugadorActual;
        } else {
            System.out.println("Movimiento inválido. Pierdes el turno por despiste.");
        }
    }

    public static int getJugadorActual() {
        return jugadorActual;
    }

    public static void alternarJugador() {
        jugadorActual = (jugadorActual == 1) ? 2 : 1;
    }

    public static int buscarGanador() {
        // filas y columnas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] != 0 && matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2]) return matriz[i][0];
            if (matriz[0][i] != 0 && matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i]) return matriz[0][i];
        }

        // Diagonales
        if (matriz[0][0] != 0 && matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2]) return matriz[0][0];
        if (matriz[0][2] != 0 && matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0]) return matriz[0][2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == 0) return -1;
            }
        }
        return 0;
    }
}