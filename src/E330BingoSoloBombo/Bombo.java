package E330BingoSoloBombo;

import java.util.ArrayList;
import java.util.Random;


public class Bombo {
    private ArrayList<Integer> bombo;
    private ArrayList<Integer> bolasSacadas = new ArrayList<Integer>();

    public Bombo (int cantidadBolas) {
        bombo = new ArrayList<>(cantidadBolas);

        for (int i = 1; i <= cantidadBolas; i++) {
            bombo.add(i);
        }
    }

    public int dameBola() {
        Random bolaAleatoria = new Random();
        int indiceASacar = bolaAleatoria.nextInt(0, bombo.size());

        int bola = bombo.get(indiceASacar);

        bolasSacadas.add(bola);

        bombo.remove(indiceASacar);

        return bola;
    }

    public boolean bolaEstaDentro(int bolaBuscada) {
        return bombo.contains(bolaBuscada);
    }

    public String toString() {
        StringBuilder bolasDentro = new StringBuilder("Bolas que no han salido: [");
        
        for (Integer bola : bombo) {
            bolasDentro.append(bola).append(" ");
        }
        bolasDentro.append("] Bolas que ya han salido: [");
        for (Integer bola : bolasSacadas) {
            bolasDentro.append(bola).append(" ");
        }
        bolasDentro.append("]");
        
        return bolasDentro.toString();
    }
    
}