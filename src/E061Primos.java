void main() {

    numeroValido();
}

void numeroValido() {
    int numero = 0, opcion = 0;
    boolean valido;

    do {
        do {
            try {
                opcion = Integer.parseInt(IO.readln("\n\nOpción 1: Número donde tiene que parar de comprobar si es primo o no.\n\nOpción 2: cantidad de números primos que quieres mostrar en pantalla.\n\nOpción 0: Salir\n\nElige una opción: ").replaceAll("\\s", ""));
                valido = true;
            } catch (NumberFormatException comprobarNumero) {
                IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO.");
                valido = false;
            }
        } while (!valido);

        switch (opcion) {
            case 0:
                IO.println("\nSALIENDO...");
                break;

            case 1:
                do {
                    try {
                        numero = Integer.parseInt(IO.readln("\nIntroduce el número donde tiene que parar de comprobar si es primo o no: ").replaceAll("\\s", ""));
                        valido = true;
                    } catch (NumberFormatException comprobarNumero) {
                        IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO.");
                        valido = false;
                    }
                } while (!valido);
                for (int i = 1; i <= numero; i++) {
                    if (esPrimo(i)) {
                        IO.println(String.format("\nEl numero %d es primo", i));
                    } else {
                        IO.println(String.format("\nEl numero %d no es primo", i));
                    }
                }
                break;

            case 2:
                int contador = 1;
                int primoActual = 2;
                do {
                    try {
                        numero = Integer.parseInt(IO.readln("\nIntroduce la cantidad de números primos que quieres mostrar en pantalla: ").replaceAll("\\s", ""));
                        valido = true;
                    } catch (NumberFormatException comprobarNumero) {
                        IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO.");
                        valido = false;
                    }
                } while (!valido);

                do {
                    if (esPrimo(primoActual)) {
                        IO.println("\n" + primoActual);
                        contador++;
                        primoActual++;
                    } else {
                        primoActual++;
                    }
                } while (contador <= numero);
                break;

            default:
                IO.println("\nOPCIÓN NO VÁLIDA");
        }
    } while (opcion != 0);
}

boolean esDivisible(int dividendo, int divisor) {

    if (dividendo % divisor == 0) {
        return true;
    } else {
        return false;
    }
}

boolean esPrimo(int numero) {

    if (numero < 2) {
        return false;
    } else if (numero == 2) {
        return true;
    } else if (numero % 2 == 0) {
        return false;
    }

    for (int i = 3; i <= Math.sqrt(numero); i = i + 2) {
        if (esDivisible(numero, i)) {
            return false;
        }
    }
    return true;
}