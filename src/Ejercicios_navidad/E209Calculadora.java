private static int dividir(int num1, int num2) {
    int res;

    try {
        res = num1 / num2;
    } catch (ArithmeticException e) {
        res = 0;
    }

    return res;
}

private static double calcular(int num1, char operador, int num2) {
    return switch (operador) {
        case '+' -> num1 + num2;
        case '-' -> num1 - num2;
        case '*' -> num1 * num2;
        default -> dividir(num1, num2);
    };
}
void main() {
    int contador = 0;
    IO.println("---- BIENVENIDO A LA CALCULADORA ----");
    IO.println("\nCuando quiera salir deberá de introducir (no) cuando se le pregunte si quiere continuar haciendo operaciones");

    while (true) {
        String continuar = "si";
        if (contador != 0) {
            continuar = IO.readln("\n¿Quieres continuar haciendo operaciones (SI/NO) ?\n").replaceAll("\\s" , "").toLowerCase();

            if (continuar.equals("no")) {
                IO.println("\nChaooo");
                break;
            }
        }

        int numero1 = Integer.parseInt(IO.readln("\nIntroduce el primer número: "));
        char operador = IO.readln("\nIntroduce el caracter que representa a la operación: ").charAt(0);
        int numero2 = Integer.parseInt(IO.readln("\nIntroduce el segundo número: "));

        if (operador == '/') {
            if (numero2 == 0) {
                IO.println("\nNo se puede dividir entre 0, intentalo de nuevo");
            } else {
                IO.println(String.format("\n%.2f", calcular(numero1, operador, numero2)));
                contador++;
            }
        } else {
            IO.println(String.format("\n%.2f", calcular(numero1, operador, numero2)));
            contador++;
        }
    }
}
