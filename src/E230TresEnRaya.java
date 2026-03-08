import java.util.Scanner;

public class E230TresEnRaya {

    private static final int[][] TABLERO = new int[3][3];

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("¿Sobreescribir? (1 =S i, 0= No): ");
        boolean permitir = teclado.nextInt() == 1;

        int jugador = 1;
        boolean fin = false;
        int fichas = 0;

        while (!fin && (permitir || fichas < 9)) {
            dibujarTablero();
            System.out.println("Turno Jugador " + jugador + " (" + (jugador == 1 ? 'X' : 'O') + ")");
            System.out.print("Fila: "); int f = teclado.nextInt() - 1;
            System.out.print("Col: "); int c = teclado.nextInt() - 1;

            if (f >= 0 && f < 3 && c >= 0 && c < 3) {
                if (TABLERO[f][c] == 0 || (permitir && TABLERO[f][c] != jugador)) {
                    if (TABLERO[f][c] == 0) fichas++;
                    TABLERO[f][c] = jugador;

                    if (comprobarVictoria()) {
                        fin = true;
                    } else {
                        jugador = (jugador == 1) ? 2 : 1;
                    }
                } else {
                    System.out.println("Movimiento no valido");
                }
            } else {
                System.out.println("Fuera de rango (1-3)");
            }
        }

        dibujarTablero();
        if (fin) {
            System.out.println("¡Gana el Jugador " + jugador + "!");
        } else {
            System.out.println("Empate.");
        }
    }

    public static void dibujarTablero() {
        System.out.println("\n  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                char v = ' ';
                if (TABLERO[i][j] == 1) v = 'X';
                else if (TABLERO[i][j] == 2) v = 'O';
                System.out.print(v + (j < 2 ? " | " : ""));
            }
            if (i < 2) System.out.println("\n -----------");
        }
        System.out.println("\n");
    }

    public static boolean comprobarVictoria() {
        for (int i = 0; i < 3; i++) {
            if (TABLERO[i][0] != 0 && TABLERO[i][0] == TABLERO[i][1] && TABLERO[i][1] == TABLERO[i][2]) return true;
            if (TABLERO[0][i] != 0 && TABLERO[0][i] == TABLERO[1][i] && TABLERO[1][i] == TABLERO[2][i]) return true;
        }
        if (TABLERO[0][0] != 0 && TABLERO[0][0] == TABLERO[1][1] && TABLERO[1][1] == TABLERO[2][2]) return true;
        if (TABLERO[0][2] != 0 && TABLERO[0][2] == TABLERO[1][1] && TABLERO[1][1] == TABLERO[2][0]) return true;
        return false;
    }
}