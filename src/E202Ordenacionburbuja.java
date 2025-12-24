void main() {
    int cantidadNums = Integer.parseInt(IO.readln("\n¿Cuántos números quieres introducir? ")), numARemplazar;
    int[] lista = new int[cantidadNums];

    for (int i = 0; i < lista.length; i++) {
        lista[i] = Integer.parseInt(IO.readln("\nIntroduce el número que quieras: "));
    }

    for (int i = 0; i < lista.length; i++) {
        for (int j = i + 1; j < lista.length; j++) {
            if (lista[j] < lista[i]) {
                numARemplazar = lista[i];
                lista[i] = lista[j];
                lista[j] = numARemplazar;
            }
        }
    }

    for (int numeroActual : lista) {
        IO.println(numeroActual);
    }
}