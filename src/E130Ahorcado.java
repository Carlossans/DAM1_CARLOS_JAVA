final String morado = "\u001B[35m";
final String azul = "\u001B[34m";
final String rojo = "\u001B[31m";
final String verde = "\u001B[32m";
final String reset = "\u001B[0m";

char[] crearYRellenarArray(String palabraSecreta) {
    char[] lista = new char[palabraSecreta.length()];

    for (int i = 0; i < lista.length; i++) {
        lista[i] = palabraSecreta.charAt(i);
    }
    return lista;
}

boolean[] crearArrayBooleans(String palabraSecreta) {
    return new boolean[palabraSecreta.length()];
}

void turnoJugador2(String palabraSecreta) {

    IO.println(String.format("%s\nLa palabra secreta tiene %d letras.\n%s----TURNO JUGADOR 2----%s\n", "\n".repeat(30), palabraSecreta.length(), morado, reset));
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

int contarConsonantes(String palabraSecreta) {
    int numVocales = contarVocales(palabraSecreta);

    return (palabraSecreta.length() - numVocales);
}

void darPista(String respuesta, String palabraSecreta) {
    if (respuesta.equals("si")) {
        IO.println(String.format("\nLa palabra tiene %d vocales y %d consonantes", contarVocales(palabraSecreta), contarConsonantes(palabraSecreta)));
    } else {
        IO.println("\nTu verás...");
    }
}

void hacerDibujo(int numeroFallos) {
    switch (numeroFallos) {
        case 1 ->
            IO.println("| O");
        case 2 -> {
            IO.println("| O");
            IO.println("| |");
        }
        case 3 -> {
            IO.println("| O");
            IO.println("|-|");
        }
        case 4 -> {
            IO.println("| O");
            IO.println("|-|-");
        }
        case 5 -> {
            IO.println("| O");
            IO.println("|-|-");
            IO.println("|/");
        }
        default -> {
            IO.println("| O");
            IO.println("|-|-");
            IO.println("|/ \\");
        }
    }
}

void main() {
    int numFallos = 0, aciertosJugador2 = 0;
    char intento;

    String palabraSecreta = IO.readln(String.format("%s\n----TURNO JUGADOR 1----%s\nIntroduce la palabra secreta: ", morado, reset));

    char[] arrayDePalabra = crearYRellenarArray(palabraSecreta);
    boolean[] intentosJugador2 = crearArrayBooleans(palabraSecreta);

    turnoJugador2(palabraSecreta);

    String respuesta = IO.readln("\nAntes de empezar ¿Quieres una pista? (SI/NO), si dices que no, no se te volverá a mostrar la opción. \n").replaceAll("\\s" , "").toLowerCase();

    darPista(respuesta, palabraSecreta);

    do {
        intento = IO.readln("\nIntroduce tu intento: ").replaceAll("\\s" , "").toLowerCase().charAt(0);

        for (int i = 0; i < palabraSecreta.length() && aciertosJugador2 != intentosJugador2.length; i++) {
            if (intento == arrayDePalabra[i]) {
                IO.println(String.format("\nLa letra %c se encuentra en la posición %d", intento, i + 1));
                intentosJugador2[i] = true;
                aciertosJugador2++;
            }
        }

    } while ( aciertosJugador2 != intentosJugador2.length && numFallos < palabraSecreta.length());

    IO.println();
}