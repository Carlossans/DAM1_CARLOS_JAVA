import java.util.Scanner;

public class E823FibonacciRecursivo {
    public static int calcularFibonacci(int numero) {
        if (numero <= 1) return numero;

        return calcularFibonacci(numero - 2) + calcularFibonacci(numero - 1);
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n = teclado.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print(calcularFibonacci(i) + " ");
        }

    }
}
