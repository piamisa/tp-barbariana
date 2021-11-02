package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Laser {

	private int x, y;
	private double radio, factorMovimiento, angulo;
	private Image im;
	
	public Laser(int x, int y, double angulo) {
		this.x = x;	
		this.y = y;	
		this.radio = 10;		
		this.factorMovimiento = 10;	
		this.angulo = angulo;
		im = Herramientas.cargarImagen("imagenes/laser.png");
	}
	
	public void dibujarse(Entorno e) {		
		e.dibujarCirculo(this.x, this.y, this.radio, Color.YELLOW);
	}
	
	public void dibujarLaser(Entorno e) {
		e.dibujarImagen(im, this.x, this.y, this.angulo, 0.15);
	}
	
	public void mover() {
		this.x += this.factorMovimiento * Math.cos(this.angulo);//Derecha:angulo 0, cos(angulo) = 1, Izquierda:angulo 180, cos(angulo) = -1			
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
