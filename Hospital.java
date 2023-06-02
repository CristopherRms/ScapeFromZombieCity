import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hospital here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hospital extends ScrollingActor
{
    private boolean t=false;
    /**
     * Act - do whatever the Hospital wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
            if (p != null&&t==false&& p.key==true) {
                t=true;
                ((One)getWorld()).terminaNivel();  
            }
    }
}
