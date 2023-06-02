import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pone una animacion a la expllosion de la bomba
 */
public class Explosion extends Actor
{
    private GreenfootImage[] Frame;
    protected int currentFrame;
    protected int animationSpeed;
    protected int animationCounter;
    private int t =50;
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Explosion(){
    Frame= new GreenfootImage[4];
        Frame[0] = new GreenfootImage("ep1.png");
        Frame[1] = new GreenfootImage("ep2.png");
        Frame[2] = new GreenfootImage("ep3.png");
        Frame[3] = new GreenfootImage("ep4.png");
        currentFrame = 0;
        animationSpeed = 15;
        animationCounter = 0;
    }
    private void animate() {
        animationCounter++;
        if (animationCounter >= animationSpeed) {
            currentFrame = (currentFrame + 1) % 4;
            setImage(getCurrentFrame());
            animationCounter = 0;
        }
    }
    private GreenfootImage getCurrentFrame(){
        return Frame[currentFrame];
    }
    public void act()
    {
        animate();
        if(t>0){
            t--;
        }
        
        if (t==0) {
            
            getWorld().removeObject(this);
        }// Add your action code here.
    }
}
