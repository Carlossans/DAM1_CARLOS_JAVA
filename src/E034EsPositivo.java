static boolean esPositivo(int n) {
    return n >= 0;
}

void main() {
    int numero = 0;
    boolean repetir = true, valido = true;

    do {
        String verificar = IO.readln("\n¿Quieres comprobar si es positivo/negativo? (si/no)\n").replaceAll("\\s" , "").toLowerCase();

        if (verificar.equals("si")) {
            do {
                try {
                    numero = Integer.parseInt(IO.readln("\nIntroduce un número: ").replaceAll("\\s", ""));
                    valido = true;
                } catch (NumberFormatException e) {
                    IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO.");
                    valido = false;
                }
            } while (!valido);

            if (esPositivo(numero)) {
                IO.println(String.format("\nEl número es %d positivo", numero));
            } else {
                IO.println(String.format("\nEl número es %d negativo", numero));
            }
        } else if (verificar.equals("no")){
            repetir = false;
        } else {
            IO.println("\nDEBES DE INTRODUCIR UNA OPCIÓN VÁLIDA, (si/no)");
        }
    } while (repetir);

    IO.println("\nCHAOOO");
}