import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Life representa una vida extra en el juego.
 * Esta clase hereda de la clase ScrollingActor.
 * Cuando el personaje interactúa con una vida extra, se le asigna el valor 100 a la propiedad "life" del personaje,
 * y la vida extra se elimina del mundo.
 * 
 * Author CristopherRms
 * Version 1.0
 */
public class Life extends ScrollingActor
{
    /**
     * Método act. Define el comportamiento de la vida extra.
     * Este método se ejecuta automáticamente cuando se presiona el botón "Act" o "Run" en el entorno.
     */
    public void act()
    {
        // Verifica si el personaje está intersectando con la vida extra
        Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
        if (p != null) {
            // Asigna el valor 100 a la propiedad "life" del personaje
            p.life = 100;
            
            // Reproduce el sonido de "power_up"
            Greenfoot.playSound("power_up.mp3");
            
            // Elimina la vida extra del mundo
            getWorld().removeObject(this);
        }
    }
}
