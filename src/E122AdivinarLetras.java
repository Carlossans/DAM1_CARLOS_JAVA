final String morado = "\u001B[35m";
final String rojo = "\u001B[31m";
final String azul = "\u001B[34m";
final String verde = "\u001B[32m";
final String reseteaColor = "\u001B[0m";

void turnoJugador2(String palabra) {
    IO.println("\n".repeat(30));

    IO.println("\nLa palabra secreta tiene: " + palabra.length() + " letras.");
    IO.println(morado + "\n----TURNO DEL JUGADOR 2----" + reseteaColor);
}

char[] crearYRellenarArrayDePalabra(String palabra) {

    char[] array = new char [palabra.length()];

    for (int i = 0; i < array.length; i++) {
        array[i] = palabra.charAt(i);
    }

    return array;
}

int contarVocales(String palabra) {
    int contadorVocales = 0;

    for (int i = 0; i < palabra.length(); i++) {
        if (palabra.charAt(i) == 'a' || palabra.charAt(i) == 'e' || palabra.charAt(i) == 'i' || palabra.charAt(i) == 'o' || palabra.charAt(i) == 'u')
            contadorVocales++;
    }
    return contadorVocales;
}

int contarConsonantes(String palabra) {

    int numVocales = contarVocales(palabra);
    return (palabra.length() - numVocales);
}

void darPista(String respuesta, String palabra) {

    if (respuesta.equals("si")) {
        IO.println(String.format(azul + "\nLa palabra tiene %d vocales y %d consonantes." + reseteaColor, contarVocales(palabra), contarConsonantes(palabra)));
    } else {
        IO.println("\nTu verás...");
    }
}


void main() {

    IO.println(morado + "\n----TURNO JUGADOR 1----" + reseteaColor);
    String palabra = IO.readln("\nIntroduce la palabra que quieras: ").replaceAll("\\s" , "").toLowerCase();

    char[] arrayPalabra = crearYRellenarArrayDePalabra(palabra);
    boolean[] intentosJugador2 = new boolean[palabra.length()];
    char intento;
    int contadorAciertos = 0, contadorIntentos = 1, intentosMax = palabra.length() * 3; // por poner un límite

    turnoJugador2(palabra);

    String respuesta = IO.readln("\nAntes de empezar ¿Quieres una pista? (SI/NO), si dices que no, no se te volverá a mostrar la opción. \n").replaceAll("\\s" , "").toLowerCase();

    darPista(respuesta, palabra);

    do {
        for (int i = 0; i < arrayPalabra.length && contadorIntentos <= intentosMax; i++) {
                do {
                    intento = IO.readln(String.format("\nIntroduce tu intento para adivinar la letra %d de la palabra, tienes %d intentos: ", i + 1, (intentosMax - contadorIntentos) + 1)).replaceAll("\\s", "").toLowerCase().charAt(0);

                    if (intento == arrayPalabra[i]) {
                        IO.println("\n✅Felicidades, has averiguado la letra %d: " + (i + 1));
                        contadorIntentos++;
                        contadorAciertos++;
                        intentosJugador2[i] = true;

                        if (contadorAciertos == palabra.length() / 2) {
                            String resolucion = IO.readln("\nYa llevas la mitad de aciertos. ¿Te atreves a introducir lo que tu crees que es la palabra secreta? (SI/NO)\n").toLowerCase().replaceAll("\\s" , "");

                            if (resolucion.equals("si")) {
                                String intentoPalabraSecreta = IO.readln("\nIntroduce tu intento de palabra secreta: ").replaceAll("\\s" , "").toLowerCase();

                                if (intentoPalabraSecreta.equals(palabra)) {
                                    IO.println( verde + "\nESO ESSS, HAS ACERTADO LA PALABRA SECRETAAAA" + reseteaColor);
                                    return;
                                } else IO.println(rojo + "\nVayaaa, no has acertado, pero te dejo continuar con tus intentos de adivinar cada letra de la palabra secreta." + reseteaColor);

                            } else IO.println("\nContinua con tus intentos de adivinar cada letra de la palabra secreta..");
                        }
                    } else {
                        IO.println("\n❌ No has acertado, intentalo de nuevo.");
                        contadorIntentos++;
                        intentosJugador2[i] = false;
                    }
                } while (!intentosJugador2[i] && contadorIntentos <= intentosMax);
        }
    } while (contadorAciertos != intentosJugador2.length  && contadorIntentos <= intentosMax); // podemos usar tanto: "arrayDePalabra.length", "intentosJugador2.length" como palabra.length(), el resultado será el mismo.

    if (contadorIntentos <= intentosMax) {
        IO.print(azul + "\nExactoooo la palabra era ");
        for (char caracterActual : arrayPalabra) {
            IO.print(caracterActual);
        }
    } else {
        IO.println(rojo + "\n Has superado el limite de intentos posible: " + (palabra.length() * 3) + reseteaColor);
    }
}