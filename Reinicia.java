import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Reinicia el nivel o va al menu
 */
public class Reinicia extends World
{

    private GreenfootImage backgroundImage = new GreenfootImage("GameOver.jpg");
    
    /**
     * Constructor
     */
    public Reinicia(int a,int b,int c)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels 
        super(800, 600, 1); 
        setBackground(backgroundImage);
        Restart e=new Restart(a,b,c);
        MenuGO m=new MenuGO();
        addObject(e,200,400);
        addObject(m,600,400);
    }
}
