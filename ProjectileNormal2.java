import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase ProjectileNormal2 es una subclase de Projectile2 y representa un segundo tipo de proyectil normal en el juego.
 * Esta clase hereda de la clase Projectile2.
 * 
 * @author CristopherRms
 * @version 1.0
 */
public class ProjectileNormal2 extends Projectile2
{ 
    /**
     * Constructor de la clase ProjectileNormal2.
     * @param a El daño del proyectil.
     */
    public ProjectileNormal2(int a){
        dano=a;
    }
    
    /**
     * Método act. Define el comportamiento de ProjectileNormal2.
     * Este método se ejecuta automáticamente cuando se presiona el botón "Act" o "Run" en el entorno.
     */
    public void act()
    {
        proyectil();
    }
}

