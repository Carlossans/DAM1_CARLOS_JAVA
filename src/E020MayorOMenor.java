void main() {
    int actual = 0, anterior = 0;
    boolean verificanum = true, valido = true;

    IO.println("\nIntroduzca valores positivos y le diré si son menores o mayores, o iguales, que el anterior; o introduzca 0 para terminar.");
    do {
        try {
            do {
                actual = Integer.parseInt(IO.readln("\nIntroduce el primer número: "));
                verificanum = true;
                valido = true;
                if (actual < 0) {
                    IO.println("\nDebes de introducir valores positivos");
                    valido = false;
                } else if (actual == 0) {
                    IO.println("\nFIN");
                    return;
                }
            }while (!valido);
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO.");
            verificanum = false;
        }
    } while (!verificanum);

    anterior =  actual;

    do {
        try {
            do {
                actual = Integer.parseInt(IO.readln("\nIntroduce un valor: ").replaceAll("\\s", ""));
                valido = true;
                verificanum = true;
                if (actual < 0) {
                    IO.println("\nDebes de introducir valores positivos");
                    valido = false;
                } else if (actual == 0) {
                    IO.println("\nFIN");
                    return;
                }
            } while (!valido);

            if (actual == anterior) {
                IO.println("\nEl valor es igual al anterior");
            } else if (actual > anterior) {
                IO.println("\nEl valor es mayor que el anterior");
            } else {
                IO.println("\nEl valor es menor que el anterior");
            }

            anterior = actual;

        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO.");
            verificanum = false;
        }
    } while (valido || !verificanum);
}