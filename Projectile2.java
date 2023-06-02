import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Projectile2 extends Actor {
    private int velocidad; // velocidad del proyectil
    protected int dano;
    public void act(){
        
    }
    public void proyectil(){
        boolean res=true;
        if(isAtEdge())
        {
            // Elimina el proyectil si llega al borde del mundo
            getWorld().removeObject(this);
            res=false;
        }
        else
        {
            // Mueve el proyectil en su dirección actual
            move(velocidad);
        }
        if (res==true){
            // Verifica si el proyectil está tocando a un objeto Zombie
            Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
            if (p != null) {
                // Reducir la vida del zombie en un 50%
                p.life -= dano;
        
                // Elimina el proyectil del mundo
                getWorld().removeObject(this);  
            }
        }
    }
    
    public void moverDerecha()
    {
        // Establece la velocidad del proyectil hacia la derecha
        velocidad = 10;
    }
    
    public void moverIzquierda()
    {
        // Establece la velocidad del proyectil hacia la izquierda
        velocidad = -10;
        
        // Gira el proyectil hacia la izquierda
        
    }
}