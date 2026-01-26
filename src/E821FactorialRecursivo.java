import java.util.Scanner;

public class E821FactorialRecursivo {
    public static int calcularFactorial(int numero) {
        if (numero == 0) {
            return 1;
        }else{
            return (numero * calcularFactorial(numero - 1));
        }
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n = teclado.nextInt();

        System.out.print(n + "! = ");
        for (int i = 1; i <= n; i++) {

            if (i < n) {
                System.out.print(i + "x");
            } else System.out.print(i);

        }
        System.out.print(" = " + calcularFactorial(n));
    }
}