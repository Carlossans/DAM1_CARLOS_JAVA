final String morado = "\u001B[35m", azul = "\u001B[34m", rojo = "\u001B[31m", verde = "\u001B[32m", reset = "\u001B[0m", miniEspacio = "\u2009", tachado = "\u0336";

final int intentosMax = 13;

String quitarTildesYDieresis(String palabraSecreta) {

    return palabraSecreta.replace('á', 'a').replace('é', 'e').replace('í', 'i').replace('ó', 'o').replace('ú', 'u').replace('ü', 'u');
}

char[] crearArrayYRellenarRayas(String palabraSecreta) {

    char[] rayas = new char[palabraSecreta.length()];
    Arrays.fill(rayas, '_');

    return rayas;
}

boolean comprobarSiLaLetraEstaRepetida(char intento, char[] arrayDeRayas) {

    for (char letra : arrayDeRayas) {
        if (intento == letra) {
            return true;
        }
    }
    return false;
}

int contarVocales(String palabraSecreta) {

    int contadorVocales = 0;

    for (int i = 0; i < palabraSecreta.length(); i++) {
        if (palabraSecreta.charAt(i) == 'a' || palabraSecreta.charAt(i) == 'e' || palabraSecreta.charAt(i) == 'i' || palabraSecreta.charAt(i) == 'o' || palabraSecreta.charAt(i) == 'u') {
            contadorVocales++;
        }
    }

    return contadorVocales;
}

void darPista(String respuesta, String palabraSecreta) {

    IO.println(String.format(
            (respuesta.equals("si")) ? "\n%sLa palabra tiene %d vocales y %d consonantes%s" : "Tú verás..."
            , azul, contarVocales(palabraSecreta), palabraSecreta.length() - contarVocales(palabraSecreta), reset));
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

int contarCoincidencias(boolean[] arrayAciertos) {

    int aciertos = 0;

    for (boolean actual : arrayAciertos) {
        if (actual) aciertos++;
    }

    return aciertos;
}

boolean comprobarSiLaLetraYaEraErronea(char intento, ArrayList<Character> arrayDeLetrasErroneas) {

    for (char letra : arrayDeLetrasErroneas) {
        if (intento == letra) {
            return true;
        }
    }
    return false;
}

void dibujarAhorcado(int numFallos) {

    switch (numFallos) {
        case 1 -> {
            IO.println("|");
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 2 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|");
            IO.println("|");
            IO.println("|");
        }
        case 3 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|    ()");
            IO.println("|");
            IO.println("|");
        }
        case 4 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|");
        }
        case 5 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }
        case 6 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("|  %s——|", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }
        case 7 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }
        case 8 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }
        case 9 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——o", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
        }

        case 10 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——o", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("    /");
        }
        case 11 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——o", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("    /  \\");
        }
        case 12 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——o", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("   _/  \\");
        }
        case 13 -> {
            IO.print(" ————¬\n");
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("|    ()");
            IO.println(String.format("| %so——|——o", miniEspacio));
            IO.println(String.format("|    %s|", miniEspacio));
            IO.println("   _/  \\_");
        }
    }
}

void main() {
    char intento;
    int numFallos = 1, contadorAciertos = 0, contadorMuestreoResolucion = 0;

    String palabraSecreta = IO.readln(String.format("\n%s----TURNO JUGADOR 1----%s\nIntroduce la palabra secreta: ", morado, reset)).toLowerCase().replaceAll("\\s", "");

    String palabraSecretaSinTildes = quitarTildesYDieresis(palabraSecreta);

    char[] arrayDePalabraSecreta = palabraSecretaSinTildes.toCharArray();
    ArrayList<Character> arrayDeLetrasErroneas = new ArrayList<>();
    char[] arrayDeRayas = crearArrayYRellenarRayas(palabraSecretaSinTildes);
    boolean[] aciertos = new boolean[palabraSecretaSinTildes.length()];

    IO.println("\n".repeat(30));

    String respuesta = IO.readln(String.format("\n%sLa palabra tiene %d letras.%s\n\n¿Quieres una pista antes de empezar? (SI/NO), si decides que no, no se te volverá a mostrar esta opción: ", azul, palabraSecretaSinTildes.length(), reset)).toLowerCase().replaceAll("\\s", "");

    darPista(respuesta, palabraSecretaSinTildes);

    IO.print(String.format("\n%s----TURNO JUGADOR 2----%s\n", morado, reset));

    for (char caracterActual : arrayDeRayas) {
        IO.print(caracterActual);
        IO.print(" ");
    }
    IO.println();

    do {
        intento = IO.readln("\nIntroduce tu intento: ").toLowerCase().replaceAll("\\s", "").charAt(0);

        if (comprobarSiLaLetraEstaRepetida(intento, arrayDeRayas)) {
            IO.println(String.format("%s\nYa habías acertado la letra \"%c\" anteriormente, intenta con otra letra.%s", morado, intento, reset));
        }

        if (comprobarExistencia(intento, arrayDePalabraSecreta, arrayDeRayas, aciertos)) {
            IO.println();

            for (char actual : arrayDeRayas) {
                IO.print(actual);
                IO.print(" ");
            }
            IO.println();

            contadorAciertos = contarCoincidencias(aciertos);

            if (contadorMuestreoResolucion != 1) {

                if (contadorAciertos >= (palabraSecretaSinTildes.length() / 2)) {
                    String opcion = IO.readln("\nLlevas más o menos la mitad de aciertos, ¿Te atreves a introducir lo que crees que es la palabra secreta? (SI/NO) \n").replaceAll("\\s", "").toLowerCase();
                    contadorMuestreoResolucion++;

                    if (opcion.equals("si")) {
                        String resolucion = IO.readln("\nIntroduce lo que crees que es la palabra secreta: ").replaceAll("\\s", "").toLowerCase();

                        if (resolucion.equals(palabraSecretaSinTildes)) {
                            IO.println(String.format("\n%sCORRECTOO, LA PALABRA ERA: \"%S\"%s", verde, palabraSecretaSinTildes, reset));
                            return;
                        } else {
                            IO.println(String.format("\n%sINCORRECTO.%s\n", rojo, reset));
                            dibujarAhorcado(numFallos);
                            numFallos++;
                        }
                    } else {
                        IO.println("\nContinua con tus intentos.");
                    }
                }
            }
        } else {

            if (comprobarSiLaLetraYaEraErronea(intento, arrayDeLetrasErroneas)) {
                IO.println(String.format("\n%sYa habías errado con esa letra, prueba con otra.%s", morado, reset));
            } else {
                IO.println(String.format("\n%sla letra %c no está en la palabra.%s", rojo, intento, reset));
                arrayDeLetrasErroneas.add(intento);

                IO.println("\nA continuación verás todas las letras que has introducido y que no se encuentran en la palabra secreta: ");

                for (char letraErronea : arrayDeLetrasErroneas) {
                    IO.print(String.format("%s%c%s%s ", rojo, letraErronea, tachado, reset));
                }
                IO.println("\n");

                dibujarAhorcado(numFallos);
                numFallos++;
            }
        }
    } while (contadorAciertos != palabraSecretaSinTildes.length() && numFallos <= intentosMax);

    IO.println(String.format(
            (contadorAciertos == palabraSecretaSinTildes.length()) ? verde + "\nGANASTE, LA PALABRA ERA: \"%S.\"" + reset : rojo + "\nPERDISTEEEE, AGOTASTE TODOS TUS INTENTOS, lA PALABRA SECRETA ERA \"%S\"." + reset
            , palabraSecreta));
}