void main() {
    int numero = 0, cifras, suma = 0, temp = 0;
    boolean valido = true;

    do {
        try {
            numero = Integer.parseInt(IO.readln("\nIntroduce el número con la cantidad de digitos que tu quieras: ").replaceAll("\\s", ""));
            valido = true;
            if (numero < 0) {
                IO.println("\nTiene que ser un número positivo, intentalo de nuevo:");
            }
        }catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO:");
            valido = false;
        }
    } while (!valido || numero < 0);
    cifras = String.valueOf(numero).length();
    temp = numero;
    while (temp > 0) {
        suma = suma + temp % 10;
        temp /= 10;
    }

    String Resultado = String.format("\nEl numero %d tiene %d y la suma total es %d" ,numero,cifras,suma);

    IO.println(Resultado);
}
