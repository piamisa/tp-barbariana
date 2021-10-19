package juego;

import entorno.Entorno;

import java.awt.*;

public class Computadora {

    private int x, y;
    private int ancho, alto;

    public Computadora(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public void dibujarse(Entorno entorno){
        entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.YELLOW);
    }
}
