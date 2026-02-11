package E325Frase;

public class Frase {
    private StringBuilder texto;

    public Frase() {
        this.texto = new StringBuilder();
    }

    public Frase(String cadena) {
        this.texto = new StringBuilder(cadena);
    }

    public Frase(int repeticiones, String cadena) {
        this();

        anexar(repeticiones, cadena);
    }

    public char caracterEn(int posicion) {
        return texto.charAt(posicion);
    }

    public int longitud() {
        return texto.length();
    }

    public void anexar(String cadena) {
        if (!texto.isEmpty()) {
            texto.append(" ");
        }
        texto.append(cadena);
    }

    public void anexar(int repeticiones, String cadena) {
        for (int i = 0; i < repeticiones; i++) {
            if (!texto.isEmpty()) {
                texto.append(" ");
            }
            texto.append(cadena);
        }
    }

    public void recortar(int numCaracteres) {
        int nuevaLongitud = texto.length() - numCaracteres;

        if (nuevaLongitud < 0) {
            nuevaLongitud = 0;
        }

        this.texto.setLength(nuevaLongitud);

        if (nuevaLongitud > 0 && this.texto.charAt(nuevaLongitud - 1) == ' ') {
            this.texto.setLength(nuevaLongitud - 1);
        }
    }

    public String toString() {
        return texto.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Frase otraFrase)) return false;

        return this.texto.toString().contentEquals(otraFrase.texto);
    }

    public Frase clone() {
        Frase clone = new Frase();
        clone.texto = new StringBuilder(this.texto);
        return clone;
    }
}