import java.util.Scanner;

public class E827CadenaAlReves {
    public static void imprimirCadenaAlReves(String palabra) {

        if (palabra.isEmpty()) return;

        System.out.print(palabra.charAt(palabra.length() - 1));

        imprimirCadenaAlReves(palabra.substring(0, palabra.length() - 1));
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String palabra = teclado.nextLine();

        imprimirCadenaAlReves(palabra);

    }
}
