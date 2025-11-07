void main () {
    int numero = 0, anterior = 0, actual = 0;
    boolean valido, comparacion = true;

    do {
        try {
            anterior = Integer.parseInt(IO.readln("\nIntroduce un número: ").replaceAll("\\s" , ""));
            valido = true;
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO.");
            valido = false;
        }
    } while (!valido);

    do {
        try {
            anterior = actual;
            actual = Integer.parseInt(IO.readln("\nIntroduce otro número: ").replaceAll("\\s" , ""));
        
            if (actual == anterior) {
                comparacion = true;
            } else {
                comparacion = false;
            }
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO.");
            valido = false;
        }
    } while (!valido || actual != anterior || !comparacion);

    IO.println("\nEs igual");

}