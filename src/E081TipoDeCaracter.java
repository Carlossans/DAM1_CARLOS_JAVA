String darTipoDeCaracter(char c) {

    if (c >= 'a' && c <= 'z') {
        return " Es una letra minúscula";
    } else if (c >= 'A' && c <= 'Z') {
        return  " Una letra mayúscula";
    }

    return switch (c) {
        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> " Un Dígito";
        case ',', '.', '-', '(', ')', '¡', '!', '¿', '?' -> " Un Símbolo";
        default -> " No se que es eso";
    };
}
void main() {
    char c;

    do {
        c = IO.readln("\nIntroduce un caracter y si quieres salir introduce \">\": ").replaceAll("\\s" , "").charAt(0);
        IO.println(String.format("El caracter %c es un: %S", c, darTipoDeCaracter(c)));
    } while (c != '>');
}
