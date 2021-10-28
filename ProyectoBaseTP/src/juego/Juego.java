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
        this.velociraptor.dibujarse(entorno);
        	
        //Movimiento de los velociraptor
        //Pisos: (4) 92.5, (3) 212.5, (2) 332.5, (1) 452.5, (0) 572.5 (La mitad de la altura del velociraptor se suma la mitad del alto del piso, y eso se resta a la posicion "Y" del piso actual)
        
        //Piso 4 y 3
        if (velociraptor.getX() < 600) {
        	velociraptor.mover(); //Por predeterminado se mueve a la derecha, por eso no le asigno direccion
        } else if(velociraptor.getY() < 212.5) { // Al piso actual se le resta 35, 15 del ancho del piso y 20 de la mitad del alto del velociraptor		
        	velociraptor.setTrayectoria('v');   		  	 	
        	velociraptor.mover();   	
        	velociraptor.setTrayectoria('h');		
        	velociraptor.mover();      	
        } else if (!velociraptor.chocaConEntorno(entorno)) {	
        	velociraptor.mover();
		} else {
			velociraptor.cambiarDireccionMovimiento();	
			velociraptor.mover();			 
		}
        //Piso 3 y 2
        if (velociraptor.getY() >= 212.5 && velociraptor.getX() <= 200) {        
        	if (velociraptor.getY() < 332.5){
        		velociraptor.setTrayectoria('v');       		                 	
        		velociraptor.mover();
        		velociraptor.setTrayectoria('h');
        		velociraptor.cambiarDireccionMovimiento();
        	} else if (velociraptor.getY() == 332.5 && velociraptor.chocaConEntorno(entorno)) {    	         		
        			velociraptor.setTrayectoria('h');        		
        	}    	       	 	
        }
        //Piso 2 y 1
        //...
        
        //Piso 1 y 0
        //...
     
		laser = velociraptor.disparar();	
		laser.dibujarse(entorno);
		laser.mover(); 
        
        entorno.cambiarFont(Font.SANS_SERIF, 20, Color.orange);
        entorno.escribirTexto("X: " + velociraptor.getX() + " Y: " + velociraptor.getY(), 400, 50);
        entorno.escribirTexto("Choca con entorno: " + velociraptor.chocaConEntorno(entorno), 400, 100);
    
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
