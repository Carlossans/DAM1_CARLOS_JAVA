void main () {
    contarVocales();
}

void contarVocales () {
    String palabra = IO.readln("\nIntrodcuce una palabra y el programa contará las vocales que tiene: ").replaceAll("\\s" , "").toLowerCase();

    int caracteres = palabra.length();

    for (int i = 0; i < caracteres; i++) {
        if (palabra.charAt(i) == 'a' | palabra.charAt(i) == 'á') {
            IO.println(String.format("\nSe ha encontrado la vocal 'a' en la posición %d", i + 1));
        } else if (palabra.charAt(i) == 'e' | palabra.charAt(i) == 'é') {
            IO.println(String.format("\nSe ha encontrado la vocal 'e' en la posición %d", i + 1));
        } else if (palabra.charAt(i) == 'i' | palabra.charAt(i) == 'í') {
            IO.println(String.format("\nSe ha encontrado la vocal 'i' en la posición %d", i + 1));
        } else if (palabra.charAt(i) == 'o' | palabra.charAt(i) == 'ó') {
            IO.println(String.format("\nSe ha encontrado la vocal 'o' en la posición %d", i + 1));
        } else if (palabra.charAt(i) == 'u' | palabra.charAt(i) == 'ú' | palabra.charAt(i) == 'ü') {
            IO.println(String.format("\nSe ha encontrado la vocal 'u' en la posición %d", i + 1));
        }
    }


}