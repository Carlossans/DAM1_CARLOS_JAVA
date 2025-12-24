import java.util.Scanner;
public class E001Del1Al10 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int i = 1;


        System.out.println("¿Te gusta la programación?");
        String Respuesta = teclado.nextLine().trim().toLowerCase().replaceAll(" ", "");
        teclado.close();

        if (Respuesta.equals("si")) {
            do {
                System.out.println(i);
                i++;
            }while (i <= 10);
        }else
            for (int a = 1; a <= 10; a++) {
                System.out.println("PUES VETE A ASIR");
            }
    }

}

