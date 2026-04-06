package b400OOAVANZADA.b40000avanzada.Animales.HundirLaFlota;

import java.util.Scanner;

public class JuegoHundirLaFlota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 2;
        Tablero[] tableros = new Tablero[n];
        boolean[] eliminado = new boolean[n];

        for (int i = 0; i < n; i = i + 1) {
            tableros[i] = new Tablero();
            System.out.println("Jugador " + (i + 1) + ", coloca tus barcos.");
            int[] tamanos = {1, 2, 3, 4, 5};
            String[] nombres = {"Lancha", "Crucero", "Submarino", "Buque", "Portaaviones"};

            for (int j = 0; j < 5; j = j + 1) {
                boolean colocado = false;
                while (colocado == false) {
                    System.out.println("Colocando " + nombres[j] + " (tamaño " + tamanos[j] + ")");
                    System.out.print("Fila: ");
                    int f = sc.nextInt();
                    System.out.print("Columna: ");
                    int c = sc.nextInt();
                    System.out.print("Vertical (true/false): ");
                    boolean v = sc.nextBoolean();

                    Barco nuevo = new Barco(tableros[i], nombres[j], tamanos[j]);
                    if (nuevo.situar(f, c, v)) {
                        tableros[i].agregarBarco(nuevo);
                        colocado = true;
                    } else {
                        System.out.println("Posición inválida.");
                    }
                }
            }
        }

        int turno = 0;
        int activos = n;
        while (activos > 1) {
            if (eliminado[turno] == false) {
                boolean sigueDisparando = true;
                while (sigueDisparando && activos > 1) {
                    System.out.println("Turno de Jugador " + (turno + 1));
                    System.out.print("¿A qué jugador disparas? ");
                    int objetivo = sc.nextInt() - 1;

                    if (objetivo == turno || objetivo < 0 || objetivo >= n || eliminado[objetivo]) {
                        System.out.println("Objetivo no válido.");
                        continue;
                    }

                    System.out.print("Fila: ");
                    int f = sc.nextInt();
                    System.out.print("Columna: ");
                    int c = sc.nextInt();

                    ResultadoDisparo res = tableros[objetivo].recibirDisparo(f, c);
                    System.out.println("Resultado: " + res);

                    if (res == ResultadoDisparo.AGUA) {
                        sigueDisparando = false;
                    } else {
                        if (tableros[objetivo].estaTodoHundido()) {
                            System.out.println("¡Jugador " + (objetivo + 1) + " eliminado!");
                            eliminado[objetivo] = true;
                            activos = activos - 1;
                        }
                    }
                }
            }
            turno = (turno + 1) % n;
        }

        for (int i = 0; i < n; i = i + 1) {
            if (eliminado[i] == false) {
                System.out.println("¡El Jugador " + (i + 1) + " ha ganado la partida!");
            }
        }
    }
}