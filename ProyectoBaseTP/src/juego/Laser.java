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
		e.dibujarCirculo(this.x, this.y, this.radio, Color.YELLOW);
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

	public boolean chocaConBarbarianna(Barbariana b) {
		return Math.sqrt(Math.pow(b.getX() - this.x, 2) + (Math.pow(b.getY() - this.y, 2))) <= this.radio * 2;
	}
	
}
