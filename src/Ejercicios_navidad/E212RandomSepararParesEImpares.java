import java.util.Random;
import java.util.ArrayList;

private static boolean esPar(int num) {
    return num % 2 == 0;
}

private static void mostrarArray(ArrayList<Integer> array) {
    for (int numActual : array) {
        IO.print(numActual + " ");
    }
}

void main() {
    Random aleatorio = new Random(System.currentTimeMillis());
    ArrayList<Integer> positivos = new ArrayList<>();
    ArrayList<Integer> negativos = new ArrayList<>();

    int tamannoArray = Integer.parseInt(IO.readln("\n¿Cuántos número aleatorios quieres que tenga el array? \n"));

    int[] array = new int[tamannoArray];

    for (int num = 0; num < array.length; num++) {
        array[num] = aleatorio.nextInt(100);
    }

    for (int numActual : array) {
        if (esPar(numActual)) positivos.add(numActual);
        else negativos.add(numActual);
    }

    IO.println("\nEstos son los números positivos del array de números aleatorios:\n");
    mostrarArray(positivos);

    IO.println("\n\nEstos son los números negativos del array de números aleatorios:\n");
    mostrarArray(negativos);
}