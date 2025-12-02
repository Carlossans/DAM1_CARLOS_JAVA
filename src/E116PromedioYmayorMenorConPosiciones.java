void main() {
    boolean valido;
    int n, min, max;
    double sumaTotal = 0;
    String respuestaMayor = "", respuestaMenor = "";

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

    IO.println("\u001B[34m" + "\nEl promedio es " + (sumaTotal / numEnteros.length) + ".");

    for (int i = 0; i < numEnteros.length; i++) {
        min = numEnteros[i];
        max = numEnteros[i];

        if (numEnteros[i] < min) {
            min = numEnteros[i];
            respuestaMayor = String.format("El mayor era %d (posición %d) ", numEnteros[i], i + 1);
        } else if (numEnteros[i] > max){
            max = numEnteros[i];
            respuestaMenor = String.format("y el menor era %d (posición %d)", numEnteros[i], i + 1);
        }
    }

    IO.println(respuestaMayor + respuestaMenor);

}