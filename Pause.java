import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pausa el juego
 */
public class Pause extends Button
{
    /**
     * Act - do whatever the Pause wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        check_mouse();
        if (Greenfoot.mouseClicked(this)){
         ((Level1)getWorld()).paraSonido();
         Greenfoot.stop();
         
        }
    }
}
