void main () {
    int numero = 0;
    boolean valido = true;

    do {
        try {
            numero = Integer.parseInt(IO.readln("\nIntroduce el número del cual quieras obtener su tabla de multiplicar: ").replaceAll("\\s" , ""));
            valido = true;
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO.");
            valido = false;
        }
    } while (!valido);

    for (int i = 1; i <= 10; i++) {
        int resultado = numero * i;
        IO.println("\n" + numero + " * " + i + " = " + resultado);
    }
}