package juego;

import entorno.Entorno;

import java.awt.*;

public class Fondo {

    private int x, y;
    private double ancho, alto, vacio;

    public Fondo(int x, int y, double ancho, double alto, double vacio) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.vacio = vacio;
    }
    
    //PRUEBA
    
    public Fondo(int x, int y, double ancho, double alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        
    }



//    public void dibujarPisos(Entorno entorno){
//
//        //PB
//        entorno.dibujarRectangulo(entorno.ancho() / 2, entorno.alto() - this.alto, ancho, alto, 0, Color.WHITE);
//
//        //1P
//        entorno.dibujarRectangulo((entorno.ancho() - vacio) / 2, entorno.alto() - (entorno.alto() / 4) - this.alto, ancho - vacio, alto, 0, Color.WHITE);
//
//        //2P
//        entorno.dibujarRectangulo((entorno.ancho() + vacio) / 2, entorno.alto() - (entorno.alto() / 4) * 2 - this.alto, ancho - vacio, alto, 0, Color.WHITE);
//
//        //3P
//        entorno.dibujarRectangulo((entorno.ancho() - vacio) / 2, entorno.alto() - (entorno.alto() / 4) * 3 - this.alto, ancho - vacio, alto, 0, Color.WHITE);
//
//        //4P
//        entorno.dibujarRectangulo((entorno.ancho() + vacio) / 2, entorno.alto() - this.alto, ancho - vacio, alto, 0, Color.WHITE);
//
//    }
    
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
