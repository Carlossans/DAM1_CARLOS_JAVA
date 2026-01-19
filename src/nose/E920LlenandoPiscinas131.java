package nose;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E920LlenandoPiscinas131 {

    public static void main(String[] args) throws Exception {

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder salida = new StringBuilder();

        while (true) {

            String linea = lector.readLine();
            if (linea == null) break;

            StringTokenizer st = new StringTokenizer(linea);

            int capacidadYo = Integer.parseInt(st.nextToken());
            int barrenoYo = Integer.parseInt(st.nextToken());
            int fugaYo = Integer.parseInt(st.nextToken());
            int capacidadVecino = Integer.parseInt(st.nextToken());
            int barrenoVecino = Integer.parseInt(st.nextToken());
            int fugaVecino = Integer.parseInt(st.nextToken());

            if (capacidadYo == 0 || capacidadVecino == 0) break;

            int viajesYo = viajesNecesarios(capacidadYo, barrenoYo, fugaYo);
            int viajesVecino = viajesNecesarios(capacidadVecino, barrenoVecino, fugaVecino);

            if (viajesYo < viajesVecino) {
                salida.append("YO ").append(viajesYo).append('\n');
            } else if (viajesVecino < viajesYo) {
                salida.append("VECINO ").append(viajesVecino).append('\n');
            } else {
                salida.append("EMPATE ").append(viajesYo).append('\n');
            }
        }

        System.out.print(salida);
    }

    private static int viajesNecesarios(int capacidad, int barreno, int fuga) {

        if (capacidad <= barreno) return 1;
        if (barreno <= fuga) return Integer.MAX_VALUE;

        int ganancia = barreno - fuga;
        return (capacidad - fuga + ganancia - 1) / ganancia;
    }
}
