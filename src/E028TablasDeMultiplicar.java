void main() {
    int resultado = 0, tabla = 0;
    boolean valido;

    do {
        try {
            tabla = Integer.parseInt(IO.readln("\n¿Hasta que tabla de multiplicar quieres llegar? ").replaceAll("\\s" , ""));
            valido = true;
        } catch (NumberFormatException e) {
           IO.println("\nFORMATO NO VÁLIDO, DEBES INTRODUCIR UN NÚMERO.");
           valido = false;
        }
    } while (!valido);
    for (int i = 1; i <= tabla; i++) {
        for (int j = 1; j <=10; j++) {
            resultado = i * j;
            IO.println(String.format("\n%d x %d = %d", i, j, resultado));
        }
            IO.print("\n................\n");
    }
}