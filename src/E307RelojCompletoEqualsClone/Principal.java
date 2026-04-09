package E307RelojCompletoEqualsClone;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Reloj a = new Reloj(23, 57);
        boolean operacionOK = false;

        System.out.println("Valor inicial: " + a + "\n");

        do {
            try {
                System.out.print("Indica los minutos que quieres sumar: ");
                int minutos = teclado.nextInt();
                a.sumar(minutos);
                operacionOK = true;
            } catch (DesbordamientoRelojException e) {
                if (e.isSuperior()) System.out.println("Te has intentado salir del día por arriba. Inténtalo de nuevo.");
                else System.out.println("Te has intentado salir del día por abajo. Inténtalo de nuevo.");
            } catch (OperacionNegativaRelojException e) {
                throw new RuntimeException(e);
            }
        } while (!operacionOK);

        System.out.println("\nValor final: " + a);
    }
}