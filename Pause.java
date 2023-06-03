import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Pause (Pausa)
 * 
 * Esta clase representa un botón que permite pausar el juego.
 * @autor CristopherRms
 * @version 1.0.
 */
public class Pause extends Button {

    /**
     * Actúa cuando se hace clic en el botón.
     * Pausa el juego y detiene los sonidos.
     */
    public void act() {
        checkMouse();
        if (Greenfoot.mouseClicked(this)) {
            ((Level1)getWorld()).paraSonido();
            Greenfoot.stop();
        }
    }
}
