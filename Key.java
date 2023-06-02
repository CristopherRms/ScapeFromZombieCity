import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends ScrollingActor
{
    /**
     * Act - do whatever the Key wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
            if (p != null) {
                // Reducir la vida del zombie en un 50%
                p.key=true;
                getWorld().removeObject(this);
                
            }
    }


}
