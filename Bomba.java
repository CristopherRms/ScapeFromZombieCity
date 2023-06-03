import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Esta clase representa un objeto Bomba en el juego.
 * La bomba explota después de cierto tiempo y daña a los enemigos cercanos
 * @autor CristopherRms
 * @version 1.0.
 */
public class Bomba extends Actor {
    private int tiempoExplosion; // Tiempo hasta que la bomba explote en ciclos act
    private int velocidad; // Velocidad del proyectil
    protected int dano; // Daño causado por la explosión

    /**
     * Constructor de la clase Bomba.
     * Establece el tiempo de explosión predeterminado.
     */
    public Bomba() {
        tiempoExplosion = 50;
    }

    /**
     * Este método se llama cuando se actúa el objeto Bomba.
     * Mueve la bomba en su dirección actual y maneja la explosión.
     */
    public void act() {
        boolean res = true;
        if (isAtEdge()) {
            // Elimina el proyectil si llega al borde del mundo
            getWorld().removeObject(this);
            res = false;
        } else {
            // Mueve el proyectil en su dirección actual
            move(velocidad);
        }

        if (tiempoExplosion > 0) {
            tiempoExplosion--;
        }

        if (tiempoExplosion == 0) {
            Greenfoot.playSound("bomba.mp3");
            explotar();
            getWorld().removeObject(this);
        }
    }

    /**
     * Establece la dirección de la bomba para moverse hacia la derecha.
     */
    public void moverDerecha() {
        // Establece la velocidad del proyectil para moverse hacia la derecha
        velocidad = 6;
    }

    /**
     * Establece la dirección de la bomba para moverse hacia la izquierda.
     */
    public void moverIzquierda() {
        // Establece la velocidad del proyectil para moverse hacia la izquierda
        velocidad = -6;

        // Rota el proyectil para que mire hacia la izquierda
    }

    /**
     * Explota y daña a los enemigos cercanos.
     * Daña a los enemigos dentro de un rango especificado y crea un efecto visual de explosión.
     */
    private void explotar() {
        // Lógica de la explosión de la bomba
        List<Enemigo> vecinos = getNeighbours(200, true, Enemigo.class);
        for (Enemigo vecino : vecinos) {
            vecino.life -= 100;
        }
        getWorld().addObject(new Explosion(), getX(), getY());
    }
}


