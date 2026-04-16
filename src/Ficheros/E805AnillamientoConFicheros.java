package Ficheros;

import java.io.*;
import java.util.Scanner;

public class E805AnillamientoConFicheros {
    public static void main(String[] args) throws FileNotFoundException {

        try (Scanner entrada = new Scanner((new File("src/Ficheros/entrada.txt"))); PrintWriter salida = new PrintWriter("src/Ficheros/salida.txt")) {
            while (entrada.hasNextInt()) {
                int campannas = entrada.nextInt();
                if (campannas == 0) break;

                int anillasUsadas = 0;
                for (int campanna = 0; campanna < campannas; campanna++) {
                    anillasUsadas = anillasUsadas + (entrada.nextInt() - entrada.nextInt());
                }
                salida.println(anillasUsadas);
                System.out.printf("Procesada campaña %d -> Anillas usadas: %d\n", campannas, anillasUsadas);
            }
        }
    }
}