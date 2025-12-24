void main() {
    int numero = 0, sumaTotal = 0;
    boolean valido;

    do {
        try {
            numero = Integer.parseInt(IO.readln("\nIntroduce un número positivo: ").replaceAll("\\s" , ""));

            if (numero > 0) {
                valido = true;
            }else {
                IO.println("\nFORMATO NO VÁLIDO, INTRODUCE UN NÚMERO POSITIVO");
                valido = false;
            }
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, INTRODUCE UN NÚMERO POSITIVO");
            valido = false;
        }
    } while (!valido || numero < 0);

    for (int i = 1; i <= numero; i++) {
        sumaTotal = sumaTotal + i;
    }

    IO.println(String.format("\nEl resultado de la suma de los numeros hasta %d es: %d",numero, sumaTotal ));
}