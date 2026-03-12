package E305RelojHMBasico;

import com.ibm.icu.text.RuleBasedNumberFormat;
import java.util.Locale;


public abstract class RelojTextual extends Reloj{

public RelojTextual(int h, int m) {
    super(h, m);
}

public static class RelojEspaniol extends RelojTextual {

    private static final String[] NOMBRES = {
                "doce", "una", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez",
                "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve", "veinte",
                "veintiuno", "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve", "treinta",
                "treinta y uno", "treinta y dos", "treinta y tres", "treinta y cuatro", "treinta y cinco", "treinta y seis", "treinta y siete", "treinta y ocho", "treinta y nueve", "cuarenta",
                "cuarenta y uno", "cuarenta y dos", "cuarenta y tres", "cuarenta y cuatro", "cuarenta y cinco", "cuarenta y seis", "cuarenta y siete", "cuarenta y ocho", "cuarenta y nueve", "cincuenta",
                "cincuenta y uno", "cincuenta y dos", "cincuenta y tres", "cincuenta y cuatro", "cincuenta y cinco", "cincuenta y seis", "cincuenta y siete", "cincuenta y ocho", "cincuenta y nueve"
        };

        public RelojEspaniol(int h, int m) { super(h, m); }

        public String toString() {
            int hora12 = getH() % 12; // Obtener hora ne formato 12h

            String textoH; // Convierte la hora a palabras
            if (hora12 == 1) {
                textoH = "la una";
            } else {
                textoH = "las " + NOMBRES[hora12];
            }

            if (getM() == 0) { // 3 Caso especial: hora en punto
                return "Son " + textoH;
            }

            // 4 Convertir los minutos a palabras con la excepción del minuto 1
            String textoM = NOMBRES[getM()];
            if (getM() == 1) textoM = "uno";
             // 5 Devuelve la frase
            return "Son " + textoH + " y " + textoM ;
        }
    }

    public static class RelojIngles extends RelojTextual {

        private static RuleBasedNumberFormat formatter =
                new RuleBasedNumberFormat(Locale.ENGLISH, RuleBasedNumberFormat.SPELLOUT);

        public RelojIngles(int h, int m) { super(h, m); }

        public String toString() {

            int hora12 = getH() % 12; // 1. Hora en formato 12h
            if (hora12 == 0) hora12 = 12; // Ajuste: 0 se convierte en 12

            String textoH = formatter.format(hora12); // 2. Convertir hora a texto

            if (getM() == 0) { // 3. Hora en punto
                return "It is " + textoH + " o'clock";
            }

            String textoM = formatter.format(getM()); // 4. Convertir minutos a texto

            return "It is " + textoH + " " + textoM; // 5. Frase completa
        }
    }
}
