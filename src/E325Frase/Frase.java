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

        for (int i = 0; i < repeticiones; i++) {
            if (i > 0) {
                texto.append(" ");
            }
            texto.append(cadena);
        }
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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Frase otraFrase = (Frase) obj;
        return this.texto.toString().equals(otraFrase.texto.toString());
    }

    public Frase clone() {
        Frase clone = new Frase();
        clone.texto = new StringBuilder(this.texto);
        return clone;
    }
}