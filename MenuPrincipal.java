import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuPrincipal extends World
{
    private Start b;
    private GreenfootImage backgroundImage = new GreenfootImage("sfzzc.jpg");
    /**
     * Constructor for objects of class MenuPrincipal.
     * 
     */
    public MenuPrincipal()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        setBackground(backgroundImage);
        b=new Start();

        addObject(b,400,500);        
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
