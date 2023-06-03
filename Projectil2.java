import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Projectil2 es una subclase de Projectile y representa un segundo tipo de proyectil en el juego.
 * Esta clase hereda de la clase Projectile.
 * 
 * @author CristopherRms
 * @version 1.0
 */
public class Projectil2 extends Projectile
{
    /**
     * Constructor de la clase Projectil2.
     * Establece el daño del proyectil a 50.
     */
    public Projectil2(){
        dano=50;
    }
    
    /**
     * Método act. Define el comportamiento de Projectil2.
     * Este método se ejecuta automáticamente cuando se presiona el botón "Act" o "Run" en el entorno.
     */
    public void act()
    {
        proyectil();
    }
}

