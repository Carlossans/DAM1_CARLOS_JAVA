static void decirHolaInsistentemente() {
    IO.println("\nHOLA");
}

void main() {
    int cantidad;

    cantidad = Integer.parseInt(IO.readln("\n¿Cuántas veces quieres que se repita? ").replaceAll("\\s" , ""));

    for (int i = 1; i <= cantidad; i++) {
        decirHolaInsistentemente();
    }
}