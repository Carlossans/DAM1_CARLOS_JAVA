package E325Frase;

public class Frase {
    private StringBuilder texto;

    // Constructor por defecto - texto vacío
    public Frase() {
        this.texto = new StringBuilder();
    }

    // Constructor con String inicial
    public Frase(String cadena) {
        this.texto = new StringBuilder(cadena);
    }

    // Constructor con repeticiones
    public Frase(int repeticiones, String cadena) {
        this();  // Llamo al constructor por defecto primero

        for (int i = 0; i < repeticiones; i++) {
            if (i > 0) {  // Si no es la primera, añado espacio antes
                texto.append(" ");
            }
            texto.append(cadena);
        }
    }

    // Método para obtener el caracter en una posición
    public char caracterEn(int posicion) {
        return texto.charAt(posicion);
    }

    // Método para saber cuántos caracteres tiene
    public int longitud() {
        return texto.length();
    }

    // Método para añadir una cadena con espacio antes (si no está vacío)
    public void anexar(String cadena) {
        if (!texto.isEmpty()) { // texto.length() > 0
            texto.append(" ");
        }
        texto.append(cadena);
    }

    // Método para recortar caracteres del final
    public void recortar(int numCaracteres) {
        // Calculo la nueva longitud
        int nuevaLongitud = texto.length() - numCaracteres;

        // Me aseguro de que no sea negativo
        if (nuevaLongitud < 0) {
            nuevaLongitud = 0;
        }

        // Cambio la longitud con setLength
        this.texto.setLength(nuevaLongitud);

        // Si al final queda un espacio, lo quito
        if (nuevaLongitud > 0 && this.texto.charAt(nuevaLongitud - 1) == ' ') {
            this.texto.setLength(nuevaLongitud - 1);
        }
    }

    // Método toString - para convertir a String normal
    public String toString() {
        return texto.toString();
    }

    // Método equals - para comparar dos Frases
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