void main() {
    int numero1 = 0, numero2 = 0;
    boolean valido;

    do {
        try {
            numero1 = Integer.parseInt(IO.readln("\nIntroduce el primer número: ").replace("\\s" , ""));
            numero2 = Integer.parseInt(IO.readln("\nIntroduce el segundo número: ").replace("\\s" , ""));
            valido = true;
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, INTRODUCE UN NÚMERO POSITIVO");
            valido = false;
        }
    } while (!valido);

    if (numero1 < numero2) {
        for (int i = numero1; i <= numero2; i++) {
            int multiplo = i % 3;

            if (multiplo == 0) {
                IO.println(String.format("\nEste es uno de los números comprendidos entre el número %d y el %d. El número %d es multiplo de 3",numero1, numero2, i));
            }
        }
    } else {
        for (int i = numero1; i >= numero2; i--) {
            int multiplo = i % 3;
            if (multiplo == 0) {
                IO.println(String.format("\nEste es uno de los números comprendidos entre el número %d y el %d. El número %d es multiplo de 3",numero1, numero2, i));
            }
        }
    }
}