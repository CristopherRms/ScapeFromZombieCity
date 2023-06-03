import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase PowerProjectile representa un proyectil poderoso en el juego.
 * Cuando el personaje interactúa con el proyectil poderoso, se le asigna el tipo de proyectil 2.
 * También se reproduce un sonido de power-up y se elimina el proyectil del mundo.
 * Además, se establece un tiempo de duración para el proyectil poderoso en el personaje.
 * 
 * Autor CristopherRms
 * Versión 1.0
 */
public class PowerProjectile extends ScrollingActor
{
    /**
     * Método act. Define el comportamiento del proyectil poderoso.
     * Este método se ejecuta automáticamente cuando se presiona el botón "Act" o "Run" en el entorno.
     */
    public void act()
    {
        // Verifica si el personaje está intersectando con el proyectil poderoso
        Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
        if (p != null) {
            // Asigna al personaje el tipo de proyectil 2
            p.tipoProjectil = 2;
            
            // Reproduce un sonido de power-up
            Greenfoot.playSound("power_up.mp3");
            
            // Elimina el proyectil del mundo
            getWorld().removeObject(this);
            
            // Establece un tiempo de duración para el proyectil poderoso en el personaje
            p.setTimeProjectile(30*60);
        }
    }
}

