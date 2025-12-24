static int duplicar(int n) {
    return 2 * n;
}
void main() {
    int numero = Integer.parseInt(IO.readln("\nIntroduce un número: ").replaceAll("\\s" , ""));
    int doble = duplicar(numero);
    IO.println("\n" + doble);
}
