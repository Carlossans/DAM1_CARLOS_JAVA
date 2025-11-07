void main() {
    int numero = 0, contador = 0, suma = 0;
    boolean valido;
    do {
        try {
            numero = Integer.parseInt(IO.readln("\nIntroduce un número: ").replaceAll("\\s" , ""));

            if (numero != 0) {
                contador++;
            }

            if (numero > 100) {
                suma = suma + numero;
            }
            valido = true;
        } catch (NumberFormatException e) {
           IO.println("\nEL FROMATO NO ES VÁLIDO, INTRODUCE UN NÚMERO.");
           valido = false;
        }
    } while (!valido || numero != 0);

    IO.println(String.format("\nLa suma de los números mayores que 100 es: %d \n\nhas introducido %d números",suma, contador));

}