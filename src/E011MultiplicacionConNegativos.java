void main() {
    int numero1 = 0, numero2 = 0, resultado = 0;

    String Respuesta = IO.readln("\n¿Quieres multiplicar?\n").replaceAll("\\s" , "").toLowerCase();

    if (Respuesta.equals("si")) {
        while (true) {
            try {
                numero1 = Integer.parseInt(IO.readln("\nIntroduce el primer número: \n").replaceAll("\\s", ""));
                while (true) {
                    try {
                        numero2 = Integer.parseInt(IO.readln("\nIntroduce el segundo número: \n").replaceAll("\\s", ""));
                        break;
                    } catch (NumberFormatException e) {
                        IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO\n");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO\n");
            }
        }

        if (numero1 < 0 && numero2 < 0) {
            numero1 = -numero1;
            for (int i = -1; i >= numero2; i--) {
                resultado = resultado + numero1;
            }
            IO.println("\nEl resultado de la multiplicación es: " + resultado);
        } else if (numero1 >= 0 && numero2 < 0) {
            for (int i = -1; i >= numero2; i--) {
                resultado = resultado + numero1;
            }
            resultado = -resultado;
            IO.println("\nEl resultado de la multiplicación es: " + resultado);
        } else {
            for (int i = 1; i <= numero2; i++) {
                resultado = resultado + numero1;
            }
            IO.println("\nEl resultado de la multiplicación es: " + resultado);
        }
    }else
        IO.println("\nPues venga, pirate\n");
    return;
}
