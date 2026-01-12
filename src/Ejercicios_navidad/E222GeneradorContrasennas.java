package Ejercicios_navidad;

import java.util.Scanner;
import java.util.Random;

public class E222GeneradorContrasennas {
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String CHARS_Y_CHARS_ESPECIALES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789,;.:-_{}[]!ºª!|#€$%&/()¿?*`^";

    private static String generarContraSinCharsEspeciales(int longitud) {
        Random aleatorio = new Random();
        StringBuilder contrasenna = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            int indice = aleatorio.nextInt(CHARS.length());
            contrasenna.append(CHARS.charAt(indice));
        }
        return contrasenna.toString();
    }

    private static String generarContraConCharsEspeciales(int longitud) {
        Random aleatorio = new Random();
        StringBuilder contrasenna = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            int indice = aleatorio.nextInt(CHARS_Y_CHARS_ESPECIALES.length());
            contrasenna.append(CHARS_Y_CHARS_ESPECIALES.charAt(indice));
        }
        return contrasenna.toString();
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int longitud;
        do {
            System.out.println("\nIntroduce la longitud que deseas que tenga tu contraseña, debe de tener entre 4-30 caracteres: ");
            longitud = teclado.nextInt();
        } while (longitud < 4 || longitud > 30);

        System.out.println("\n¿Quiéres que la contraseña tenga también caracteres especiales? (SI/NO)");
        String opcion = teclado.next().toLowerCase().replaceAll("\\s" , "");

        if ((opcion.equals("si"))) {
            generarContraConCharsEspeciales(longitud);
        } else {
            generarContraSinCharsEspeciales(longitud);
        }

        String respuesta;
        do {

        System.out.println("\nLa contraseña ya está lista, deseas verla? (escirbe \"ok\" para ver tu nueva contraseña) ");
        respuesta = teclado.next().toLowerCase().replaceAll("\\s" , "");

        } while (!respuesta.equals("ok"));

        if ((opcion.equals("si"))) {
            System.out.println(generarContraConCharsEspeciales(longitud));
        } else {
            System.out.println(generarContraSinCharsEspeciales(longitud));
        }

    }
}
