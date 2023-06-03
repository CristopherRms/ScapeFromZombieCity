import greenfoot.*;

/**
 * Clase Humanoide (Humanoide)
 * 
 * Esta clase es la clase padre de todos los personajes del juego.
  * @autor CristopherRms
 * @version 1.0
 */
public abstract class Humanoide extends Actor {
    protected GreenfootImage[] walkingDFrames;
    protected GreenfootImage[] walkingIFrames;
    protected GreenfootImage[] attackDFrames;
    protected GreenfootImage[] attackIFrames;
    protected int currentFrame;
    protected int animationSpeed;
    protected int animationCounter;
    protected int vy;
    public int life;
    protected int direction; // 1 = derecha, -1 = izquierda
    protected boolean modeAttack;
    
    /**
     * Actúa cuando se ejecuta el acto.
     * Este método debe ser implementado por las clases hijas.
     */
    public void act(){
        
    }
    
    /**
     * Realiza la animación del personaje.
     */
    private void animate() {
        
    }

    /**
     * Devuelve el frame actual de la animación.
     */
    private GreenfootImage getCurrentFrame() {
        return null;
    }

    /**
     * Aplica la gravedad al personaje.
     */
    public void gravedad() {
        
    }

    /**
     * Realiza el ataque del personaje.
     */
    private void atacar() {
    }
}
