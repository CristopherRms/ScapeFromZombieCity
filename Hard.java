import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Hard (Difícil)
 * 
 * Esta clase representa un botón para establecer el juego en modo difícil.
 * @autor CristopherRms
 * @version 1.0.
 */
public class Hard extends Button {

    /**
     * Actúa cuando se hace clic en el botón.
     * Cambia el mundo a una configuración de dificultad difícil.
     */
    public void act() {
        checkMouse();
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new One(20, 10, 15, 0));
        }
    }
}
