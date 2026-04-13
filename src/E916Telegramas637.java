//import java.util.Scanner;
//
//public class E916Telegramas637 {
//    public static void main(String[] args) {
//        int[] valoresMorse = new int[128];
//        valoresMorse['A']=5;valoresMorse['B']=9;valoresMorse['C']=11;valoresMorse['D']=7;valoresMorse['E']=1;valoresMorse['F']=9;valoresMorse['G']=9;valoresMorse['H']=7;
//        valoresMorse['I']=3;valoresMorse['J']=13;valoresMorse['K']=9;valoresMorse['L']=9;valoresMorse['M']=7;valoresMorse['N']=5;valoresMorse['O']=11;valoresMorse['P']=11;
//        valoresMorse['Q']=13;valoresMorse['R']=7;valoresMorse['S']=5;valoresMorse['T']=3;valoresMorse['U']=7;valoresMorse['V']=9;valoresMorse['W']=9;valoresMorse['X']=11;
//        valoresMorse['Y']=13;valoresMorse['Z']=11;valoresMorse['?']=15;valoresMorse['!']=19;
//
//        Scanner teclado = new Scanner(System.in);
//        int casos = teclado.nextInt();
//        teclado.nextLine();
//
//        while (casos-- > 0) {
//            String[] palabras = teclado.nextLine().split(" ");
//            int total = 0;
//
//            for (int i = 0; i < palabras.length; i++) {
//                if (i > 0) total = total + 5;
//                for (int j = 0; j < palabras[i].length(); j++) {
//                    if (j > 0) total = total + 3;
//                    total = total + valoresMorse[palabras[i].charAt(j)];
//                }
//            }
//            System.out.println(total);
//        }
//    }
//}


import java.util.Scanner;

public class E916Telegramas637 {
    private static int getValor(String str) {
        int puntos = 0, rayas = 0;
        for (char c : str.toCharArray()) {
            if (c == '-') rayas++;
            else puntos++;
        }
        return (rayas * 3) + puntos + str.length() - 1;
    }

    public static void main(String[] args) {
        int[] valorMorse = new int[128];

        valorMorse['A'] = getValor(".-");
        valorMorse['B'] = getValor("-...");
        valorMorse['C'] = getValor("-.-.");
        valorMorse['D'] = getValor("-..");
        valorMorse['E'] = getValor(".");
        valorMorse['F'] = getValor("..-.");
        valorMorse['G'] = getValor("--.");
        valorMorse['H'] = getValor("....");
        valorMorse['I'] = getValor("..");
        valorMorse['J'] = getValor(".---");
        valorMorse['K'] = getValor("-.-");
        valorMorse['L'] = getValor(".-..");
        valorMorse['M'] = getValor("--");
        valorMorse['N'] = getValor("-.");
        valorMorse['O'] = getValor("---");
        valorMorse['P'] = getValor(".--.");
        valorMorse['Q'] = getValor("--.-");
        valorMorse['R'] = getValor(".-.");
        valorMorse['S'] = getValor("...");
        valorMorse['T'] = getValor("-");
        valorMorse['U'] = getValor("..-");
        valorMorse['V'] = getValor("...-");
        valorMorse['W'] = getValor(".--");
        valorMorse['X'] = getValor("-..-");
        valorMorse['Y'] = getValor("-.--");
        valorMorse['Z'] = getValor("--..");
        valorMorse['?'] = getValor("..--..");
        valorMorse['!'] = getValor("-.-.--");

        Scanner teclado = new Scanner(System.in);
        int casos = teclado.nextInt();
        teclado.nextLine();

        while (casos-- > 0) {
            String[] palabras = teclado.nextLine().split(" ");
            int total = 0;

            for (int i = 0; i < palabras.length; i++) {
                if (i > 0) total = total + 5;
                for (int j = 0; j < palabras[i].length(); j++) {
                    if (j > 0) total = total + 3;
                    total = total + valorMorse[palabras[i].charAt(j)];
                }
            }
            System.out.println(total);
        }
    }
}