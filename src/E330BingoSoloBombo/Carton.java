package E330BingoSoloBombo;

import java.util.Random;
import java.util.ArrayList;

public class Carton {
    private ArrayList<ArrayList<Integer>> filasNumeros;
    private ArrayList<ArrayList<Boolean>> filasMarcas;

    private Bombo bombo;
    private Random aleatorio;
    private int id;
    private static int contadorId = 1;
    private boolean cantoLinea = false;

    private static final String VERDE = "\u001B[32m";
    private static final String RESET = "\u001B[0m";
    private static final int NUM_FILAS = 3;

    public Carton (Bombo bombo) {
        this.bombo = bombo;
        aleatorio = new Random();
        id = contadorId++;
        filasMarcas = new ArrayList<>();
        filasNumeros = new ArrayList<>();

        for (int i = 0; i < NUM_FILAS; i++) {
            filasNumeros.add(new ArrayList<>());
            filasMarcas.add(new ArrayList<>());
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
        for (int fila = 0; fila < NUM_FILAS; fila++) {
            for (int columna = 0; columna < filasNumeros.get(fila).size(); columna++) {
                if (filasNumeros.get(fila).get(columna).equals(bola)) {
                    filasMarcas.get(fila).set(columna, true);
                    return;
                }
            }
        }
    }

    public boolean hayLinea() {
        if (cantoLinea) return false;

        for (ArrayList<Boolean> fila : filasMarcas) {
            if (!fila.contains(false)) {
                cantoLinea = true;
                return true;
            }
        }
        return false;
    }

    public boolean hayBingo() {
        for (ArrayList<Boolean> fila : filasMarcas) {
            if (fila.contains(false)) {
                return false;
            }
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        StringBuilder mostrarCarton = new StringBuilder();
        mostrarCarton.append("CARTÓN ").append(id).append(":\n");
        
        for (int fila = 0; fila < NUM_FILAS; fila++) {
            mostrarCarton.append("  ");
            for (int columna = 0; columna < filasNumeros.get(fila).size(); columna++) {
                int num = filasNumeros.get(fila).get(columna);
                boolean marcada = filasMarcas.get(fila).get(columna);
                
                if (marcada) {
                    mostrarCarton.append("[").append(VERDE).append(String.format("%02d", num)).append(RESET).append("] ");
                } else {
                    mostrarCarton.append(String.format("%02d", num)).append("   ");
                }
            }
            mostrarCarton.append("\n");
        }
        return mostrarCarton.toString();
    }
}
