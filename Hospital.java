import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Hospital representa un hospital en el juego.
 * Esta clase hereda de la clase ScrollingActor.
 * El hospital se puede activar si el personaje tiene la llave correspondiente.
 * Cuando el personaje interactúa con el hospital, se llama al método terminaNivel() del mundo para finalizar el nivel.
 * 
 * Author CristopherRms
 * Version 1.0
 */
public class Hospital extends ScrollingActor
{
    private boolean t=false;
    
    /**
     * Método act. Define el comportamiento del hospital.
     * Este método se ejecuta automáticamente cuando se presiona el botón "Act" o "Run" en el entorno.
     */
    public void act()
    {
        // Verifica si el personaje está intersectando con el hospital
        Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
        if (p != null && t == false && p.key == true) {
            t = true;
            // Llama al método terminaNivel() del mundo para finalizar el nivel
            ((One)getWorld()).terminaNivel();  
        }
    }
}
