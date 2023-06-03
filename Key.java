import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Key representa una llave en el juego.
 * Esta clase hereda de la clase ScrollingActor.
 * Cuando el personaje interactúa con la llave, se le asigna la propiedad "key" al personaje y la llave se elimina del mundo.
 * 
 * Author CristopherRms
 * Version 1.0
 */
public class Key extends ScrollingActor
{
    /**
     * Método act. Define el comportamiento de la llave.
     * Este método se ejecuta automáticamente cuando se presiona el botón "Act" o "Run" en el entorno.
     */
    public void act()
    {
        // Verifica si el personaje está intersectando con la llave
        Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
        if (p != null) {
            // Asigna la propiedad "key" al personaje
            p.key = true;
            
            // Elimina la llave del mundo
            getWorld().removeObject(this);
        }
    }
}
