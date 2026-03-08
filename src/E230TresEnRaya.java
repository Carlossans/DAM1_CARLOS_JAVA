import java.util.Scanner;

public class E230TresEnRaya {

    private static final int[][] TABLERO = new int[3][3];

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("¿Permitir sobreescribir casillas? (s/n): ");
        boolean permitirSobreescribir = teclado.next().equalsIgnoreCase("s");

        int jugadorActual = 1;
        boolean alguienGano = false;
        int casillasMarcadas = 0;

        // Si permitimos sobreescribir, la condición de "casillasMarcadas < 9" no debe detener el juego
        while (!alguienGano && (permitirSobreescribir || casillasMarcadas < 9)) {
            dibujarTablero(TABLERO);
            System.out.println("Turno Jugador " + jugadorActual + " (" + (jugadorActual == 1 ? 'X' : 'O') + ")");
            System.out.print("Fila (0-2): "); int f = teclado.nextInt();
            System.out.print("Col (0-2): "); int c = teclado.nextInt();

            // Lógica de movimiento
            if (TABLERO[f][c] == 0 || (permitirSobreescribir && TABLERO[f][c] != jugadorActual)) {
                
                if (TABLERO[f][c] == 0) casillasMarcadas++;
                
                TABLERO[f][c] = jugadorActual;

                if (comprobarVictoria(TABLERO)) {
                    alguienGano = true;
                } else {
                    jugadorActual = (jugadorActual == 1) ? 2 : 1;
                }
            } else {
                System.out.println("¡Movimiento no válido! (Casilla ocupada o ya es tuya)");
            }
        }

        dibujarTablero(TABLERO);
        if (alguienGano) {
            System.out.println("¡FINAL! El Jugador " + jugadorActual + " ha ganado.");
        } else {
            // Esto solo ocurrirá si permitirSobreescribir es false y se llenó el tablero
            System.out.println("Empate: Tablero lleno sin ganador.");
        }
    }

    public static void dibujarTablero(int[][] t) {
        System.out.println("\n  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                char v = (t[i][j] == 1) ? 'X' : (t[i][j] == 2) ? 'O' : ' ';
                System.out.print(v + (j < 2 ? " | " : ""));
            }
            if (i < 2) System.out.println("\n -----------");
        }
        System.out.println();
    }

    public static boolean comprobarVictoria(int[][] t) {
        for (int i = 0; i < 3; i++) {
            if (t[i][0] != 0 && t[i][0] == t[i][1] && t[i][1] == t[i][2]) return true;
            if (t[0][i] != 0 && t[0][i] == t[1][i] && t[1][i] == t[2][i]) return true;
        }
        if (t[0][0] != 0 && t[0][0] == t[1][1] && t[1][1] == t[2][2]) return true;
        if (t[0][2] != 0 && t[0][2] == t[1][1] && t[1][1] == t[2][0]) return true;
        return false;
    }
}