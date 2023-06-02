import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pone el juego en dificultad Dificil
 */
public class Hard extends Button
{
    
    public void act()
    {
        check_mouse();
        if (Greenfoot.mouseClicked(this))
         Greenfoot.setWorld(new One(20,10,15,0));
    }
}
