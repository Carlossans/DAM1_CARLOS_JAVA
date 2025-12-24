void main() {
    int n = 0;
    boolean valido = true;

    do {
        try {
            n = Integer.parseInt(IO.readln("\nIntroduce el número de veces que se repita la frase:  ").replaceAll("\\s", " "));
            valido = true;
        }catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO.\n");
            valido = false;
        }
    }while (!valido);

    for (int i = 1; i <= n; i++) {
        if (i == 1) {
            IO.println("\nHabía una vez " + i + " elefante que se balanceaba en una hamaca a la orilla de un río");
        }else{
            IO.println("\nHabía una vez " + i + " elefantes que se balanceaban en una hamaca a la orilla de un río");
        }
    }
}