void main() {
    int cantidad;

    cantidad = Integer.parseInt(IO.readln("¿Cuántos números desea introducir?").replaceAll("\\s" , ""));

    IO.println("\nIntroduce los números a continuación: ");
    for (int i = 1; i >= cantidad; i++) {
        IO.readln();
    }
}