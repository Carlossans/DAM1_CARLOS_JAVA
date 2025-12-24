private static final int[] array = {8, 10, 4, 10, 8, 5, 5, 10, 17, 2};

private static void mostrarArraySinDuplicados(int[] arraySinDuplicados) {
    for (int numActual : arraySinDuplicados) {
        IO.print(numActual + " ");
    }
}
void main() {
    int cantidadNuevoArray = getCantidadNuevoArray();

    int[] arraySinDuplicados = new int[cantidadNuevoArray];

    int indice = 0;
    for (int numReferencia = 0; numReferencia < array.length; numReferencia++) {
        boolean esDuplicado = false;
        for (int numAComparar = 0; numAComparar < numReferencia; numAComparar++) {
            if (array[numReferencia] == array[numAComparar]) {
                esDuplicado = true;
                break;
            }
        }

        if (!esDuplicado) {
            arraySinDuplicados[indice] = array[numReferencia];
            indice++;
        }
    }

    mostrarArraySinDuplicados(arraySinDuplicados);
}

private static int getCantidadNuevoArray() {
    int cantidadNuevoArray = 0;
    for (int numReferencia = 0; numReferencia < array.length; numReferencia++) {
        boolean esDuplicado = false;
        for (int numAComparar = 0; numAComparar < numReferencia; numAComparar++) {
            if (array[numReferencia] == array[numAComparar]) {
                esDuplicado = true;
                break;
            }
        }
        if (!esDuplicado) cantidadNuevoArray++;
    }
    return cantidadNuevoArray;
}