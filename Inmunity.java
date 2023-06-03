import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Inmunity representa una inmunidad en el juego.
 * Esta clase hereda de la clase ScrollingActor.
 * Cuando el personaje interactúa con la inmunidad, se le otorga un tiempo de inmunidad y se reproduce un sonido.
 * Después de la interacción, la inmunidad se elimina del mundo.
 * 
 * Author CristopherRms
 * Version 1.0
 */
public class Inmunity extends ScrollingActor
{
    private int tiempoInmunidad = 10 * 60;
    
    /**
     * Método act. Define el comportamiento de la inmunidad.
     * Este método se ejecuta automáticamente cuando se presiona el botón "Act" o "Run" en el entorno.
     */
    public void act()
    {
        // Verifica si el personaje está intersectando con la inmunidad
        Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
        if (p != null) {
            // Otorga al personaje un tiempo de inmunidad
            p.setInmune(tiempoInmunidad);
            
            // Reproduce un sonido
            Greenfoot.playSound("power_up.mp3");
            
            // Elimina la inmunidad del mundo
            getWorld().removeObject(this);
        }
    }
}
