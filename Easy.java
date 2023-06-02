import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pone el juego en dificultad Facil
 */
public class Easy extends Button
{
    
    public void act()
    {
        check_mouse();
        if (Greenfoot.mouseClicked(this))
         Greenfoot.setWorld(new One(10,3,5,0));
         
    }
}
