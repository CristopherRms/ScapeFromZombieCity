import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pone el juego en dificultad Media
 */
public class Medium extends Button
{
    public void act()
    {
        check_mouse();
        if (Greenfoot.mouseClicked(this)) 
         Greenfoot.setWorld(new One(15,6,10,0));
    }
}
