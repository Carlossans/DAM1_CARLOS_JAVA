final String morado = "\u001B[35m", azul = "\u001B[34m", rojo = "\u001B[31m", verde = "\u001B[32m", reset = "\u001B[0m", miniEspacio = "\u2009";

//comprobar si la letra era erronea y mostrar mensaje, crear uno nuevo para meter los errores y comrpobarlos
//he creado el array de 27 - longitud palabra secreta para que quepan todas las letras del abecedario menos las de la palabra secreta
//despues de cada intento erroneo, meter la letra en el array y mostrar las letras que hay en el array
//Si la letra ya esta en el array, no meterla y mostrar mensaje

String quitarTildesYDieresis(String palabraSecreta) {

    return palabraSecreta.replace('á', 'a').replace('é', 'e').replace('í', 'i').replace('ó', 'o').replace('ú', 'u').replace('ü', 'u');
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

boolean comprobarSiLaLetraYaEraCorrecta(char intento, char[] arrayDeRayas) {

    for (int i = 0; i < arrayDeRayas.length; i++) {
        if (intento == arrayDeRayas[i]) {
            return true;
        }
    }
    return false;
}

int contarSiLaLetraYaEraCorrecta(char intento, char[] arrayDeRayas) {
    int contador = 0;
    
    if (comprobarSiLaLetraYaEraCorrecta(intento, arrayDeRayas)) {
        contador++;
    }

    return contador;
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
            IO.println("|");
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 5 -> {
            IO.print(" —\n");
            IO.println("|");
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 6 -> {
            IO.print(" ——\n");
            IO.println("|");
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 7 -> {
            IO.print(" ———\n");
            IO.println("|");
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 8 -> {
            IO.print(" ————\n");
            IO.println("|");
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 9 -> {
            IO.print(" ————¬\n");
            IO.println("|");
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 10 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 11 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    (");
            IO.println("|");
            IO.println("|");
        }
        case 12 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println("|");
            IO.println("|");
        }
        case 13 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|");
        }
        case 14 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }
        case 15 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("|   %s—|", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }
        case 16 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("|  %s——|", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }
        case 17 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }

        case 18 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|—", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }
        case 19 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }
        case 20 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——o", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }

        case 21 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——o", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("    /");
        }
        case 22 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——o", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("    /  \\");
        }
        case 23 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——o", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("   _/  \\");
        }
        case 24 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|",miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——o", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("   _/  \\_");
        }
    }
}

void main() {
    char intento;
    int numFallos = 1, contadorAciertos = 0, contadorLetrasCorrectasYaIntroducidas;

    String palabraSecreta = IO.readln(String.format("\n%s----TURNO JUGADOR 1----%s\nIntroduce la palabra secreta: ", morado, reset));

    String palabraSecretaSinTildes = quitarTildesYDieresis(palabraSecreta);

    char[] arrayDePalabraSecreta = crearYRellenarArrayDePalabraSecreta(palabraSecretaSinTildes);
    char[] arrayDeLetrasErroneas = new char[ 27 - palabraSecretaSinTildes.length()];
    char[] arrayDeRayas = crearArrayRayas(palabraSecretaSinTildes);
    boolean[] aciertos = crearArrayBooleans(palabraSecretaSinTildes);

    IO.println("\n".repeat(30));

    String respuesta = IO.readln(String.format("\n%sLa palabra tiene %d letras.%s\n\nAntes de empezar, ¿Quieres una pista antes de empezar? (SI/NO), si decides que no, no se te volverá a mostrar esta opción: ", azul, palabraSecretaSinTildes.length(), reset)).toLowerCase();

    darPista(respuesta, palabraSecretaSinTildes);

    IO.print(String.format("\n%s----TURNO JUGADOR 2----%s\n", morado, reset));

    for (char caracterActual : arrayDeRayas) {
        IO.print(caracterActual);
        IO.print(" ");
    }
    IO.println();

    do {
        intento = IO.readln("\nIntroduce tu intento: ").toLowerCase().charAt(0);

        if (comprobarSiLaLetraYaEraCorrecta(intento, arrayDeRayas)) {
            contadorLetrasCorrectasYaIntroducidas = contarSiLaLetraYaEraCorrecta(intento, arrayDeRayas);

            if (contadorLetrasCorrectasYaIntroducidas >= 1) IO.println(String.format("%s\nYa habías acertado la letra \"%c\" anteriormente, intenta con otra letra.%s", morado, intento, reset));
        }


        if (comprobarExistencia(intento, arrayDePalabraSecreta, arrayDeRayas, aciertos)) {
            IO.println();
            for (char actual : arrayDeRayas) {
                IO.print(actual);
                IO.print(" ");
            }
            IO.println();

            contadorAciertos = contarCoincidencia(aciertos);

            if (contadorAciertos == (palabraSecreta.length() / 2)) {
                String opcion  = IO.readln("\nLlevas más o menos la mitad de aciertos, ¿Te atreves a introducir lo que crees que es la palabra secreta? (SI/NO) \n");

                if (opcion.equals("si")) {
                    String resolucion = IO.readln("\nIntroduce lo que crees que es la palabra secreta: ");

                    if (resolucion.equals(palabraSecretaSinTildes)) {
                        IO.println(String.format("\n%sCORRECTOO, LA PALABRA ERA: \"%S\"%s", verde, palabraSecretaSinTildes,reset));
                        return;
                    } else {
                        IO.println(String.format("\n%sINCORRECTO. CONTINUA CON TUS INTENTOS.%s\n", rojo,reset));
                        dibujarAhorcado(numFallos);
                        numFallos++;
                    
                    }

                } else {
                    IO.println("\nContinua con tus intentos.");
                }
            }
        } else {
            IO.println(String.format("\n%sla letra %c no está en la palabra.%s\n", rojo, intento, reset));
            dibujarAhorcado(numFallos);
            numFallos++;
        }
    } while (contadorAciertos != palabraSecretaSinTildes.length() && numFallos <= 24);

    IO.println(String.format(
            (contadorAciertos == palabraSecretaSinTildes.length()) ? verde + "\nGANASTE, LA PALABRA ERA: %S."  : rojo + "\nPERDISTEEEE,TE CONVERTISTE EN JUAN PABLO ;( lA PALABRA SECRETA ERA \"%S\"."
    ,palabraSecreta));
}