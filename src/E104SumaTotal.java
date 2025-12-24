void main() {
    int nCasillas = Integer.parseInt(IO.readln("\nIntroduce cuantos números quieres sumar: ")), sumaTotal = 0;
    int[] numerosALeer = new int [nCasillas + 1];

    for (int i = 0; i < numerosALeer.length - 1; i++) {
        IO.print(String.format("\nActualmente te encuentras en la casilla %d.", i + 1));
        numerosALeer[i] = Integer.parseInt(IO.readln(" Introduce un número que tu quieras: "));
    }

    for (int numActual : numerosALeer) {
        sumaTotal = sumaTotal + numActual;
    }
    numerosALeer[numerosALeer.length - 1] = sumaTotal;

    IO.println(String.format("\nEl programa creó una casilla extra en la posición %d para guardar el resultado de la suma, que es: %d",numerosALeer.length, sumaTotal));
}