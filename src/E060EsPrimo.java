void main () {
    int numeros = 0;

    validarNumero(numeros);

}
void validarNumero (int numeros) {
    boolean valido;
    
    do {
        try {
            numeros = Integer.parseInt(IO.readln("\nIntroduce el número que quieras comprobar si es primo: ").replaceAll("\\s" , ""));
            valido = true;
        } catch (NumberFormatException comprobacion) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODUCIR UN NÚMERO");
            valido = false;
        }
    } while (!valido);

    if (esPrimo(numeros)) {
        IO.println(String.format("\nEl número %d SI es primo", numeros));
    } else {
        IO.println(String.format("\nEl número %d NO es primo", numeros));
    }

}

boolean esDivisible (int dividendo, int divisor) {

    if (dividendo % divisor == 0) {
        return true;
    } else {
        return false;

    }

}

boolean esPrimo (int numero) {

    if (numero < 2) return false;
    for (int i = 2; i <= numero - 1; i++) {
        if (esDivisible(numero, i)) {
            return false;
        }
    }
    return true;
}