void calcularHipotenusa (double cateto1, double cateto2) {
    double hipotenusa = 0;

    hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));

    IO.println("\nLa hipotenusa es: " + hipotenusa);

}

void main() {
    double cateto1 = 0, cateto2 = 0, hipotenusa = 0;
    boolean valido;

    do {
        try {

            cateto1 = Double.parseDouble(IO.readln("\nIntroduce el valor del primer cateto: ").replaceAll("\\s", ""));

            cateto2 = Double.parseDouble(IO.readln("\nIntroduce el valor del segundo cateto: ").replaceAll("\\s", ""));
            valido = true;

        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO");
            valido = false;
        }
    } while (!valido);
    
    calcularHipotenusa(cateto1, cateto2);
}