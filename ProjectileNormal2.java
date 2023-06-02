import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProjectileNormal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProjectileNormal2 extends Projectile2
{ 
    public ProjectileNormal2(int a){
        dano=a;
    }
    
    /**
     * Act - do whatever the ProjectileNormal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        proyectil();
    }
}
