package Ejercicios_navidad;

public class E206FibonacciConArray {
    private static final int primerNumFibonacci = 0;
    private static final int segundoNumFibonacci = 1;
    public static void main(String[] args) {
        int[] numsFibonacci = new int [30];
        int inicioGuardado = 2;

        numsFibonacci[0] = primerNumFibonacci;
        numsFibonacci[1] = segundoNumFibonacci;

        for (int i = 0; i < numsFibonacci.length && inicioGuardado < 30; i++) {
            numsFibonacci[inicioGuardado] = numsFibonacci[i] + numsFibonacci[i + 1];
            inicioGuardado++;
        }

        System.out.println("A continuación se le mostrará los 30 primeros números de la sucesión de Fibonacci");

        for (int i = 0; i < numsFibonacci.length; i++) {
            System.out.print(
                    (i < numsFibonacci.length - 1) ? (numsFibonacci[i] + " | ") : numsFibonacci[i]
            );
        }
    }
}
