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
    private Veloci[] veloci;
    private Barbariana barba;
    private Rayo rayo;
    //private Velociraptor velociraptor;
    private Laser laser;
    private int puntos = 0;
    private boolean r = false;
    private boolean d = true;
    private boolean a = true;
    private int cont = 0;
    private  int num = 1;


    // Variables y métodos propios de cada grupo
    // ...

    Juego() {
        // Inicializa el objeto entorno
        this.entorno = new Entorno(this, "Castlevania, Barbarianna Viking Edition - Grupo 7 - v1", 800, 600);

        // Inicializar lo que haga falta para el juego

        this.fondo = new Fondo(0,0,entorno.ancho(), 15);

        //Computadora
        this.computadora = new Computadora(70, 80, 80, 80);

        //Barbariana
        this.barba = new Barbariana(100, entorno.alto() - 40);
        //Velociraptor
        this.veloci = new Veloci[5];
        for(int i = 0; i < veloci.length; i++){
            this.veloci[i] = new Veloci(150, 102);
        }
       // this.velociraptor = new Velociraptor();

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

        //Barbariana
        this.barba.dibujarse(entorno);

        //Movimiento Barbariana
        if (barba.getX() < entorno.ancho() - 10) {
            if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
                barba.moverDerecha();
                this.d = true;

            }
        }



        if (barba.getX() > 10) {
            if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
                barba.moverIzquierda();
                this.d = false;
            }
        }

        //Salto Barbariana
        if(barba.getX() > 110 && barba.getX() < 210 && (barba.getY() == 560 || barba.getY() == 330)){
            if(entorno.sePresiono(entorno.TECLA_ARRIBA)){
                barba.saltarDerecha();
            }
        }

        if(barba.getX() > 600 && barba.getX() < 700 && (barba.getY() == 445 || barba.getY() == 215)){
            if(entorno.sePresiono(entorno.TECLA_ARRIBA)){
                barba.saltarIzquierda();
            }
        }

        //Caida en el vacio

        if(barba.getX() < 200 && (barba.getY() == 445 || barba.getY() == 215)){
            barba.caer();
        }
        if(barba.getX() > 600 && (barba.getY() == 100 || barba.getY() == 330)){
            barba.caer();
        }


        //Rayo

        if(entorno.sePresiono(entorno.TECLA_ABAJO)) {
            this.rayo = new Rayo(barba.getX(), barba.getY());
            this.a = this.d;
            this.r = true;

        }

        if(this.r) {
            this.rayo.dibujarse(entorno);
            rayo.mover(a);
        }
        //Velociraptor

        for(int i = 0; i < num; i++){
            if (this.veloci[i] != null)
                this.veloci[i].dibujarse(entorno);
        }

        if (num < 5){
            if (cont >= 1000){
                num += 1;
                cont = 0;
            } else {
                cont += 1;
            }
        }
        //cuando lleguen la posicion final se borran del arreglo y se tienen que volver a crear

        for(int i = 0; i < num; i++){
            if (this.veloci[i] != null)
                this.veloci[i].mover();
        }


        //this.velociraptor.dibujarImagen(entorno);


        //Movimiento de los velociraptor
        //Pisos: 92.5, 212.5, 332.5, 452.5, 572.5s  (La mitad de la altura del velociraptor se suma la mitad del alto del piso, y eso se resta a la posicion "Y" del piso actual)
/*
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

		laser = velociraptor.disparar();*/
		
		//laser.dibujarse(entorno);
	
		//laser.mover();
        
        entorno.cambiarFont(Font.SANS_SERIF, 20, Color.orange);
        entorno.escribirTexto("X: " + barba.getX() + " Y: " + barba.getY() , 600, 50);


    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
