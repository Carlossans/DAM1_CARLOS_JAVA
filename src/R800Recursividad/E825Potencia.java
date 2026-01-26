package R800Recursividad;

import java.util.Scanner;

public class E825Potencia {
    public static int calcularPotencia(int num, int potencia) {
        if (potencia == 0) return 1;
        else return num * calcularPotencia(num, potencia - 1);
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int num = teclado.nextInt();
        int potencia = teclado.nextInt();

        System.out.println(calcularPotencia(num, potencia));
    }
}
