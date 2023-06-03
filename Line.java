import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Line representa una línea en el juego.
 * Esta clase hereda de la clase ScrollingActor.
 * Cuando el personaje interactúa con la línea, se llama al método terminaNivel() del mundo para finalizar el nivel.
 * 
 * Author CristopherRms
 * Version 1.0
 */
public class Line extends ScrollingActor
{
    /**
     * Método act. Define el comportamiento de la línea.
     * Este método se ejecuta automáticamente cuando se presiona el botón "Act" o "Run" en el entorno.
     */
    public void act()
    {
        // Verifica si el personaje está intersectando con la línea
        Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
        if (p != null) {
            // Llama al método terminaNivel() del mundo para finalizar el nivel
            ((Three)getWorld()).terminaNivel();
        }
    }
}
