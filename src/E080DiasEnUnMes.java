String darDiasDeMes(int mes) {
    return switch (mes) {
        case 1, 3, 5, 7, 8, 10, 12 -> "31";
        case 4, 6, 9, 11 -> "30";
        case 2 -> "28";
        default -> "Ese mes no existe chaval";
    };
}

void validarNumero(int mes) {
    if (mes >= 1 && mes <= 12) {
        IO.println(String.format("\nEl mes %d tiene %s días", mes, darDiasDeMes(mes)));
    } else if (mes == 0) {
        IO.println("\nADIOSSSS");
    } else {
        IO.println("\nDEBES DE INTRODUCIR UN NÚMERO DENTRO DEL RANGO ESPECIFICADO ");
    }
}

void main() {
    int mes;
    do {
        mes = Integer.parseInt(IO.readln("\nIntroduce el número de un mes (1-12) \"0 para salir\" : "));
        validarNumero(mes);
    } while (mes != 0);
}
