void main () {
    int dividendo = 25, divisor = 5, cociente = 0, resto = dividendo;

    while (resto >= divisor) {
        resto = resto - divisor;
        cociente++;
    }
    IO.println("\nCociente:" + cociente);
    IO.println("\nResto:" + resto);
}

//innovación:

/*void main () {
    int dividendo, divisor, cociente = 0;
    while (true) {
        try {
            dividendo = Integer.parseInt(IO.readln("\nIntroduce el dividendo:\n").replaceAll("\\s", ""));
            while (true) {
                try  {
                    divisor = Integer.parseInt(IO.readln("\nIntroduce el divisor:\n").replaceAll("\\s" , ""));
                    if (divisor == 0) {
                        IO.println("\nNO SE PUEDE DIVIDIR ENTRE 0, INTRODUCE OTRO NÚMERO.\n");
                        continue;
                    }
                    break;
                }catch (NumberFormatException e) {
                    IO.println("\nFOMRATO NO VÁLIDO, DEBES DE INTRODUCRIR UN NÚMERO, INTENTALO DE NUEVO:\n");
                }
            }
            break;
        }catch (NumberFormatException e) {
            IO.println("\nFOMRATO NO VÁLIDO, DEBES DE INTRODUCRIR UN NÚMERO, INTENTALO DE NUEVO:\n");
        }
    }

    int resto = dividendo;
    while (resto >= divisor) {
        resto = resto - divisor;
        cociente++;
    }

    IO.println("\nCociente:" + cociente + "\n");
    IO.println("\nResto:" + resto + "\n");
}*/

// división con números negativos

/*void main () {
    int dividendo, divisor, cociente = 0;

    while (true) {
        try {
            dividendo = Integer.parseInt(IO.readln("\nIntroduce el dividendo:\n").replaceAll("\\s", ""));
            break;
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES INTRODUCIR UN NÚMERO, INTÉNTALO DE NUEVO:\n");
        }
    }

    while (true) {
        try {
            divisor = Integer.parseInt(IO.readln("\nIntroduce el divisor:\n").replaceAll("\\s", ""));
            if (divisor == 0) {
                IO.println("\nNO SE PUEDE DIVIDIR ENTRE 0, INTRODUCE OTRO NÚMERO.\n");
                continue;
            }
            break;
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES INTRODUCIR UN NÚMERO, INTÉNTALO DE NUEVO:\n");
        }
    }

    // Compruebo si el dividendo y el divisor tienen simbolos opuestos
    boolean negativo = dividendo < 0 != divisor < 0; // Si los signos son opuestos entonces el cociente será negativo.

    // Convierto ambos números a positivo para poder operar con ellos
    dividendo = Math.abs(dividendo);
    divisor = Math.abs(divisor);

    int resto = dividendo;
    while (resto >= divisor) {
        resto = resto - divisor;
        cociente++;
    }

    // Si el boolean es true entonces se cambiará el valor del cociente a negativo
    if (negativo) {
        cociente = -cociente;
    }

    IO.println("\nCociente: " + cociente + "\n");
    IO.println("\nResto: " + resto + "\n");
}*/


