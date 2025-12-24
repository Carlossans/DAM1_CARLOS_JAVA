void main() {
    int numero = 0, sumatotal = 0, numsIntroducidos = 0, media = 0;
    boolean valido;

    IO.println("Introduce numeros: ");

    do  {
        try {
            numero = Integer.parseInt(IO.readln("\n").replaceAll("\\s" , ""));
            if (numero != 0) {
                sumatotal = sumatotal + numero;
                numsIntroducidos++;
            }
            media = sumatotal / numsIntroducidos;
            valido= true;
        } catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO.");
            valido = false;
        }
    } while (!valido | numero != 0);

    IO.println("\nLa media ponderada es: " + media);
}