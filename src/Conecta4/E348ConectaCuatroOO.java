package Conecta4;

import java.util.Scanner;

public class E348ConectaCuatroOO {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int filas = 6;
        int columnas = 7;
        int[][] tablero = new int[filas][columnas];
        int[] fichasPorColumna = new int[columnas];

        int jugadorActual = 1;
        boolean juegoTerminado = false;
        int fichasTotales = 0;
        int maxFichas = filas * columnas;

        while (juegoTerminado == false && fichasTotales < maxFichas) {

            for (int i = 0; i < filas; i = i + 1) {
                for (int j = 0; j < columnas; j = j + 1) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Jugador " + jugadorActual + ", elige columna (0-6): ");
            int col = teclado.nextInt();

            if (col >= 0 && col < columnas && fichasPorColumna[col] < filas) {
                int filaDestino = (filas - 1) - fichasPorColumna[col];
                tablero[filaDestino][col] = jugadorActual;
                fichasPorColumna[col] = fichasPorColumna[col] + 1;
                fichasTotales = fichasTotales + 1;

                if (comprobarVictoria(tablero, filaDestino, col, jugadorActual, filas, columnas)) {
                    for (int i = 0; i < filas; i = i + 1) {
                        for (int j = 0; j < columnas; j = j + 1) {
                            System.out.print(tablero[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("¡El Jugador " + jugadorActual + " ha ganado!");
                    juegoTerminado = true;
                } else {
                    if (jugadorActual == 1) {
                        jugadorActual = 2;
                    } else {
                        jugadorActual = 1;
                    }
                }
            } else {
                System.out.println("Columna no válida o llena. Intenta otra vez.");
            }
        }

        if (fichasTotales == maxFichas && juegoTerminado == false) {
            System.out.println("Empate. Tablero lleno.");
        }
    }

    public static boolean comprobarVictoria(int[][] t, int f, int c, int j, int maxF, int maxC) {

        int vertical = 1;
        int filaAux = f + 1;
        while (filaAux < maxF && t[filaAux][c] == j) {
            vertical = vertical + 1;
            filaAux = filaAux + 1;
        }
        if (vertical >= 4) return true;

        int horizontal = 1;
        int colAux = c - 1;
        while (colAux >= 0 && t[f][colAux] == j) {
            horizontal = horizontal + 1;
            colAux = colAux - 1;
        }
        colAux = c + 1;
        while (colAux < maxC && t[f][colAux] == j) {
            horizontal = horizontal + 1;
            colAux = colAux + 1;
        }
        if (horizontal >= 4) return true;

        int diag1 = 1;
        int fA = f - 1;
        int cA = c - 1;
        while (fA >= 0 && cA >= 0 && t[fA][cA] == j) {
            diag1 = diag1 + 1;
            fA = fA - 1;
            cA = cA - 1;
        }
        fA = f + 1;
        cA = c + 1;
        while (fA < maxF && cA < maxC && t[fA][cA] == j) {
            diag1 = diag1 + 1;
            fA = fA + 1;
            cA = cA + 1;
        }
        if (diag1 >= 4) return true;

        int diag2 = 1;
        fA = f - 1;
        cA = c + 1;
        while (fA >= 0 && cA < maxC && t[fA][cA] == j) {
            diag2 = diag2 + 1;
            fA = fA - 1;
            cA = cA + 1;
        }
        fA = f + 1;
        cA = c - 1;
        while (fA < maxF && cA >= 0 && t[fA][cA] == j) {
            diag2 = diag2 + 1;
            fA = fA + 1;
            cA = cA - 1;
        }
        if (diag2 >= 4) return true;

        return false;
    }
}

