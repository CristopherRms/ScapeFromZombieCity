import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Easy (Fácil)
 * 
 * Esta clase representa un botón para establecer el juego en modo fácil.
 * @autor CristopherRms
 * @version 1.0.
 */
public class Easy extends Button {

    /**
     * Actúa cuando se hace clic en el botón.
     * Cambia el mundo a una configuración de dificultad fácil.
     */
    public void act() {
        checkMouse();
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new One(10, 3, 5, 0));
        }
    }
}

