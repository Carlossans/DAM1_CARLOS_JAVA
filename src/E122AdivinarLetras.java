final String morado = "\u001B[35m";
final String resetearColor = "\u001B[0m";

void turnoJugador2() {
    for (int i = 0; i < 30; i++) {
        IO.println();
    }

    IO.println(morado + "----TURNO DEL JUGADOR 2----" + resetearColor);
}

void main() {
    IO.println(morado + "\n----TURNO JUAGDOR 1----" + resetearColor);
    int nCaracteres = Integer.parseInt(IO.readln("\n¿Cuantos caracteres quieres introducir?\n")), contadorAciertos = 0;
    char[] caracteres = new char[nCaracteres];
    char intento;
    boolean[] aciertosJugador2 = new boolean[nCaracteres];

    for (int i = 0; i < caracteres.length; i++) {
        caracteres[i] = IO.readln(String.format("\nActualmente te encuentras en la casilla %d. Introduce la letra que quieras: ", i + 1)).replaceAll("\\s" , "").charAt(0);
    }

    turnoJugador2();

    do {
        for (int i = 0; i < caracteres.length; i++) {
            do {
                intento = IO.readln(String.format("\nIntroduce tu intento para adivinar el caracter de la casilla %d del array de caracteres: ", i + 1)).replaceAll("\\s" , "").toLowerCase().charAt(0);

                if (intento == caracteres[i]) {
                    IO.println("\n✅Felicidades, has averiguado el caracter de la posición: " + (i + 1));
                    contadorAciertos++;
                    aciertosJugador2[i] = true;
                } else {
                    IO.println("\n❌ No has acertado, intentalo de nuevo.");
                    aciertosJugador2[i] = false;
                }
            } while (!aciertosJugador2[i]);
        }
    } while (contadorAciertos != nCaracteres );

    IO.println("\nAcertaste todos los caracteres");
}