import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase ProjectileNormal es una subclase de Projectile y representa un tipo de proyectil normal en el juego.
 * Esta clase hereda de la clase Projectile.
 * 
 * @author CristopherRms
 * @version 1.0
 */
public class ProjectileNormal extends Projectile
{ 
    /**
     * Constructor de la clase ProjectileNormal.
     * Establece el daño del proyectil a 15.
     */
    public ProjectileNormal(){
        dano=15;
    }
    
    /**
     * Método act. Define el comportamiento de ProjectileNormal.
     * Este método se ejecuta automáticamente cuando se presiona el botón "Act" o "Run" en el entorno.
     */
    public void act()
    {
        proyectil();
    }
}

