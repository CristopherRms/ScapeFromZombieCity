import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inmunity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inmunity extends ScrollingActor
{
    private int tiempoInmunidad=10*60;
    /**
     * Act - do whatever the Inmunity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Personaje p = (Personaje)getOneIntersectingObject(Personaje.class);
            if (p != null) {
                // Reducir la vida del zombie en un 50%
                p.setInmune(tiempoInmunidad);
                Greenfoot.playSound("power_up.mp3");
                getWorld().removeObject(this);

            }
    }
}
