void main() {
    int n, posicionMenor = 0, posicionMayor = 0;
    double sumaTotal = 0;


    n = Integer.parseInt(IO.readln("\nPor favor, introduzca la cantidad de números deseada: "));

    int[] numEnteros = new int [n];

    for (int i = 0; i < numEnteros.length; i++) {
        do {
            numEnteros[i] = Integer.parseInt(IO.readln("\nIntroduzca el número " + (i + 1) + ": "));
        } while (numEnteros[i] < 2);
    }

    for (int numActual : numEnteros) {
        sumaTotal = sumaTotal + numActual;
    }

    IO.println(String.format("\u001B[34m" + "\nEl promedio es %.2f", (sumaTotal / numEnteros.length) ));


    for (int i = 1; i < numEnteros.length; i++) {
        if (numEnteros[i] < numEnteros[posicionMenor]) {
            posicionMenor = i;
        } else if (numEnteros[i] > numEnteros[posicionMayor]) {
            posicionMayor = i;
        }
    }

    IO.println(String.format("El mayor era %d (posición %d) y el menor era %d (posición %d).", numEnteros[posicionMayor], posicionMayor + 1, numEnteros[posicionMenor], posicionMenor + 1));

}