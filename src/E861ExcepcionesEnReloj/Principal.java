package E861ExcepcionesEnReloj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Reloj reloj = null;
        boolean configurado = false;

        do {
            try {
                System.out.println("¿Cómo quieres crear el reloj?");
                System.out.println("1. Total de minutos");
                System.out.println("2. Horas y minutos");
                System.out.print("Opción: ");
                int opcion = teclado.nextInt();

                if (opcion == 1) {
                    System.out.print("Minutos totales: ");
                    reloj = new Reloj(teclado.nextInt());
                } else if (opcion == 2) {
                    System.out.print("Horas: ");
                    int h = teclado.nextInt();
                    System.out.print("Minutos: ");
                    int m = teclado.nextInt();
                    reloj = new Reloj(h, m);
                } else {
                    continue;
                }
                configurado = true;
            } catch (DesbordamientoRelojException e) {
                System.out.println("Exceso: " + e.getExcesoMinutos() + " min.");
            } catch (HoraNoValidaException | MinutoNoValidoException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error de entrada.");
                teclado.nextLine();
            }
        } while (!configurado);

        System.out.println("Reloj: " + reloj);
    }
}