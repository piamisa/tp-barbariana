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
    private Velociraptor[] velociraptor;
    private Laser[] laser;
    private int cont = 0, num = 1;
    
    // Variables y métodos propios de cada grupo
    // ...

    Juego() {
        // Inicializa el objeto entorno
        this.entorno = new Entorno(this, "Castlevania, Barbarianna Viking Edition - Grupo 7 - v1", 800, 600);

        // Inicializar lo que haga falta para el juego

        this.fondo = new Fondo(0,0,entorno.ancho(), 15);

        //Computadora
        this.computadora = new Computadora(70, 80);

        //Velociraptor
        this.velociraptor = new Velociraptor[5];
        for (int i = 0; i < velociraptor.length; i++) {
        	this.velociraptor[i] = new Velociraptor(); 	
        }
        
        //Laser
        this.laser = new Laser[5]; 
        
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
        for (int i = 0; i < velociraptor.length; i++) {
        	if (this.velociraptor[i] != null) {	        		        				
        		this.velociraptor[i].dibujarse(entorno);
        	}
        }
        
        if (num < 5) {
        	if (cont >= 250) {
        		num++;
        		cont = 0;	
        	} else {
        		cont++;
        	}   	
        }
 
        //Movimiento de los velociraptor
        for (int i = 0; i < num; i++) {
        	if (this.velociraptor[i] != null) {
        		//Pisos: (4) 92.5, (3) 212.5, (2) 332.5, (1) 452.5 (La mitad de la altura del velociraptor se suma la mitad del alto del piso, y eso se resta a la posicion "Y" del piso actual)               
                if (velociraptor[i].getX() < 600 && (velociraptor[i].getY() >= 92.5 || velociraptor[i].getY() >= 332.5)) {
                	velociraptor[i].mover(); //Por predeterminado se mueve a la derecha, por eso no le asigno direccion
                } else if(velociraptor[i].getY() < 212.5) { // Al piso actual se le resta 35, 15 del ancho del piso y 20 de la mitad del alto del velociraptor		
                	velociraptor[i].setTrayectoria('v');   		  	 	
                	velociraptor[i].mover();   	
                	velociraptor[i].setTrayectoria('h');		
                	velociraptor[i].mover();      	
                } else if (velociraptor[i].getY() < 452.5 && velociraptor[i].getY() >= 332.5) {
                	velociraptor[i].setTrayectoria('v');   		  	 	
                	velociraptor[i].mover();   	
                	velociraptor[i].setTrayectoria('h');		
                	velociraptor[i].mover();              		
                } else if (!velociraptor[i].chocaConEntorno(entorno)) {
                	velociraptor[i].mover();
        		} else {
        			velociraptor[i].cambiarDireccionMovimiento();	
        			velociraptor[i].mover();
        		}
                if ((velociraptor[i].getY() >= 212.5 || velociraptor[i].getY() >= 572.5) && velociraptor[i].getX() <= 200) {        
                	if (velociraptor[i].getY() < 332.5){
                		velociraptor[i].setTrayectoria('v');       		                 	
                		velociraptor[i].mover();
                		velociraptor[i].setTrayectoria('h');
                		velociraptor[i].cambiarDireccionMovimiento();
                	} else if (velociraptor[i].getY() < 563.5 && velociraptor[i].getY() >= 452.5) {
                		velociraptor[i].setTrayectoria('v');       		                 	
                		velociraptor[i].mover();
                		velociraptor[i].setTrayectoria('h');
                		velociraptor[i].cambiarDireccionMovimiento();
                	} else if (velociraptor[i].chocaConEntorno(entorno)) {               			
                		velociraptor[i].setTrayectoria('h');             			 		  	 	     	                   	
                	} 
                } 
        	} 		
        	if (velociraptor[i].getY() >= 563.5 && velociraptor[i].getX() >= 760 && velociraptor[i].chocaConEntorno(entorno)) {   			
        		velociraptor[i] = null;       			
        		if (velociraptor[i] == null) {               		
        			velociraptor[i] = new Velociraptor();                
        			velociraptor[i].dibujarse(entorno);   	
        		}			
        	}	 	
        }
        //Laser 
        for (int i = 0; i < velociraptor.length; i++) { 	
        	laser[i] = velociraptor[i].disparar();
        	laser[i].dibujarse(entorno); 	
        }    
        entorno.cambiarFont(Font.SANS_SERIF, 20, Color.orange);     
        entorno.escribirTexto("X: " + velociraptor[0].getX() + " Y: " + velociraptor[0].getY(), 400, 50);
    }
         
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}