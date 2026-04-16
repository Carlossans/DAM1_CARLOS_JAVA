package Ficheros;

import java.io.*;
import java.util.Scanner;

public class E801EscrituraLecturaFicheroTexto {
    public static void main(String[] args) throws IOException{
        System.out.println("\nESCRITURA EN DATOS.TXT: ");
        try (PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter("src/Ficheros/datos.txt")))) {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Escribiendo número: " + i);
                salida.println(i);
            }
        }
        System.out.println("\nLECTURA DE DATOS.TXT: ");
        try (Scanner entrada = new Scanner(new BufferedReader(new FileReader("src/Ficheros/datos.txt")))) {
            while (entrada.hasNext()) {
                String cadena = entrada.next();
                System.out.println("Leído número: " + cadena);
            }
        }
    }
}