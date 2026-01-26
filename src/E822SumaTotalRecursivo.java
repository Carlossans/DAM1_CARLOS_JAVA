import java.util.Scanner;

public class E822SumaTotalRecursivo {
    public static int hacerSumaTotal(int numero) {
        if (numero <= 1) return numero;
        else return numero + hacerSumaTotal(numero - 1);
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n = teclado.nextInt();

        System.out.println("Resultado = " + hacerSumaTotal(n));
    }
}
