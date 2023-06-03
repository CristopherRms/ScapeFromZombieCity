import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase HTP (How To Play - Cómo Jugar)
 * 
 * Esta clase representa un botón para abrir el escenario donde se encuentran los controles del juego.
 * @autor CristopherRms
 * @version 1.0.
 */
public class HTP extends Button {

    /**
     * Actúa cuando se hace clic en el botón.
     * Cambia el mundo al escenario de controles.
     */
    public void act() {
        checkMouse();
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Controls());
        }
    }
}

