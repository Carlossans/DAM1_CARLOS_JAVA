import java.util.Scanner;

public class E916Telegramas637 {
    public static void main(String[] args) {
        int[] c = new int[128];
        c['A']=5;c['B']=9;c['C']=11;c['D']=7;c['E']=1;c['F']=9;c['G']=9;c['H']=7;
        c['I']=3;c['J']=13;c['K']=9;c['L']=9;c['M']=7;c['N']=5;c['O']=11;c['P']=11;
        c['Q']=13;c['R']=7;c['S']=5;c['T']=3;c['U']=7;c['V']=9;c['W']=9;c['X']=11;
        c['Y']=13;c['Z']=11;c['?']=15;c['!']=19;

        Scanner s = new Scanner(System.in);
        int casos = s.nextInt();
        s.nextLine();

        while (casos-- > 0) {
            String[] palabras = s.nextLine().split(" ");
            int total = 0;

            for (int i = 0; i < palabras.length; i++) {
                if (i > 0) total += 5;
                for (int j = 0; j < palabras[i].length(); j++) {
                    if (j > 0) total += 3;
                    total += c[palabras[i].charAt(j)];
                }
            }
            System.out.println(total);
        }
    }
}