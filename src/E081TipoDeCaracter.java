String darTipoDecarácter(char c) {

    if (c >= 'a' && c <= 'z') {
        return " Es una letra minúscula";
    } else if (c >= 'A' && c <= 'Z') {
        return  " Una letra mayúscula";
    } else if (c >= '0' && c <= '9') {
        return " Un Dígito";
    }

    return switch (c) {
        case ',', '.', '-', '(', ')', '¡', '!', '¿', '?' -> " Un Símbolo";
        default -> " No se que tipo de carácter es";
    };
}
void main() {
    char c;
    
    do {
        c = IO.readln("\nIntroduce un carácter y si quieres salir introduce \">\": ").replaceAll("\\s" , "").charAt(0);
        IO.println(String.format("El carácter %c es un: %S", c, darTipoDecarácter(c)));
    } while (c != '>');
}
