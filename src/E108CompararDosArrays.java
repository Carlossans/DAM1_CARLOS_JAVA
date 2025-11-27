void main() {
    int[] lista1 = {10, 15, 60 ,805}; int [] lista2 = {15, 35, 40 ,45};
    double[] decimales1 = {1.5, 2.5, 3.5, 4.5}; double[] decimales2 = {0.5, 1.5, 3.5, 7.5};
    boolean[] realOrFake = {true, false , true, true,}; boolean[] verdaderoOFalso = {true, false, false, false};

    for (int i = 0; i < lista1.length; i++) {
        IO.println(String.format(
                (lista1[i] == lista2[i]) ? "\nLos valores de la casilla %d son iguales" : (lista1[i] > lista2[i]) ? "\nEl valor de la casilla %d de la lista1 es mayor" : "\nEl valor de la casilla %d de la lista2 es mayor"
        , i + 1));
    }

    IO.println("\n");
    for (int i = 0; i < decimales1.length; i++) {
        IO.println(String.format(
                (decimales1[i] == decimales2[i]) ? "\nLos valores de la casilla %d son iguales" : (decimales1[i] > decimales2[i]) ? "\nEl valor de la casilla %d de la lista1 es mayor" : "\nEl valor de la casilla %d de la lista2 es mayor"
                , i + 1));
    }

    IO.println("\n");
    for (int i = 0; i < realOrFake.length; i++) {
        IO.println(String.format(
                (realOrFake[i] == verdaderoOFalso[i]) ? "\nLos contenidos de la casilla " + (i + 1) + " son iguales" : "\nLos contenidos de la casilla " + (i + 1) + " son distintos"
        , i + 1));
    }

}