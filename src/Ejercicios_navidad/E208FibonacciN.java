package Ejercicios_navidad;

public class E208FibonacciN {
    private static final int N = 4;
    private static final int HASTA = 30;
    public static void main(String[] args) {
        int[] anteriores = new int[N];

        for (int i = 0; i < N - 1; i++) {
            anteriores[i] = 0;
        }
        anteriores[N - 1] = 1;

        int mostrados = 0;

        for (int actual : anteriores) {
            System.out.print(actual + " ");
        }

        while (mostrados < HASTA - N) {

            int suma = 0;

            for (int i = 0; i < N; i++) {
                suma = suma + anteriores[i];
            }

            System.out.print(suma + " ");
            mostrados++;

            for (int i = 0; i < N - 1; i++) {
                anteriores[i] = anteriores[i + 1];
            }

            anteriores[N - 1] = suma;
        }
    }
}
