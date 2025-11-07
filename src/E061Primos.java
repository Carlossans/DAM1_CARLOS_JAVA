void main () {
    int n = 0;

    n = Integer.parseInt(IO.readln("\nIntroduce el número donde tiene que parar de comprobar si es primo o no: ").replaceAll("\\s" , ""));
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