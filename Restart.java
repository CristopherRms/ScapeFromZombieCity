import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Restart (Reiniciar)
 * 
 * Esta clase representa un botón que permite reiniciar desde el nivel 1 con una configuración específica.
 * @autor CristopherRms
 * @version 1.0.
 */
public class Restart extends Button {
    private int A;
    private int B;
    private int C;

    /**
     * Constructor de la clase Restart.
     * 
     * @param a Valor para el parámetro A del nivel 1
     * @param b Valor para el parámetro B del nivel 1
     * @param c Valor para el parámetro C del nivel 1
     */
    public Restart(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    /**
     * Actúa cuando se hace clic en el botón.
     * Reinicia el juego desde el nivel 1 con la configuración especificada.
     */
    public void act() {
        checkMouse();
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new One(A, B, C, 0));
        }
    }
}

