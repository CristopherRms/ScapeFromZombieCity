import greenfoot.*;
/**
 * Clase padre de todos los personajes del juego
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
    
    public void act() {

    }
    
    private void animate() {

    }

    private GreenfootImage getCurrentFrame() {
        return null;
    }

    public void gravedad() {
        
    }

    private void atacar() {

    }
}