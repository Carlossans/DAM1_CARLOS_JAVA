void main() {
    int n, min, max, posicionMenor = 1, posicionMayor = 1;
    double sumaTotal = 0;

    do {
        n = Integer.parseInt(IO.readln("\nPor favor, introduzca la cantidad de números deseada: "));
        if (n < 2) IO.println("\nEl número debe ser como mínimo 2, intentalo de nuevo.");
    } while (n < 2);

    int[] numEnteros = new int [n];

    for (int i = 0; i < numEnteros.length; i++) {
        numEnteros[i] = Integer.parseInt(IO.readln("\nIntroduzca el número " + (i + 1) + ": "));
    }

    for (int numActual : numEnteros) {
        sumaTotal = sumaTotal + numActual;
    }

    IO.println(String.format("\u001B[34m" + "\nEl promedio es %.2f", (sumaTotal / numEnteros.length) ));

    min = numEnteros[0];
    max = numEnteros[0];

    for (int i = 0; i < numEnteros.length; i++) {
        if (numEnteros[i] < min) {
            min = numEnteros[i];
            posicionMenor = (i + 1);
        } else if (numEnteros[i] > max) {
            max = numEnteros[i];
            posicionMayor = (i + 1);
        }
    }

    IO.println(String.format("El mayor era %d (posición %d) y el menor era %d (posición %d).", max, posicionMayor, min, posicionMenor));

}