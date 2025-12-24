void main() {
    int n = 0, resultado = 1;
    boolean valido;

    do {
        try {
            n = Integer.parseInt(IO.readln("\nIntroduce un número el cual quieras calcular si factorial: ").replaceAll("\\s", ""));
            valido = true;
        }catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO.\n");
            valido = false;
        }
    }while (!valido);

    IO.print("\n" + n + "!" + "     = " );

    for (int i = 1; i <= n; i++) {
        resultado = resultado * i;
        IO.print(i);
        if (i < n){
            IO.print(" · ");
        }
    }
    IO.println(" = " + resultado);
}