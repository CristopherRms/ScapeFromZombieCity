import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Line here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Line extends ScrollingActor
{
    /**
     * Act - do whatever the Line wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
            if (p != null) {
                ((Three)getWorld()).terminaNivel();
                
            }
    }
}
