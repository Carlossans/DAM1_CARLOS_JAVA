void main() {
    int nCasillas = Integer.parseInt(IO.readln("\nIntroduce cuantos números quieres introducir: ")), sumaTotal = 0;
    int[] numerosALeer = new int [nCasillas];

    for (int i = 0; i < numerosALeer.length; i++) {
        IO.print(String.format("\nActualmente te encuentras en la casilla %d.", i + 1));
        numerosALeer[i] = Integer.parseInt(IO.readln(" Introduce un número que tu quieras: "));
    }

    for (int numActual : numerosALeer) {
        sumaTotal = sumaTotal + numActual;
    }
    IO.println(String.format("\nLa suma total de los números introducidos es: %d", sumaTotal));
}
