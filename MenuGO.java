import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase MenuGO (Menu Game Over - Menú de fin de juego)
 * 
 * Esta clase representa un botón que permite ir al menú principal desde el juego.
 * @autor CristopherRms
 * @version 1.0.
 */
public class MenuGO extends Button {

    /**
     * Actúa cuando se hace clic en el botón.
     * Cambia el mundo al menú principal.
     */
    public void act() {
        checkMouse();
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MenuPrincipal());
        }
    }
}
