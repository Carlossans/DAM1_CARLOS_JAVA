package E236TresEnRayaComprobarUltimaPos;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        do {
            Tablero.dibujar();

            System.out.format("J%d: Introduzca coordenadas:\n", Tablero.getJugadorActual());
            System.out.print("Fila: ");
            int fil = teclado.nextInt();
            System.out.print("Columna: ");
            int col = teclado.nextInt();

            Tablero.marcar(fil, col);

            Tablero.alternarJugador();
        } while (Tablero.buscarGanador() == - 1);

        Tablero.dibujar();

        System.out.println(switch (Tablero.buscarGanador()) {
            case 0 -> "Ha quedado en tablas.";
            case 1 -> "Ha ganado el J1.";
            case 2 -> "Ha ganado el J2.";
            default -> "Ouch. Error. Nunca deberíamos llegar aquí :'(";
        });

        teclado.close();
    }
}