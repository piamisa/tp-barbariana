package juego;

import entorno.Entorno;

public class Rayo {

    private int x, y;
    private int ancho, alto;

    public Rayo(int x, int y) {
        this.x = x;
        this.y = y;
        this.ancho = 25;
        this.alto = 15;
    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, null);
    }

    public void mover(boolean d) {
        if (d) {
            x += 8;
        } else {
            x -= 8;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getAncho() {
    	return ancho;
    }
    
    public int getAlto() {
    	return alto;
    }
    
    public boolean chocaConVelociraptor(Velociraptor v) {
		return Math.sqrt(Math.pow(v.getX() - this.x, 2) + (Math.pow(v.getY() - this.y, 2))) <= this.ancho* 2;
	}
}

