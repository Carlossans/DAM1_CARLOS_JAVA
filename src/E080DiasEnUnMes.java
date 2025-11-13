String diasEnUnMes(int mes) {

    return switch (mes) {
        case 0 -> "";
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
        IO.println(String.format("\nEl mes %d tiene %s días", mes, diasEnUnMes(mes)));
    } else if (mes == 0) {
        IO.println("\nADIOSSSS");
    } else {
        IO.println("\n FORMATO NO VÁLIDO DEBES DE INTRODUCIR UN NÚMERO");
    }
}

void main() {
    int mes = 0;

    do {
        mes = Integer.parseInt(IO.readln("\nIntroduce el número de un mes (1-12) \"0 para salir\" : "));
        validarNumero(mes);
    } while (mes != 0);

}
