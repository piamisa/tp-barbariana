package juego;


import java.awt.Color;
import java.awt.Font;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
    // El objeto Entorno que controla el tiempo y otros
    private Entorno entorno;
    private Fondo fondo;
    private Computadora computadora;
    private Velociraptor velociraptor;
    private Laser laser;
    private int puntos = 0;


    // Variables y métodos propios de cada grupo
    // ...

    Juego() {
        // Inicializa el objeto entorno
        this.entorno = new Entorno(this, "Castlevania, Barbarianna Viking Edition - Grupo 7 - v1", 800, 600);

        // Inicializar lo que haga falta para el juego

        this.fondo = new Fondo(0,0,entorno.ancho(), 15);

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
    /**
     *
     */
    public void tick() {
        // Procesamiento de un instante de tiempo

        //Pisos y fondo

        this.fondo.dibujarWallpaper(entorno);

        this.fondo.dibujarPisos(entorno, 4);

        //Computadora
        this.computadora.dibujarse(entorno);

        //Velociraptor

        this.velociraptor.dibujarImagen(entorno);
        	

        //Movimiento de los velociraptor
        //Pisos: 92.5, 212.5, 332.5, 452.5, 572.5s  (La mitad de la altura del velociraptor se suma la mitad del alto del piso, y eso se resta a la posicion "Y" del piso actual)
        
        if (velociraptor.getX() < 620) { //620 = 600 del ancho del piso + 20 de la mitad de ancho del velociraptor
        	velociraptor.mover();
        } else {	
        	if (velociraptor.getY() < 212.5) {  // Al piso actual se le resta 35, 15 del ancho del piso y 20 de la mitad del alto del velociraptor	
        		velociraptor.setTrayectoria('v');	
        	} else {	

        		velociraptor.setTrayectoria('h');
        	}
        	if (velociraptor.getX() < entorno.ancho() - velociraptor.getAncho() / 2) {
        		velociraptor.mover();		//Por predeterminado se mueve a la derecha, por eso no le asigno direccion
        	} else {
        		velociraptor.cambiarDireccionMovimiento();
        	}

        	if (velociraptor.getX() < 780) {
        		velociraptor.mover();
        	}	
        }

		laser = velociraptor.disparar();
		
		laser.dibujarse(entorno);
	
		laser.mover(); 
        
        entorno.cambiarFont(Font.SANS_SERIF, 20, Color.orange);
        entorno.escribirTexto("X: " + velociraptor.getX() + " Y: " + velociraptor.getY() , 600, 50);

    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
