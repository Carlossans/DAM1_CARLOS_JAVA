final String morado = "\u001B[35m", azul = "\u001B[34m", rojo = "\u001B[31m", verde = "\u001B[32m", reset = "\u001B[0m", miniEspacio = "\u2009";

String quitarTildesYDieresis(String palabraSecreta) {

    String palabraSecretaSinTildes = palabraSecreta.replace('á', 'a').replace('é', 'e').replace('í', 'i').replace('ó', 'o').replace('ú', 'u').replace('ü', 'u');

    return palabraSecretaSinTildes;
}

char[] crearYRellenarArrayDePalabraSecreta(String palabraSecreta) {
    char[] array = new char[palabraSecreta.length()];

    for (int i = 0; i < array.length; i++) {
        array[i] = palabraSecreta.charAt(i);
    }

    return array;
}

char[] crearArrayRayas(String palabraSecreta) {
    char[] rayas = new char[palabraSecreta.length()];

    Arrays.fill(rayas, '_');

    return rayas;
}

boolean[] crearArrayBooleans(String palabraSecreta) {
    return new boolean[palabraSecreta.length()];
}

int contarVocales(String palabraSecreta) {
    int contadorVocales = 0;

    for (int i = 0; i < palabraSecreta.length(); i++) {
        if (palabraSecreta.charAt(i) == 'a' || palabraSecreta.charAt(i) == 'e' || palabraSecreta.charAt(i) == 'i' || palabraSecreta.charAt(i) == 'o' ||palabraSecreta.charAt(i) == 'u') {
            contadorVocales++;
        }
    }

    return contadorVocales;
}

int contarConsonantes(String palabraSecreta) {
    return palabraSecreta.length() - contarVocales(palabraSecreta);
}

void darPista(String respuesta, String palabraSecreta) {
    IO.println(String.format(
            (respuesta.equals("si")) ? "\n%sLa palabra tiene %d vocales y %d consonantes%s" : "Tú verás..."
            , azul, contarVocales(palabraSecreta), contarConsonantes(palabraSecreta), reset));
}

boolean comprobarExistencia(char intento, char[] arrayDePalabra, char[] arrayDeRayas, boolean[] aciertos) {
    int contadorAciertos = 0;
    for (int i = 0; i < arrayDePalabra.length; i++) {
        if (intento == arrayDePalabra[i]) {
            arrayDeRayas[i] = intento;
            aciertos[i] = true;
            contadorAciertos++;
        }
    }
    return (contadorAciertos >= 1);
}

int contarCoincidencia(boolean[] arrayAciertos) {
    int aciertos = 0;
    for (boolean actual : arrayAciertos) {
        if (actual) aciertos++;
    }

    return aciertos;
}

void dibujarAhorcado(int numFallos) {
    switch (numFallos) {
        case 1 -> IO.println("|");
        case 2 -> {
            IO.println("|");
            IO.println("|");
        }
        case 3 -> {
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 4 -> {
            IO.print(" ----\n");
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 5 -> {
            IO.print(" ----\n");
            IO.println("    (");
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 6 -> {
            IO.print(" ----\n");
            IO.println("    ()");
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 7 -> {
            IO.print(" ----\n");
            IO.println("    ()");
            IO.println("|   |");
            IO.println("|");
            IO.println("|");
        }
        case 8 -> {
            IO.print(" ----\n");
            IO.println("    ()");
            IO.println("|   |");
            IO.println("|   |");
            IO.println("|");
        }
        case 9 -> {
            IO.print(" ----\n");
            IO.println("    ()");
            IO.println("|  -|");
            IO.println("|   |");
            IO.println("|");
        }
        // case 3 -> {
        //     IO.println("\n| ()");
        //     IO.println(String.format("| %s|", miniEspacio));
        // }
        // case 4 -> {
        //     IO.println("\n| ()");
        //     IO.println(String.format("| %s|", miniEspacio));
        //     IO.println(String.format("| %s|", miniEspacio));
        // }
        // case 5 -> {
        //     IO.println("\n| ()");
        //     IO.println(String.format("|%s-|", miniEspacio));
        //     IO.println(String.format("| %s|", miniEspacio));
        // }
        // case 6 -> {
        //     IO.println("\n| ()");
        //     IO.println(String.format("|%s-|-", miniEspacio));
        //     IO.println(String.format("|%s |", miniEspacio));
        // }
        // case 7 -> {
        //     IO.println("\n| ()");
        //     IO.println(String.format("|%s-|-", miniEspacio));
        //     IO.println(String.format("|%s |", miniEspacio));
        //     IO.println("| /");
        // }
        // case 8 -> {
        //     IO.println("\n| ()");
        //     IO.println(String.format("|%s-|-", miniEspacio));
        //     IO.println(String.format("|%s |", miniEspacio));
        //     IO.println("| /\\");
        // }
        // case 9 -> {
        //     IO.println("\n| ()");
        //     IO.println(String.format("|%s-|-", miniEspacio));
        //     IO.println(String.format("|%s |", miniEspacio));
        //     IO.println("|_/\\");
        // }
        // case 10 -> {
        //     IO.println("\n| ()");
        //     IO.println(String.format("|%s-|-", miniEspacio));
        //     IO.println(String.format("|%s |", miniEspacio));
        //     IO.println("|_/\\_");
        // }
    }
}

void main() {
    char intento;
    int numFallos = 9;
    // int numFallos = 1, contadorAciertos = 0;

    dibujarAhorcado(numFallos);

    // String palabraSecreta = IO.readln(String.format("\n%s----TURNO JUGADOR 1----%s\nIntroduce la palabra secreta: ", morado, reset));

    // String palabraSecretaSinTildes = quitarTildesYDieresis(palabraSecreta);


    // char[] arrayDePalabraSecreta = crearYRellenarArrayDePalabraSecreta(palabraSecretaSinTildes);
    // char[] arrayDeRayas = crearArrayRayas(palabraSecretaSinTildes);
    // boolean[] aciertos = crearArrayBooleans(palabraSecretaSinTildes);

    // String respuesta = IO.readln(String.format("\n%sLa palabra tiene %d letras.%s\n\nAntes de empezar, ¿Quieres una pista antes de empezar? (SI/NO), si decides que no, no se te volverá a mostrar esta opción: ", azul, palabraSecretaSinTildes.length(), reset)).toLowerCase();

    // IO.println("\n".repeat(30));
    // darPista(respuesta, palabraSecretaSinTildes);

    // IO.print(String.format("\n%s----TURNO JUGADOR 2----%s\n", morado, reset));

    // for (char caracterActual : arrayDeRayas) {
    //     IO.print(caracterActual);
    //     IO.print(" ");
    // }

    // do {
    //     intento = IO.readln("\nIntroduce tu intento: ").toLowerCase().charAt(0);

    //     if (comprobarExistencia(intento, arrayDePalabraSecreta, arrayDeRayas, aciertos)) {
    //         IO.println();
    //         for (char actual : arrayDeRayas) {
    //             IO.print(actual);
    //             IO.print(" ");
    //         }
    //         IO.println();

    //         contadorAciertos = contarCoincidencia(aciertos);
    //     } else {
    //         IO.println(String.format("\nla letra %c no está en la palabra.", intento));
    //         numFallos++;
    //         dibujarAhorcado(numFallos);
    //     }
    // } while (contadorAciertos != palabraSecretaSinTildes.length() && numFallos <= 9);

    // IO.println(String.format(
    //         (contadorAciertos == palabraSecretaSinTildes.length()) ? verde + "\nGANASTE, LA PALABRA ERA: %S."  : rojo + "\nPERDISTEEEE,TE CONVERTISTE EN JUAN PABLO ;( lA PALABRA SECRETA ERA \"%S\"."
    // ,palabraSecreta));
}