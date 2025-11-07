void main() {
    int base = 2,n = 0;
    boolean valido = true;

    do {
        try {
            n = Integer.parseInt(IO.readln("\nIntroduce el número de potencias que quieres ver:\n").replaceAll("\\s" , ""));
            valido = true;
        }catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO.\n");
            valido = false;
        }
    }while (!valido);

    int resultado = 1;
    for (int potencia = 0; potencia <= n; potencia++) {
        IO.print(base + "^" + potencia + "=" + resultado + " ");
        resultado = resultado * base;
    }
}