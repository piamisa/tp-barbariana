package juego;

import java.awt.Color;
import entorno.*;

public class Velociraptor {

	private double x, y, ancho, alto;

	private double angulo, factorMovimiento;

	private char trayectoria, direccionMovimiento; /* trayectoria = h (horizontal), v: (vertical);
													  direccionMovimiento = v: s (sur); direccionMovimiento = h: i (izquierda) /d (derecha) */
	public Velociraptor() {

		this.x = 140.0;
		this.y = 108.5;

		this.ancho = 40.0;
		this.alto = 40.0;

		this.factorMovimiento = 1;
		this.angulo = 0;

		this.trayectoria = 'h';
		this.direccionMovimiento = 'd';

	}

	public void setTrayectoria(char trayectoria) {

		if (trayectoria != 'v' && trayectoria != 'h') {

			throw new RuntimeException ("La trayectoria no es valida");

		} else {

			this.trayectoria = trayectoria;

			if (trayectoria == 'h') {

				this.angulo = Math.toRadians(0);

			} else {

				this.angulo = Math.toRadians(90);

			}

		}

	}

	public void setDireccionMovimiento(char c) {

		if (c != 'i' && c != 'd' && c != 's') {

			throw new RuntimeException ("La direccion especificada es incorrecta");

		}

		if (this.trayectoria == 'v') {

			if (c == 's') {

				this.direccionMovimiento = c;

				Math.toRadians(90);

			}

		} else if (this.trayectoria == 'h') {

			if (c == 'i' || c == 'd') {

				this.direccionMovimiento = c;

				this.angulo = Math.toRadians(0);

				if (c == 'i') {

					angulo += Math.toRadians(180);

				}

			} else {

				throw new RuntimeException("La trayectoria y la direccion de movimiento no coinciden");

			}

		}

	}

	public static int posicionVelociraptorNulo(Velociraptor[] velociraptors) {

		int i = 0;

		while (i < velociraptors.length) {

			if (velociraptors[i] == null) {

				return i;

			}

			i++;

		}

		return -1;

	}

	public void cambiarDireccionMovimiento() {

		if (this.direccionMovimiento == 'd') {

			this.setDireccionMovimiento('i');

			return; //Cuando y = 108.5 + (115 * 4) y haga el cambio de direccion se tiene que eliminar el objeto

		} else if (this.direccionMovimiento == 'i') {

			this.setDireccionMovimiento('d');

			return;

		}

	}

/*	public static void crearVelociraptors() {



	} */

	// USO CONTINUO

	public void dibujarse(Entorno e) {

		e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, this.angulo, Color.cyan);

	}

	public void mover() {

		if (this.trayectoria == 'v') {

			y += Math.sin(this.angulo) * this.factorMovimiento;

		} else {

			x += Math.cos(this.angulo) * this.factorMovimiento;

		}

	}

	public Laser disparar() {
		
		if (this.direccionMovimiento == 'd') {
			
			return new Laser((int)this.x , (int)this.y, this.angulo); // x++
			
		} else {
			
			return new Laser((int)this.x, (int)this.y, this.angulo); // x--
			
		}

	}

	public double getX() {

		return x;

	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {

		return y;

	}

	public void setY(double y) {
		
		this.y = y;
		
	}

	public double getAncho() {

		return ancho;

	}

	public double getAlto() {

		return alto;

	}

}
