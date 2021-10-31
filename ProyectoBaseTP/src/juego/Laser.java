package juego;

import java.awt.Color;

import entorno.Entorno;

public class Laser {

	private int x, y;
	private double radio, factorMovimiento, angulo;
	
	public Laser(int x, int y, double angulo) {
		
		this.x = x;	
		this.y = y;	
		this.radio = 15;		
		this.factorMovimiento = 10;	
		this.angulo = angulo;
	}
	
	public void dibujarse(Entorno e) {		
		e.dibujarCirculo(this.x, this.y, this.radio, Color.RED);	
	}
	
	public void mover() {	
		this.x += this.factorMovimiento * Math.cos(this.angulo);	
	}
	
	public boolean chocaConEntorno(Entorno e) {
		return (this.x < this.radio/2 || this.x > e.ancho() - this.radio/2);	
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}	
	
/*	public boolean chocaConBarbarianna(Barbarianna b) { 

		
		...
		
	}
	
	*/
	
	
	
}
