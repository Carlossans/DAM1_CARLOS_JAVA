void main() {
    int contadorIntentos = 0;
    int numeroSecreto = Integer.parseInt(IO.readln("\nJugador 1 introduce tu número secreto:"));

    for (int i=1; i<30; i++) {
        IO.println();
    }

    IO.println("Número guardado,te toca adivinar jugador 2");
    int numeroIntentado;

    do {
        numeroIntentado = Integer.parseInt(IO.readln("\nJugador 2 intenta adivinar el número: "));

        int diferencia = Math.abs(numeroSecreto - numeroIntentado);
        int asteriscos = diferencia / 10;

        for (int i = 1; i <= asteriscos; i++) {
            IO.print(" *");
        }

        if (diferencia != 0) {
            if (diferencia >= 100) {
                IO.print(" 🥶 Helado");
            } else if (diferencia >= 50) {
                IO.print(" ❄️ Frío");
            } else if (diferencia >= 25) {
                IO.print(" 🌡️ Templado");
            } else if (diferencia >= 20) {
                IO.print(" 🥵 Caliente ");
            } else if (diferencia < 20) {
                IO.print(" 🔥 Te quemas");
            }
        }

            if (numeroIntentado < numeroSecreto) {
                IO.println(" \nEl número secreto es mayor");
                contadorIntentos++;

            } else if (numeroIntentado > numeroSecreto) {
                IO.println(" \nEl número secreto es menor");
                contadorIntentos++;
            }
        }while (numeroIntentado != numeroSecreto) ;

        contadorIntentos++;
        IO.println("\n¡Enhorabuena! Adivinaste el número en " + contadorIntentos + " intentos");
}