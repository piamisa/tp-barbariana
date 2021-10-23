package juego;

import entorno.Entorno;

import java.awt.*;

public class Fondo {

    private int x, y;
    private double ancho, alto;
    
    public Fondo(int x, int y, double ancho, double alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public void dibujarse(Entorno e) {
    	e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.WHITE);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

}
