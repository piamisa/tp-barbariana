package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
    // El objeto Entorno que controla el tiempo y otros
    private Entorno entorno;
    private Fondo fondo;
    private Computadora computadora;
    private Velociraptor velociraptor;
    private Laser laser;
    //private Fondo[] pisos;
    private Fondo base;
    private Fondo wallpaper;
    private int puntos = 0;
  
    
    // Variables y métodos propios de cada grupo
    // ...

    Juego() {
        // Inicializa el objeto entorno
        this.entorno = new Entorno(this, "Castlevania, Barbarianna Viking Edition - Grupo 7 - v1", 800, 600);

        this.fondo = new Fondo(0,0,entorno.ancho(), 15);

        this.wallpaper = new Fondo(400, 300, 800, 600);

        //Computadora
        this.computadora = new Computadora(70, 80, 80, 80);
        
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

        entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/brick_wall.png"), entorno.ancho()/2, entorno.alto()/2, 0);

        this.fondo.dibujarPisos(entorno, 4);

        //Computadora
        this.computadora.dibujarse(entorno);
        
        //Velociraptor
        this.velociraptor.dibujarse(entorno);
        	
        //Movimiento de los velociraptor
        if (velociraptor.getX() < 620) { //620 = 600 del ancho del piso + 20 de la mitad de ancho del velociraptor
        	velociraptor.mover();
        } else {	
        	if (velociraptor.getY() < 215) {  // Al piso actual se le resta 35, 15 del ancho del piso y 20 de la mitad del alto del velociraptor	
        		velociraptor.setTrayectoria('v');	
        	} else {	
        		velociraptor.setTrayectoria('h');
        	}
        	if (velociraptor.getX() < entorno.ancho() - velociraptor.getAncho() / 2) {	//Condicion para ir a la derecha
        		velociraptor.mover();
        	} else {
        		velociraptor.cambiarDireccionMovimiento();
        	}
        	if (velociraptor.getX() > velociraptor.getAncho() / 2 ) {  //Condicion para ir a la izquierda
        	velociraptor.mover();
        	} else {
        	velociraptor.cambiarDireccionMovimiento();
        	}
        }
	/*	laser = velociraptor.disparar();
		
		laser.dibujarse(entorno);
	
		laser.mover(); */
        
        entorno.escribirTexto("X: " + velociraptor.getX() + " Y: " + velociraptor.getY() , 700, 50);
        
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
