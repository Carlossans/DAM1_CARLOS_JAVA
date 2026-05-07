package b700proyecto.E710VentanaMultimedia.multimedia.recolector;

import b700proyecto.E710VentanaMultimedia.multimedia.Teclado;
import b700proyecto.E710VentanaMultimedia.multimedia.Ventana;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PrincipalRecolector {
    private static final int DELAY = 50; // Milisegundos

    public static void main(String[] args) {
        // Creamos una cuadrícula de 20x20, donde cada "píxel" mide 30 píxeles reales.
        Ventana ventana = new Ventana("Juego Recolector", 20, 20, 30, Color.DARK_GRAY);
        Teclado teclado = ventana.getTeclado();

        // Variables del jugador
        int posJugadorX = 10, posJugadorY = 10;
        int puntuacion = 0;

        // Variables del objetivo (manzana)
        int posObjetivoX = 5, posObjetivoY = 5;

        // Carga de imágenes (asegúrate de tener estas imágenes en la carpeta raíz del proyecto)
        // Si no hay imagen, el método no falla (devuelve null) y podemos pintar un color como plan B.
        BufferedImage imgJugador = ventana.cargarImagen("src/b700proyecto/E710VentanaMultimedia/recursos/raton.png");
        BufferedImage imgObjetivo = ventana.cargarImagen("src/b700proyecto/E710VentanaMultimedia/recursos/manzana.png");

        while (true) {
            teclado.tick();
            ventana.limpiar();

            // 1. LÓGICA DE MOVIMIENTO (Controlador)
            // Usamos pulsada1Vez para que el movimiento sea casilla a casilla (tipo Sokoban/PacMan clásico)
            if (teclado.pulsada1Vez(KeyEvent.VK_LEFT) && posJugadorX > 0) posJugadorX--;
            if (teclado.pulsada1Vez(KeyEvent.VK_RIGHT) && posJugadorX < ventana.getAncho() - 1) posJugadorX++;
            if (teclado.pulsada1Vez(KeyEvent.VK_UP) && posJugadorY > 0) posJugadorY--;
            if (teclado.pulsada1Vez(KeyEvent.VK_DOWN) && posJugadorY < ventana.getAlto() - 1) posJugadorY++;

            // 2. LÓGICA DE COLISIÓN Y ESTADO (Modelo)
            if (posJugadorX == posObjetivoX && posJugadorY == posObjetivoY) {
                puntuacion++;
                // Reposicionamos el objetivo aleatoriamente
                posObjetivoX = (int) (Math.random() * ventana.getAncho());
                posObjetivoY = (int) (Math.random() * ventana.getAlto());
            }

            // 3. RENDERIZADO (Vista)
            // Pintamos el objetivo
            if (imgObjetivo != null) {
                ventana.dibujarImagen(posObjetivoX, posObjetivoY, imgObjetivo);
            } else {
                ventana.marcarPixel(posObjetivoX, posObjetivoY, Color.RED); // Plan B si no hay imagen
            }

            // Pintamos el jugador
            if (imgJugador != null) {
                ventana.dibujarImagen(posJugadorX, posJugadorY, imgJugador);
            } else {
                ventana.marcarPixel(posJugadorX, posJugadorY, Color.GREEN); // Plan B
            }

            // Marcador de puntuación
            ventana.escribirTexto(0, 0, "Puntos: " + puntuacion, Color.WHITE);

            ventana.volcar();
        }
    }
}