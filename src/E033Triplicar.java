static int duplicar(int n) {
    return 3 * n;
}
void main() {
    int numero = Integer.parseInt(IO.readln("\nIntroduce un número: ").replaceAll("\\s" , ""));
    int triple = duplicar(numero);
    IO.println("\n" + triple);
}