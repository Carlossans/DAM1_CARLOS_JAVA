String diasEnUnMes(int mes) {
    
    return switch (mes) {
        case 1 -> "31";
        case 2 -> "28";
        case 3 -> "31";
        case 4 -> "30";
        case 5 -> "31";
        case 6 -> "30";
        case 7 -> "31";
        case 8 -> "31";
        case 9 -> "30";
        case 10 -> "31";
        case 11 -> "30";
        case 12 -> "31";
        default -> "Ese mes no existe chaval";
    };

}

void validarNumero(int mes ) {

    if (mes >= 1 && mes <= 12) {
        String result = diasEnUnMes(mes);
        IO.println(String.format("\nEl mes %d tiene %s días", mes, result));
    } else {
        IO.println("\n FORMATO NO VÁLIDO DEBES DE INTRODUCIR UN NÚMERO");
    }
}

void main() {

    int mes = Integer.parseInt(IO.readln("\nIntroduce el número de un mes (0-12): "));
    validarNumero(mes);

}
