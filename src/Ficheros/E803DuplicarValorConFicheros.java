package Ficheros;

import javax.annotation.processing.Filer;
import java.io.*;
import java.util.Scanner;

public class E803DuplicarValorConFicheros {
    public static void main(String[] args) throws IOException {

        try (Scanner entrada = new Scanner((new File("src/Ficheros/entrada.txt"))); PrintWriter salida = new PrintWriter("src/Ficheros/salida.txt")) {
            while (entrada.hasNext()) {
                try {
                    salida.println(entrada.nextInt() * 2);
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir");
                }
            }
        }
    }
}