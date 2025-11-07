void main () {
    int amplitudMaxima = 0, numOlas = 0;
    boolean valido = true;

    do {
        try {
            amplitudMaxima = Integer.parseInt(IO.readln("\nIndica la amplitud máxima de las olas: "));
            valido = true;
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO.");
            valido = false;
        }
    } while (!valido);

    do {
        try {
            numOlas = Integer.parseInt(IO.readln("\nIndica el número de olas: "));
            valido = true;
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO.");
            valido = false;
        }
    } while (!valido);

    for (int ola = 1; ola <= numOlas; ola++) {
        for (int i = 1; i <= amplitudMaxima; i++) {
            for (int j = 1; j <= i; j++) {
                IO.print("*");
            }
            IO.println();
        }
        
        for (int i = amplitudMaxima - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                IO.print("*");
            }
            IO.println();
        }
    }
}