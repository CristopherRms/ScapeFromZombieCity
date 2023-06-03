import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Medium (Media)
 * 
 * Esta clase representa un botón para establecer el juego en modo medio.
 * @autor CristopherRms
 * @version 1.0.
 */
public class Medium extends Button {

    /**
     * Actúa cuando se hace clic en el botón.
     * Cambia el mundo a una configuración de dificultad media.
     */
    public void act() {
        checkMouse();
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new One(15, 6, 10, 0));
        }
    }
}
