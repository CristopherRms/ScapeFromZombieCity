import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Button (Botón)
 * 
 * Esta clase representa un botón en el juego.
 * @autor CristopherRms
 * @version 1.0.
 */
public class Button extends Actor {
    private boolean mouseOver = false;
    public static final int MAX = 225;

    /**
     * Verifica si el mouse está encima del botón.
     */
    public void checkMouse() {
        if (Greenfoot.mouseMoved(null)) {
            mouseOver = Greenfoot.mouseMoved(this);
        }
        if (mouseOver) {
            adjustTransparency(MAX / 3);
        } else {
            adjustTransparency(MAX);
        }
    }

    /**
     * Ajusta la transparencia del botón.
     * 
     * @param ajust El valor de ajuste de transparencia.
     */
    public void adjustTransparency(int ajust) {
        GreenfootImage temp = getImage();
        temp.setTransparency(ajust);
        setImage(temp);
    }
}

