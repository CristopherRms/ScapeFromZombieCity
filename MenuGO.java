import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Va al menu
 */
public class MenuGO extends Button
{
    
    public void act()
    {
        check_mouse();
        if (Greenfoot.mouseClicked(this))
         Greenfoot.setWorld(new MenuPrincipal());
    }
}
