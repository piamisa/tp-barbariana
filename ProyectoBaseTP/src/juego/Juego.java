package juego;


import entorno.Entorno;
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

        base = new Fondo(entorno.ancho() / 2, 595, entorno.ancho(), 20);

//		this.fondo = new Fondo(0, 0, 800, 15, 200);

        this.computadora = new Computadora(70, 90, 80, 80);
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

        //	this.fondo.dibujarPisos(entorno);

        for (int i = 0; i < pisos.length; i++) {
            pisos[i].dibujarse(entorno);
        }

        this.base.dibujarse(entorno);
        this.computadora.dibujarse(entorno);
        this.velociraptor.dibujarse(entorno);

        //Movimiento de los velociraptor

        if (velociraptor.getX() < entorno.ancho() - velociraptor.getAncho() / 2) {
            velociraptor.mover();
        } else {
            velociraptor.cambiarDireccionMovimiento();
        }
        if (velociraptor.getX() > velociraptor.getAncho() / 2) {
            velociraptor.mover();
        } else {
            velociraptor.cambiarDireccionMovimiento();
        }
		
	/*	laser = velociraptor.disparar();
		
		laser.dibujarse(entorno);
		
		laser.mover(); */

    }


    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
