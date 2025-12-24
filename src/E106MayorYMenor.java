void main() {
    int numeros = Integer.parseInt(IO.readln("\n¿Cuántos números quieres introducir? \n"));
    int[] listaNumeros = new int [numeros];

    for (int i = 0; i < listaNumeros.length; i++) {
        IO.print("\nActualmente te encuentras en la posición " + (i + 1));
        listaNumeros[i] = Integer.parseInt(IO.readln(". Introduce el número que quieras: "));
    }

    int menor = listaNumeros[0];
    int mayor = listaNumeros[0];

    for (int numActual : listaNumeros) {
        menor = (numActual < menor) ? numActual : menor;
        mayor = (numActual > mayor) ? numActual : mayor;
    }
    IO.println(String.format("\nEl número más pequeño es: %d\n\nEl número más grande es: %d", menor, mayor));
}