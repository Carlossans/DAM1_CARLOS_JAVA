void main() {
    int numsBuscar = Integer.parseInt(IO.readln("\n¿Cuántos números quieres buscar? "));
    int[] buscados = new int [numsBuscar];
    int[] lista = {8, 23, 30, 47, 17, 5, 17, 21, 2};
    int contadorCoincidencias = 0;

    IO.println("\nIntroduce los números: ");
    for (int i = 0; i < buscados.length; i++) {
        buscados[i] = Integer.parseInt(IO.readln(""));
    }

    for (int buscado : buscados) {
        for (int i : lista) {
            if (i == buscado) {
                contadorCoincidencias++;
            }
        }
    }

    IO.println("\nHay " + contadorCoincidencias + " coincidencias");
}