void main() {
    int[] numeros = {17, 23, 5, 21};
    double[] longitudes = {11.36, 0.0, 1.184, -3.98, 1495739.2};
    boolean[] indicadores = {false, false, true, false, true};
    int posicion = 1;

    for (int valor : numeros) {
        IO.print(String.format("\nEl número de la posición %d es %d", posicion, valor));
        posicion++;
    }

    IO.println();
    posicion = 1;
    for (double decimales : longitudes) {
        IO.print(String.format("\nEl número decimal de la posición %d es %.3f", posicion, decimales));
        posicion++;
    }

    IO.println();
    posicion = 1;
    for (boolean verdaderoOFalso : indicadores) {
        IO.print(String.format("\nEl número decimal de la posición %d es %b", posicion, verdaderoOFalso));
        posicion++;

    }
}