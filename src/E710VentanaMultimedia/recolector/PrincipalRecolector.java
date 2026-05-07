package E710VentanaMultimedia.recolector;

import b700proyecto.E710VentanaMultimedia.multimedia.Teclado;
import b700proyecto.E710VentanaMultimedia.multimedia.Ventana;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PrincipalRecolector {
    private static final int DELAY = 50;
    private static final int TICKS_MOVIMIENTO = 20;

    public static void main(String[] args) {
        Ventana ventana = new Ventana("Juego Recolector", 20, 20, 30, Color.DARK_GRAY);
        Teclado teclado = ventana.getTeclado();

        int posJugadorX = 10, posJugadorY = 10;
        int puntuacion = 0;
        int posObjetivoX = 5, posObjetivoY = 5;
        int contadorTicks = 0;

        BufferedImage imgJugador = ventana.cargarImagen("src/b700proyecto/E710VentanaMultimedia/recursos/raton.png");
        BufferedImage imgObjetivo = ventana.cargarImagen("src/b700proyecto/E710VentanaMultimedia/recursos/manzana.png");

        while (true) {
            teclado.tick();
            ventana.limpiar();

            if (teclado.pulsada1Vez(KeyEvent.VK_LEFT) && posJugadorX > 0) posJugadorX--;
            if (teclado.pulsada1Vez(KeyEvent.VK_RIGHT) && posJugadorX < ventana.getAncho() - 1) posJugadorX++;
            if (teclado.pulsada1Vez(KeyEvent.VK_UP) && posJugadorY > 0) posJugadorY--;
            if (teclado.pulsada1Vez(KeyEvent.VK_DOWN) && posJugadorY < ventana.getAlto() - 1) posJugadorY++;

            contadorTicks++;
            if (contadorTicks >= TICKS_MOVIMIENTO) {
                posObjetivoX += (int) (Math.random() * 3) - 1;
                posObjetivoY += (int) (Math.random() * 3) - 1;

                posObjetivoX = Math.max(0, Math.min(ventana.getAncho() - 1, posObjetivoX));
                posObjetivoY = Math.max(0, Math.min(ventana.getAlto() - 1, posObjetivoY));

                contadorTicks = 0;
            }

            if (posJugadorX == posObjetivoX && posJugadorY == posObjetivoY) {
                puntuacion++;
                posObjetivoX = (int) (Math.random() * ventana.getAncho());
                posObjetivoY = (int) (Math.random() * ventana.getAlto());
            }

            if (imgObjetivo != null) {
                ventana.dibujarImagen(posObjetivoX, posObjetivoY, imgObjetivo);
            } else {
                ventana.marcarPixel(posObjetivoX, posObjetivoY, Color.RED);
            }

            if (imgJugador != null) {
                ventana.dibujarImagen(posJugadorX, posJugadorY, imgJugador);
            } else {
                ventana.marcarPixel(posJugadorX, posJugadorY, Color.GREEN);
            }

            ventana.escribirTexto(0, 0, "Puntos: " + puntuacion, Color.WHITE);

            ventana.volcar();

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}