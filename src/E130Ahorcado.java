final String morado = "\u001B[35m";
final String azul = "\u001B[34m";
final String rojo = "\u001B[31m";
final String verde = "\u001B[32m";
final String reset = "\u001B[0m";

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
        if (palabraSecreta.charAt(i) == 'a' || palabraSecreta.charAt(i) == 'á' || palabraSecreta.charAt(i) == 'e' || palabraSecreta.charAt(i) == 'é' || palabraSecreta.charAt(i) == 'o' || palabraSecreta.charAt(i) == 'ó' || palabraSecreta.charAt(i) == 'u' || palabraSecreta.charAt(i) == 'ú' || palabraSecreta.charAt(i) == 'ü') {
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

void dibujarahorcado(int numFallos) {
    switch (numFallos) {
        case 1, 2, 3 -> IO.println("\n| O");
        case 4, 5, 6 -> {
            IO.println("\n| O");
            IO.println("| |");
        }
        case 7, 8, 9 -> {
            IO.println("\n| O");
            IO.println("|-|");
        }
        case 10, 11, 12 -> {
            IO.println("\n| O");
            IO.println("|-|-");
        }
        case 13, 14, 15 -> {

        }
        default -> {
            IO.println("\n| O");
            IO.println("|-|-");
            IO.println("|/\\");
        }
    }
}
void main() {
    char intento;
    int numFallos = 16;
    String palabraSecreta = IO.readln(String.format("\n%s----TURNO JUGADOR 1----%s\nIntroduce la palabra secreta: ", morado, reset));

    char[] arrayDePalabraSecreta = crearYRellenarArrayDePalabraSecreta(palabraSecreta);
    char[] arrayDeRayas = crearArrayRayas(palabraSecreta);
    boolean[] aciertos = crearArrayBooleans(palabraSecreta);

    String respuesta = IO.readln(String.format("\nLa palabra tiene %d letras.\nAntes de empezar, ¿Quieres una pista antes de empezar? (SI/NO), si decides que no, no se te volverá a mostrar esta opción: ", palabraSecreta.length())).toLowerCase();

    IO.println("\n".repeat(30));
    darPista(respuesta, palabraSecreta);

    intento = IO.readln(String.format("%s----TURNO JUGADOR 2----%s\nIntroduce tu intento: ", morado, reset)).toLowerCase().charAt(0);

    dibujarahorcado(numFallos);
//    for (char caracterActual : arrayDePalabraSecreta) {
//        IO.print(caracterActual);
//    }
}