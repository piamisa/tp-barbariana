package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
    // El objeto Entorno que controla el tiempo y otros
    private Entorno entorno;
    //	private Fondo fondo;
    private Computadora computadora;
    private Velociraptor velociraptor;
    private Laser laser;
    private Fondo[] pisos;
    private Fondo base;
    private int puntos = 0, piso = 4;
    
    // Variables y métodos propios de cada grupo
    // ...

    Juego() {
        // Inicializa el objeto entorno
        this.entorno = new Entorno(this, "Boss Rabbit Rabber - Grupo 7. - v1", 800, 600);

        // Inicializar lo que haga falta para el juego

        //Pisos: 135, 250, 365, 480 (Se puede modificar)

        pisos = new Fondo[4];
        int arranque = 135;
        for (int i = 0; i < pisos.length; i++) {
            if (i % 2 != 0) {
                pisos[i] = new Fondo(entorno.ancho() / 2 + 200, arranque, entorno.ancho(), 15);
                arranque += 115;
            } else {
                pisos[i] = new Fondo(entorno.ancho() / 2 - 200, arranque, entorno.ancho(), 15);
                arranque += 115;
            }
        }

        //Base: 480 + 115 = 595

        base = new Fondo(entorno.ancho() / 2, 595, entorno.ancho(), 15);

        //Computadora
        this.computadora = new Computadora(70, 95, 80, 80);
        
        //Velociraptor
        this.velociraptor = new Velociraptor();
    
        // Inicia el juego!
        this.entorno.iniciar();
    }

    /**
     * Durante el juego, el método tick() será ejecutado en cada instante y
     * por lo tanto es el método más importante de esta clase. Aquí se debe
     * actualizar el estado interno del juego para simular el paso del tiempo
     * (ver el enunciado del TP para mayor detalle).
     */
    public void tick() {
        // Procesamiento de un instante de tiempo
    	
    	//Pisos y fondo
    	entorno.dibujarRectangulo(entorno.ancho()/2, entorno.alto()/2, entorno.ancho(), entorno.alto(), 0, Color.darkGray);

        //entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/brick_wall.png"), entorno.ancho()/2, entorno.alto()/2, 0);


        for (int i = 0; i < pisos.length; i++) {
            pisos[i].dibujarse(entorno);
        }
        
        this.base.dibujarse(entorno);
        
        //Computadora
        this.computadora.dibujarse(entorno);
        
        //Velociraptor
        this.velociraptor.dibujarse(entorno);
        	
        //Movimiento de los velociraptor

        if (velociraptor.getX() < entorno.ancho() - velociraptor.getAncho() / 2) {
        	velociraptor.mover();
        } else {
        	velociraptor.cambiarDireccionMovimiento();
        	velociraptor.setY(velociraptor.getY() + 115);
        	piso--;
          }
        if (velociraptor.getX() > velociraptor.getAncho() / 2) {
        	velociraptor.mover();
        } else {
        	velociraptor.cambiarDireccionMovimiento();
        	velociraptor.setY(velociraptor.getY() + 115);  
        	piso--;
        }
        
	/*	laser = velociraptor.disparar();
		
		laser.dibujarse(entorno);
	
		laser.mover(); */
        
        entorno.escribirTexto("Piso: " + piso , 700, 50);
        
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
