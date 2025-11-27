void main() {
    double numeros = Double.parseDouble(IO.readln("¿Cuantos números quieres introducir? \n")), sumaTotal = 0;
    double[] numDecimales = new double [(int) numeros + 1];

    for (int i = 0; i < numDecimales.length -1; i++) {
        IO.print("\nAcutalmente te encuentras en la posición " + (i + 1));
        numDecimales[i] = Double.parseDouble(IO.readln(". Introduce el número con decimales que tu quieras: "));
    }

    for (double numero : numDecimales) {
        sumaTotal = sumaTotal + numero;
    }
    double media = sumaTotal / (numDecimales.length - 1);

    numDecimales[numDecimales.length - 1] = media;

    IO.println(String.format("\nEL programa creó una casilla extra en la posición %d para añadir el resultado de la media que es: %.2f", numDecimales.length, numDecimales[numDecimales.length - 1]));
}