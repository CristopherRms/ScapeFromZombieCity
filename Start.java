import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Start (Inicio)
 * 
 * Esta clase representa un botón de inicio para comenzar el juego.
 * @autor CristopherRms
 * @version 1.0.
 */
public class Start extends Button {
    private boolean mouseOver = false;

    /**
     * Actúa cuando se mueve el mouse o se hace clic en el botón.
     */
    public void act() {
        if (Greenfoot.mouseMoved(null)) {
            mouseOver = Greenfoot.mouseMoved(this);
        }
        if (mouseOver) {
            setImage("green_image.png");
        } else {
            setImage("PRESS START.png");
        }
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Menu());
        }
    }
}

