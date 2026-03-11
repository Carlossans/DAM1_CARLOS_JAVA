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
            // Convertimos formato 24h a 12h: (13 -> 1, 0 -> 0)
            int hora12 = getH() % 12;

            // El artículo y el nombre de la hora
            String textoH;
            if (hora12 == 1) {
                textoH = "la una";
            } else {
                // Si hora12 es 0, NOMBRES[0] es "doce"
                textoH = "las " + NOMBRES[hora12];
            }

            // Si los minutos son 0, terminamos aquí
            if (getM() == 0) {
                return "Son las" + textoH;
            }

            // Para los minutos, usamos el nombre directo del array
            String textoM = NOMBRES[getM()];

            // Ajuste gramatical para el minuto 1
            if (getM() == 1) textoM = "uno";

            return "Son " + textoH + " y " + textoM ;
        }
    }

    public static class RelojIngles extends RelojTextual {

        private static RuleBasedNumberFormat formatter =
                new RuleBasedNumberFormat(Locale.ENGLISH, RuleBasedNumberFormat.SPELLOUT);

        public RelojIngles(int h, int m) {
            super(h, m);
        }

        @Override
        public String toString() {

            int hora12 = getH() % 12;
            if (hora12 == 0) hora12 = 12;

            String textoH = formatter.format(hora12);

            if (getM() == 0) {
                return "It is " + textoH + " o'clock";
            }

            String textoM = formatter.format(getM());

            return "It is " + textoH + " " + textoM;
        }
    }
}
