import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Explosion (Explosión)
 * 
 * Esta clase representa una animación de explosión para la bomba.
 * @autor CristopherRms
 * @version 1.0
 */
public class Explosion extends Actor {
    private GreenfootImage[] frames;
    private int currentFrame;
    private int animationSpeed;
    private int animationCounter;
    private int timer = 50;

    /**
     * Constructor de la clase Explosion.
     * Crea y configura los frames de la animación de la explosión.
     */
    public Explosion() {
        frames = new GreenfootImage[4];
        frames[0] = new GreenfootImage("ep1.png");
        frames[1] = new GreenfootImage("ep2.png");
        frames[2] = new GreenfootImage("ep3.png");
        frames[3] = new GreenfootImage("ep4.png");
        currentFrame = 0;
        animationSpeed = 15;
        animationCounter = 0;
    }

    /**
     * Realiza la animación de la explosión.
     */
    private void animate() {
        animationCounter++;
        if (animationCounter >= animationSpeed) {
            currentFrame = (currentFrame + 1) % 4;
            setImage(getCurrentFrame());
            animationCounter = 0;
        }
    }

    /**
     * Devuelve el frame actual de la animación.
     */
    private GreenfootImage getCurrentFrame() {
        return frames[currentFrame];
    }

    /**
     * Actúa cuando se ejecuta el acto.
     * Realiza la animación de la explosión y se elimina después de un tiempo.
     */
    public void act() {
        animate();
        if (timer > 0) {
            timer--;
        }
        if (timer == 0) {
            getWorld().removeObject(this);
        }
    }
}
