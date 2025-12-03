//Decirle al usuario cuantos caracteres tiene la palabra secreta y darle solamente una vez, la opción de una pista y comunicar cuantos intentos quedan hasta el limite

final String morado = "\u001B[35m";
final String rojo = "\u001B[31m";
final String reseteaColor = "\u001B[0m";

void turnoJugador2() {
    for (int i = 0; i < 30; i++) {
        IO.println();
    }

    IO.println(morado + "----TURNO DEL JUGADOR 2----" + reseteaColor);
}

char[] crearYRellenarArrayDePalabra(String palabra) {

    char[] array = new char [palabra.length()];

    for (int i = 0; i < array.length; i++) {
        array[i] = palabra.charAt(i);
    }

    return array;
}

boolean comprobarCoincidencia(char intento, char caracter) {
    return (intento == caracter);
}

void main() {

    IO.println(morado + "\n----TURNO JUAGDOR 1----" + reseteaColor);
    String palabra = IO.readln("\nIntroduce la palabra que quieras: ").replaceAll("\\s" , "").toLowerCase();

    char[] arrayPalabra = crearYRellenarArrayDePalabra(palabra);
    boolean[] intentosJugador2 = new boolean[palabra.length()];
    char intento;
    int contadorAciertos = 0, contadorIntentos = 1, intentosMax = palabra.length() * 3; // por poner un limite

    turnoJugador2();

    do {
        for (int i = 0; i < arrayPalabra.length; i++) {
            if (contadorIntentos <= intentosMax) {
                do {
                    intento = IO.readln(String.format("\nIntroduce tu intento para adivinar el caracter %d de la palabra: ", i + 1)).replaceAll("\\s", "").toLowerCase().charAt(0);

                    if (comprobarCoincidencia(intento, arrayPalabra[i])) {
                        IO.println("\n✅Felicidades, has averiguado el caracter de la posición: " + (i + 1));
                        contadorIntentos++;
                        contadorAciertos++;
                        intentosJugador2[i] = true;
                    } else {
                        IO.println("\n❌ No has acertado, intentalo de nuevo.");
                        contadorIntentos++;
                        intentosJugador2[i] = false;
                    }
                } while (!intentosJugador2[i] && contadorIntentos <= intentosMax);
            }
        }
    } while (contadorAciertos != intentosJugador2.length  && contadorIntentos <= intentosMax); // podemos usar tanto: "arrayDePalabra.length", "intentosJugador2.length" como palabra.length(), el resultado será el mismo.

    if (contadorIntentos <= intentosMax) {
        IO.print("\nExactoooo la palabra era ");
        for (char caracterActual : arrayPalabra) {
            IO.print(caracterActual);
        }
    } else {
        IO.println(rojo + "\n Has superado el limite de intentos posible: " + (palabra.length() * 3) + reseteaColor);
    }
}