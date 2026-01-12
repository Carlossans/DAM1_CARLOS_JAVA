private static final int NUM_ESCANNOS = 37;
void main() {
    int[] votos = {1463183, 1004599, 557780, 506164, 21742, 7652, 6749, 3784, 3407, 2902, 1751};
    int[] divisores = new int[votos.length];
    int[] escannos = new int[votos.length];
    int totalGeneralDeVotos = 0, numPartidos = votos.length;

    for (int numActual : votos) {
        totalGeneralDeVotos = totalGeneralDeVotos + numActual;
    }

    int[] votosTotales = new int[votos.length];

    System.arraycopy(votos, 0, votosTotales, 0, votos.length);

    Arrays.fill(divisores, 1);

    for (int i = 1; i <= NUM_ESCANNOS ; i++) {
        int indicePartidoProxEscanno = 0;
        double cocienteMayor = (double) votosTotales[0] / divisores[0];

        for (int j = 0; j < numPartidos; j++) {
            double cocienteActual = (double) votosTotales[j] / divisores[j];
            if (cocienteActual > cocienteMayor) {
                cocienteMayor = cocienteActual;
                indicePartidoProxEscanno = j;
            }
        }

        escannos[indicePartidoProxEscanno]++;
        divisores[indicePartidoProxEscanno]++;

        IO.println(String.format("Escaño %d asignado al partido %d | votos: %d , divisor actual: %d , cociente: %.2f", i, indicePartidoProxEscanno + 1, votos[indicePartidoProxEscanno], divisores[indicePartidoProxEscanno] - 1, cocienteMayor));
    }

    IO.println("\n----RESULTADOS----");
    IO.println("Partido | Votos     | Escaños | Votos por escaño");
    IO.println("--------|-----------|---------|-----------------");

    for (int i = 0; i < numPartidos; i++) {
        if (escannos[i] > 0) {
            double votosPorEscanno = (double) votosTotales[i] / divisores[i];
            IO.println(String.format("  %2d    | %9d |   %2d    |   %f", i + 1, votosTotales[i], escannos[i], votosPorEscanno));
        } else {
            IO.println(String.format("  %2d    | %9d |   %2d    |       -", i + 1, votosTotales[i], escannos[i]));
        }
    }

    int totalEscannosRepartidos = 0;
    for (int i = 0; i < numPartidos; i++) {
        totalEscannosRepartidos = totalEscannosRepartidos + escannos[i];
    }

    IO.println(String.format("\nTotal de escaños repartidos: %d de %d", totalEscannosRepartidos, NUM_ESCANNOS));
}