import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controls extends World
{

    
    private GreenfootImage backgroundImage = new GreenfootImage("Como jugar.jpg");
    private String t;
    
    /**
     * Constructor for objects of class Controls.
     * 
     */
    public Controls()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels 
        super(800, 600, 1); 
        setBackground(backgroundImage);
        
        MenuGO m=new MenuGO();
        
        addObject(m,400,550);
    }
}
