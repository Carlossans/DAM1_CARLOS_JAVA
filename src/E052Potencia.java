//Crea un método double calcularPotencia(double base, int exponente) que reciba dos números, base y exponente y devuelva el resultado de la base elevada al exponente (sin usar la función Math.pow(); es decir, queremos crear nuestra propia versión de Math.pow).

void calcualrPotencia (double base, int exponente) {
    double potencia = 1;

    for (int i = 1; i <= exponente; i++) {
        potencia = potencia * base;
    }

    IO.println("\nEl resultado de la potencia es: " + potencia);

}

void main () {
    double base = 0; 
    int exponente = 0;
    boolean valido;

    do {
        try {
            base = Double.parseDouble(IO.readln("\nIntroduce el valor de la base: ").replaceAll("\\s", ""));

            exponente = Integer.parseInt(IO.readln("\nIntroduce el valor del esponente: ").replaceAll("\\s" , ""));
            valido = true;

        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO");
            valido = false;
        }
    } while (!valido);

    calcualrPotencia(base, exponente);
}