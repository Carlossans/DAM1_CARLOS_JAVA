package E330BingoSoloBombo;

import java.util.Random;
import java.util.ArrayList;

public class Carton {
    private ArrayList<ArrayList<Integer>> filasNumeros;
    private ArrayList<ArrayList<Boolean>> filasMarcas;

    private Bombo bombo;
    private Random aleatorio = new Random();
    private int id;
    private static int contadorId = 1;
    private boolean cantoLinea = false;

    private static final String VERDE = "\u001B[32m";
    private static final String RESET = "\u001B[0m";
    private static final int NUM_FILAS = 3;

    public Carton (Bombo bombo) {
        this.bombo = bombo;
        id = contadorId++;
        filasMarcas = new ArrayList<>();
        filasNumeros = new ArrayList<>();

        for (int i = 0; i < NUM_FILAS; i++) {
            filasNumeros.add(new ArrayList<Integer>());
            filasMarcas.add(new ArrayList<Boolean>());
        }

        int totalNumeros = Math.max(NUM_FILAS, bombo.getTotalBolas() / 6);

        rellenarAleatoriamente(totalNumeros);
    }

    public void rellenarAleatoriamente(int totalNumeros) {
        int numerosPorFila = totalNumeros / NUM_FILAS;
        int totalBolas = bombo.getTotalBolas();

        for (int i = 0; i < NUM_FILAS; i++) {
            ArrayList<Integer> filaActual = filasNumeros.get(i);
            ArrayList<Boolean> filaMarcas = filasMarcas.get(i);

            while (filaActual.size() < numerosPorFila) {
                int numeroAleatorio = aleatorio.nextInt(totalBolas) + 1;

                if (!elCartonYaTieneNum(numeroAleatorio)) {
                    filaActual.add(numeroAleatorio);
                    filaMarcas.add(false);
                }
                
            }
        }
    }

    public boolean elCartonYaTieneNum(int num) {
        for (ArrayList<Integer> fila : filasNumeros) {
            if (fila.contains(num)) return true;
        }
        return false;
    }

    public void anotaBola(int bola) {
        for (int i = 0; i < NUM_FILAS; i++) {
            for (int j = 0; j < filasNumeros.get(i).size(); j++) {
                if (filasNumeros.get(i).get(j) == bola) {
                    filasMarcas.get(i).set(j, true);
                }
            }
        }
    }

    public boolean hayLinea() {
        if (cantoLinea) return false;

        for (ArrayList<Boolean> filaMarcas : filasMarcas) {
            boolean lineaCompleta = true;
            for (Boolean marcada : filaMarcas) {
                if (!marcada) {
                    lineaCompleta = false;
                    break;
                }
            }
            if (lineaCompleta) {
                cantoLinea = true;
                return true;
            }
        }
        return false;
    }

    public boolean hayBingo() {
        for (ArrayList<Boolean> filaMarcas : filasMarcas) {
            for (Boolean marcada : filaMarcas) {
                if(!marcada) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CARTÓN ").append(id).append(":\n");
        
        for (int f = 0; f < NUM_FILAS; f++) {
            sb.append("  "); // Margen
            for (int c = 0; c < filasNumeros.get(f).size(); c++) {
                int num = filasNumeros.get(f).get(c);
                boolean marcada = filasMarcas.get(f).get(c);
                
                if (marcada) {
                    sb.append("[").append(VERDE).append(String.format("%02d", num)).append(RESET).append("] ");
                } else {
                    sb.append(String.format("%02d", num)).append("   ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
