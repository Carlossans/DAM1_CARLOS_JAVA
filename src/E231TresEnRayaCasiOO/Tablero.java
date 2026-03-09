package E231TresEnRayaCasiOO;

public class Tablero {
    private static final int[][] matriz = new int[3][3];
    private static int jugadorActual = 1;
    private static int ultimaPosMarcadaFil = -1;
    private static int ultimaPosMarcadaCol = -1;
    private static int casillasMarcadas = 0;

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
            ultimaPosMarcadaFil = fila;
            ultimaPosMarcadaCol = columna;
            casillasMarcadas++;
        } else {
            System.out.println("Movimiento inválido. Pierdes el turno por despiste.");
            ultimaPosMarcadaFil--;
            ultimaPosMarcadaCol--;
        }
    }

    public static int getJugadorActual() {
        return jugadorActual;
    }

    public static void alternarJugador() {
        jugadorActual = (jugadorActual == 1) ? 2 : 1;
    }

    public static int buscarGanador() {
        if (ultimaPosMarcadaFil == -1) return -1;

        int f = ultimaPosMarcadaFil;
        int c = ultimaPosMarcadaCol;
        int jugador = matriz[f][c];

        // 1. Comprobar su FILA
        if (matriz[f][0] == jugador && matriz[f][1] == jugador && matriz[f][2] == jugador) return jugador;

        // 2. Comprobar su COLUMNA
        if (matriz[0][c] == jugador && matriz[1][c] == jugador && matriz[2][c] == jugador) return jugador;

        // 3. Comprobar DIAGONAL principal (solo si la casilla marcada pertenece a ella)
        if (f == c) {
            if (matriz[0][0] == jugador && matriz[1][1] == jugador && matriz[2][2] == jugador) return jugador;
        }

        // 4. Comprobar DIAGONAL secundaria (solo si la casilla marcada pertenece a ella)
        if (f + c == 2) {
            if (matriz[0][2] == jugador && matriz[1][1] == jugador && matriz[2][0] == jugador) return jugador;
        }

        // Si no hay ganador, comprobamos si hay tablas usando el contador
        if (casillasMarcadas == 9) return 0;

        // En cualquier otro caso, el juego continúa
        return -1;
    }
}