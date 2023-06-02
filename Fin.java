import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mundo para el Final del juego
 */
public class Fin extends World
{
    private GreenfootImage backgroundImage = new GreenfootImage("Fin.jpg");
    private String t;
    /**
     * Constructor for objects of class Fin.
     * 
     */
    public Fin(int p)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels 
        super(800, 600, 1); 
        setBackground(backgroundImage);
        t=""+ p;
        showText(t,600,190);
        MenuGO m=new MenuGO();
        
        addObject(m,400,500);
    }
}
