import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
public class Bomba extends Actor {
    private int tiempoExplosion ; // Tiempo de explosión en ciclos act()
    
    private int velocidad; // velocidad del proyectil
    protected int dano;
    /**
     * Constructor
     */
    public Bomba(){
        tiempoExplosion=50;
    }
    
    public void act() {
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
        if(tiempoExplosion>0){
            tiempoExplosion--;
        }
        
        if (tiempoExplosion==0) {
            Greenfoot.playSound("bomba.mp3");
            explotar();
            getWorld().removeObject(this);
        }
        
        
    }
    /**
     * establace la direccion a la que se muev
     */
    public void moverDerecha()
    {
        // Establece la velocidad del proyectil hacia la derecha
        velocidad = 6;
    }
    
    public void moverIzquierda()
    {
        // Establece la velocidad del proyectil hacia la izquierda
        velocidad = -6;
        
        // Gira el proyectil hacia la izquierda
        
    }
    /**
     *Explota y elimina a los enemigos cercanos 
     */
    private void explotar() {
        // Lógica de explosión de la bomba
        List<Enemigo> vecinos = getNeighbours(200, true, Enemigo.class);
        for (Enemigo vecino : vecinos) {
            vecino.life-=100;
        }
        getWorld().addObject(new Explosion(), getX(), getY());
        
    }
}

