package nose;

public class E207FibonacciSinArray {
    public static void main(String[] args) {
        int numsTotal = Integer.parseInt(IO.readln("Introduce la cantidad de números que quieres que se muestren de la sucesión de Fibonacci: \n"));

        long anterior = 0;
        long actual = 1;

        for (int i = 1; i <= numsTotal; i++) {
            System.out.print(anterior + " ");

            long siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
        }
    }
}
