package juego;

import entorno.Entorno;

import java.awt.*;

public class Fondo {

    private int x, y;
    private int ancho, alto;

    public Fondo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void dibujarPisos(Entorno entorno){
        //Planta Baja
        entorno.dibujarRectangulo(entorno.ancho()/2, 590, 800.0, 15.0,0, Color.WHITE);

        //Primer piso
        entorno.dibujarRectangulo(300, 450, entorno.ancho() - 200, 15, 0, Color.WHITE);

        //Segundo Piso
        entorno.dibujarRectangulo(500, 310 , entorno.ancho() - 200, 15, 0 ,Color.WHITE);

        //Tercer Piso
        entorno.dibujarRectangulo(300, 170, entorno.ancho() - 200, 15, 0, Color.WHITE);
    }


}
