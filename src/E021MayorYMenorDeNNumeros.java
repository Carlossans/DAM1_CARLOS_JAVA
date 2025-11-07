void main () {
    int cantidadnums = 0, minimo = 0, maximo = 0;
    boolean valido = true, primero = true;

    do {
        try {
            cantidadnums = Integer.parseInt(IO.readln("\n¿Cuántos números desea introducir? \n").replaceAll("\\s" , ""));
            valido = true;
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, INTRODUZCA UN NÚMERO, INTENTELO DE NUEVO.");
            valido = false;
        }
    } while (!valido);

    IO.println("\nIntroduzca los números a continuación: \n");

    for (int i = 1; i <= cantidadnums; i++) {
        do {
            try {
                int num = Integer.parseInt(IO.readln().replaceAll("\\s" , ""));
                if (primero) {
                    minimo = num;
                    maximo = num;
                    primero = false;
                } else {
                    if (num < minimo) {
                        minimo = num;
                    }
                    if (num > maximo) {
                        maximo = num;
                    }
                }
                valido = true;
            } catch (NumberFormatException e) {
                IO.println("\nFORMATO NO VÁLIDO, INTRODUZCA UN NÚMERO, INTENTELO DE NUEVO.");
                valido = false;
            }
        } while (!valido);
    }
    IO.println("\nEl número más bajo es: " + minimo);
    IO.println("\nEl número más alto es: "+ maximo);
}
