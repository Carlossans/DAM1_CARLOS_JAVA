void main () {
    contarVocales();
}

void contarVocales () {
    String palabra = IO.readln("\nIntrodcuce una palabra y el programa contará las vocales que tiene: ").replaceAll("\\s" , "").toLowerCase();

    if (palabra.isEmpty()) {
        IO.println("\nNo has introducido ninguna palabra.");
        return;
    }

    for (int i = 0; i < palabra.length(); i++) {
        char caracter = palabra.charAt(i);
        if (caracter == 'a' | caracter == 'á') {
            IO.println(String.format("La palabra %S tiene la vocal a en la posición %d",palabra, i + 1 ));
        } else if (caracter == 'e' | caracter == 'é') {
            IO.println(String.format("La palabra %S tiene la vocal e en la posición %d",palabra, i + 1 ));
        } else if (caracter == 'i' | caracter == 'í') {
            IO.println(String.format("La palabra %S tiene la vocal i en la posición %d",palabra, i + 1 ));
        } else if (caracter == 'o' | caracter == 'ó') {
            IO.println(String.format("La palabra %S tiene la vocal o en la posición %d",palabra, i + 1 ));
        } else if (caracter == 'u' | caracter == 'ú' | caracter == 'ü') {
            IO.println(String.format("La palabra %S tiene la vocal u en la posición %d",palabra, i + 1 ));
        }
    }
}
