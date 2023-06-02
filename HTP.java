import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abre el ecenario donde estan los controles
 */
public class HTP extends Button
{
    
    public void act()
    {
        check_mouse();
        if (Greenfoot.mouseClicked(this))
         Greenfoot.setWorld(new Controls());
    }
}
