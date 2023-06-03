import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Door representa una puerta en el juego.
 * Esta clase hereda de la clase ScrollingActor.
 * La puerta se puede activar si el personaje tiene la llave correspondiente.
 * Cuando el personaje interactúa con la puerta, se llama al método terminaNivel() del mundo para finalizar el nivel.
 * 
 * Author CristopherRms
 * Version 1.0
 */
public class Door extends ScrollingActor
{
    private boolean t=false;

    /**
     * Método act. Define el comportamiento de la puerta.
     * Este método se ejecuta automáticamente cuando se presiona el botón "Act" o "Run" en el entorno.
     */
    public void act()
    {
        // Verifica si el personaje está intersectando con la puerta
        Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
        if (p != null && t == false && p.key == true) {
            t = true;
            // Llama al método terminaNivel() del mundo para finalizar el nivel
            ((Two)getWorld()).terminaNivel();  
        }
    }
}

